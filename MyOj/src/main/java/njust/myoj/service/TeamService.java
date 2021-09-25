package njust.myoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javafx.util.Pair;
import njust.myoj.entity.Learner;
import njust.myoj.entity.PersonalData;
import njust.myoj.entity.Team;
import njust.myoj.entity.TeamDataAsMember;
import njust.myoj.mapper.LearnerMapper;
import njust.myoj.mapper.TeamDataAsMemberMapper;
import njust.myoj.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author 21
 */
@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    TeamDataAsMemberMapper teamDataAsMemberMapper;
    @Autowired
    LearnerMapper learnerMapper;
    @Autowired
    PersonalDataService personalDataService;
    @Autowired
    LearnerService learnerService;

    public Team createTeam(Team team) {
        QueryWrapper<TeamDataAsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", team.getLid());
        TeamDataAsMember teamDataAsMember = teamDataAsMemberMapper.selectOne(queryWrapper);
        if (teamDataAsMember != null) {
            return null;
        }//如果查询到这个人有小队了，就不能那个啥了
        team.setLevel(1);
        PersonalData leaderData = personalDataService.getPersonalData(team.getLid());
        team.setNumofque(leaderData.getCorrectNum());
        team.setTeamid(Long.toString(System.currentTimeMillis()));
        teamMapper.insert(team);
        //创建teamDataAsMember
        teamDataAsMember = new TeamDataAsMember();
        teamDataAsMember.setTeamid(team.getTeamid());
        teamDataAsMember.setIfleader(true);
        teamDataAsMember.setPid(team.getLid());
        teamDataAsMemberMapper.insert(teamDataAsMember);
        //更新Learner的teamid
        Learner learner = learnerService.getLearnerByID(team.getLid());
        learner.setTeamid(team.getTeamid());
        learnerMapper.updateById(learner);
        return team;
    }

    //别人根据teamid申请加入
    public Integer joinTeam(String teamid, String learnerid) {
        QueryWrapper<Learner> queryWrapperLearner = new QueryWrapper<>();
        queryWrapperLearner.eq("pid", learnerid);
        Learner learner = learnerMapper.selectOne(queryWrapperLearner);
        QueryWrapper<TeamDataAsMember> queryWrapperTeamDataAsMember = new QueryWrapper<>();
        queryWrapperTeamDataAsMember.eq("pid", learner.getPid());
        TeamDataAsMember teamDataAsMember = teamDataAsMemberMapper.selectOne(queryWrapperTeamDataAsMember);
        if (teamDataAsMember != null) {
            return 2;
        }//如果查询到这个人有小队了，就不能那个啥了
        Team team = teamMapper.selectById(teamid);
        if (team == null) {
            return 3;
        }//小队编号错误
        //改变team的属性之类的
        //更新个人属性
        learner.setTeamid(teamid);
        learnerMapper.updateById(learner);
        //更新team属性
        PersonalData leaderData = personalDataService.getPersonalData(learner.getPid());
        team.setNumofque(team.getNumofque() + leaderData.getCorrectNum());
        teamMapper.updateById(team);
        //创建teamDataAsMember
        teamDataAsMember = new TeamDataAsMember();
        teamDataAsMember.setTeamid(team.getTeamid());
        teamDataAsMember.setIfleader(false);
        teamDataAsMember.setPid(learnerid);
        teamDataAsMemberMapper.insert(teamDataAsMember);
        return 1;//成功
    }

    public Team getTeam(String teamid) {
        return teamMapper.selectById(teamid);
    }

    public int updateTeam(Team team) {
        if (this.getTeam(team.getTeamid()) == null) {
            return -2;
        }
        return teamMapper.updateById(team);
    }

    public TeamDataAsMember getTeamDataAsMember(String pid) {
        QueryWrapper<TeamDataAsMember> queryWrapperTeamDataAsMember = new QueryWrapper<>();
        queryWrapperTeamDataAsMember.eq("pid", pid);
        return teamDataAsMemberMapper.selectOne(queryWrapperTeamDataAsMember);
    }


    public void updateTeamAndTeamDataAsMember(String teamid) {
        QueryWrapper<TeamDataAsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teamid", teamid);
        List<TeamDataAsMember> teamDataAsMemberList = teamDataAsMemberMapper.selectList(queryWrapper);
        List<Pair<TeamDataAsMember, PersonalData>> pairList = new ArrayList<>();
        for (TeamDataAsMember teamDataAsMember : teamDataAsMemberList) {
            String pid = teamDataAsMember.getPid();
            PersonalData personalData = personalDataService.getPersonalData(pid);
            Pair<TeamDataAsMember, PersonalData> p = new Pair<>(teamDataAsMember, personalData);
            pairList.add(p);
        }
        Collections.sort(pairList, new Comparator<Pair<TeamDataAsMember, PersonalData>>() {
            @Override
            public int compare(Pair<TeamDataAsMember, PersonalData> p1, Pair<TeamDataAsMember, PersonalData> p2) {
                if (!p1.getValue().getCorrectrate().equals(p2.getValue().getCorrectrate())) {
                    return p1.getValue().getCorrectrate() > p2.getValue().getCorrectrate() ? 1 : -1;
                }
                if (p1.getValue().getCorrectNum() != p2.getValue().getCorrectNum()) {
                    return p1.getValue().getCorrectNum() > p2.getValue().getCorrectNum() ? 1 : -1;
                }
                if (!p1.getValue().getProgresspercentage().equals(p2.getValue().getProgresspercentage())) {
                    return p1.getValue().getProgresspercentage() > p2.getValue().getProgresspercentage() ? 1 : -1;
                }
                return p1.getValue().getPid().compareTo(p2.getValue().getPid());
            }
        });
        int listNum = pairList.size();
        int i = 1;
        for (Pair<TeamDataAsMember, PersonalData> p : pairList) {
            TeamDataAsMember t = p.getKey();
            t.setRankyesterday(t.getRanktoday());
            t.setRanktoday(i);
            t.setIfleader(i == 1);
            t.setMvptoday(i == 1);
            t.setUp_or_down(t.getRankyesterday() - t.getRanktoday());
            QueryWrapper<TeamDataAsMember> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("teamid", t.getTeamid());
            queryWrapper1.and(j -> j.eq("pid", t.getPid()));
            teamDataAsMemberMapper.update(t, queryWrapper1);
            if (i == 1) {
                Team teamTemp = teamMapper.selectById(teamid);
                teamTemp.setLid(t.getPid());
                teamMapper.updateById(teamTemp);
            }
            i++;
        }
    }

}

package njust.myoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import njust.myoj.entity.Learner;
import njust.myoj.entity.PersonalData;
import njust.myoj.entity.Team;
import njust.myoj.entity.TeamDataAsMember;
import njust.myoj.mapper.LearnerMapper;
import njust.myoj.mapper.TeamDataAsMemberMapper;
import njust.myoj.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        if (team== null) {
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
    public Team getTeam(String teamid){
        return teamMapper.selectById(teamid);
    }

    public int updateTeam(Team team) {
        if(this.getTeam(team.getTeamid())==null){
            return -2;
        }
        return teamMapper.updateById(team);
    }
    public TeamDataAsMember getTeamDataAsMember(String pid){
        QueryWrapper<TeamDataAsMember> queryWrapperTeamDataAsMember = new QueryWrapper<>();
        queryWrapperTeamDataAsMember.eq("pid", pid);
        return teamDataAsMemberMapper.selectOne(queryWrapperTeamDataAsMember);
    }
}

package njust.myoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import njust.myoj.entity.PersonalData;
import njust.myoj.entity.Team;
import njust.myoj.entity.TeamDataAsMember;
import njust.myoj.mapper.TeamDataAsMemberMapper;
import njust.myoj.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    TeamDataAsMemberMapper teamDataAsMemberMapper;
    @Autowired
    PersonalDataService personalDataService;

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
        teamDataAsMember = new TeamDataAsMember();
        teamDataAsMember.setTeamid(team.getTeamid());
        teamDataAsMember.setIfleader(true);
        teamDataAsMember.setPid(team.getLid());
        teamDataAsMemberMapper.insert(teamDataAsMember);
        return team;
    }

    public TeamDataAsMember inviteJoinTeam(TeamDataAsMember teamDataAsMember) {
        QueryWrapper<TeamDataAsMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", teamDataAsMember.getPid());
        TeamDataAsMember test = teamDataAsMemberMapper.selectOne(queryWrapper);
        if (test != null) {
            return null;
        }//如果查询到这个人有小队了，就不能那个啥了
        //改变team的属性之类的
        //回来再写
    }
}

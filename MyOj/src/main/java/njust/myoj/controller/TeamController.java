package njust.myoj.controller;

import njust.myoj.entity.Team;
import njust.myoj.entity.TeamDataAsMember;
import njust.myoj.service.TeamService;
import njust.myoj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "api/createTeam", method = RequestMethod.POST)
    public Object createTeam(@RequestBody Team team) {
        JsonResult jr = new JsonResult();
        Team createT = teamService.createTeam(team);
        if (createT != null) {
            jr.setCode(200);
            jr.setMsg("创建小队成功");
            jr.setObj(createT);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该账户已经有小队");
        jr.setObj(null);
        return jr;
    }

    @RequestMapping(value = "api/joinTeam", method = RequestMethod.POST)
    public Object joinTeam(@RequestBody Map<String, String> map) {
        JsonResult jr = new JsonResult();
        Integer joinT = teamService.joinTeam(map.get("teamid"), map.get("pid"));
        if (joinT == 1) {
            jr.setCode(200);
            jr.setMsg("加入成功");
            jr.setObj(null);
            return jr;
        } else if (joinT == 2) {
            jr.setCode(201);
            jr.setMsg("该账户已经有小队");
            jr.setObj(null);
            return jr;
        } else if (joinT == 3) {
            jr.setCode(202);
            jr.setMsg("该小队不存在");
            jr.setObj(null);
            return jr;
        }
        jr.setCode(203);
        jr.setMsg("未知错误");
        jr.setObj(null);
        return jr;
    }

    @RequestMapping(value = "api/getTeam", method = RequestMethod.POST)
    public Object getTeam(@RequestBody Map<String, String> map) {
        JsonResult jr = new JsonResult();
        Team team = teamService.getTeam(map.get("teamid"));
        if (team != null) {
            jr.setCode(200);
            jr.setMsg("获得团队成功");
            jr.setObj(team);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该团队不存在");
        return jr;
    }

    @RequestMapping(value = "api/updateTeam", method = RequestMethod.POST)
    public Object updateTeam(@RequestBody Team team) {
        JsonResult jr = new JsonResult();
        int rs = teamService.updateTeam(team);
        if (rs == -2) {
            jr.setCode(201);
            jr.setMsg("该团队不存在");
            return jr;
        }
        jr.setCode(200);
        jr.setMsg("更新团队成功");
        return jr;
    }


    @RequestMapping(value = "api/getTeamDataAsMember", method = RequestMethod.POST)
    public Object getTeamDataAsMember(@RequestBody Map<String, String> map) {
        JsonResult jr = new JsonResult();
        TeamDataAsMember teamDataAsMember = teamService.getTeamDataAsMember(map.get("pid"));
        if (teamDataAsMember != null) {
            jr.setCode(200);
            jr.setMsg("获得个人团队数据成功");
            jr.setObj(teamDataAsMember);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该成员未成团或不存在这个用户");
        return jr;
    }
}

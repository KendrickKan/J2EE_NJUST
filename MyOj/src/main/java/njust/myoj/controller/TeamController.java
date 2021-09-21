package njust.myoj.controller;

import njust.myoj.entity.Team;
import njust.myoj.service.TeamService;
import njust.myoj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "api/createTeam", method = RequestMethod.POST)
    public Object createTeam(@RequestBody Team team) {
        JsonResult jr = new JsonResult();
        if(teamService.createTeam(team)!=null){
            jr.setCode(200);
            jr.setMsg("创建小队成功");
            jr.setObj(team);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该账户已经有小队");
        jr.setObj(null);
        return jr;
    }
}

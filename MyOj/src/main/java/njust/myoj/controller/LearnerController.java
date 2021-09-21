package njust.myoj.controller;

import njust.myoj.entity.Learner;
import njust.myoj.service.LearnerService;
import njust.myoj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 21
 */
@RestController
public class LearnerController {

    @Autowired
    LearnerService learnerService;

    @RequestMapping("/api/getAllLearners")
    public Object list() {

        JsonResult jr=new JsonResult();
        jr.setCode(200);
        jr.setObj(learnerService.list());
        return jr;
        //return learnerService.list();
    }

    @RequestMapping(value = "api/registLearner", method = RequestMethod.POST)
    public Object insert(@RequestBody Learner learner) {
        JsonResult jr=new JsonResult();
        Integer rs=learnerService.insert(learner);
        if (rs==1) {
            jr.setObj(learner);
            jr.setCode(200);
            jr.setMsg("添加成功");
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("添加失败");
        return jr;
        //return 200 添加成功
        //return 201 添加失败
    }

    @RequestMapping(value = "api/loginLearner", method = RequestMethod.POST)
    public Object login(@RequestBody Learner learner) {
        JsonResult jr=new JsonResult();
        if(learnerService.pidIfExit(learner.getPid())==null) {
            jr.setCode(202);
            jr.setMsg("登录失败账户不存在");
            return jr;
        }
        if(learnerService.login(learner.getPid(),learner.getPassword())) {
            System.out.println("OK");
            jr.setCode(200);
            jr.setMsg("登录成功");
            return jr;
        }
        jr.setMsg("登录失败密码错误");
        jr.setCode(201);
        return jr;
        //return 200 登录成功
        //return 201 登录失败密码错误
        //return 202 登录失败账户不存在
    }

    @RequestMapping(value = "api/pidIfExit", method = RequestMethod.POST)
    public Object pidIfExit(@RequestBody Learner learner) {
        JsonResult jr=new JsonResult();
        Learner learner1=learnerService.pidIfExit(learner.getPid());
        if(learner1!=null) {
            System.out.println("OK");
            jr.setCode(200);
            jr.setMsg("该账户存在");
            jr.setObj(learner1);
            return jr;
        }
        jr.setMsg("账户不存在");
        jr.setCode(201);
        return jr;
        //return 201 注册失败，该账号已经被注册
        //return 200 注册成功
    }

    @RequestMapping(value = "api/updateLearner", method = RequestMethod.POST)
    public Object updateLearner(@RequestBody Learner learner) {
        JsonResult jr=new JsonResult();
        Integer rs=learnerService.update(learner);
        if(rs!=-1){
            System.out.println("OK");
            jr.setCode(200);
            jr.setMsg("更新成功");
            return jr;
        }
        jr.setMsg("更新失败");
        jr.setCode(201);
        return jr;
        //return 200 更新成功
        //return 201 更新失败
    }


}

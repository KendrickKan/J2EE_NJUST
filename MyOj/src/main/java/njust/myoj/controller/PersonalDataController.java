package njust.myoj.controller;

import njust.myoj.entity.Learner;
import njust.myoj.entity.PersonalData;
import njust.myoj.service.LearnerService;
import njust.myoj.service.PersonalDataService;
import njust.myoj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalDataController {
    @Autowired
    PersonalDataService personalDataService;
    @Autowired
    LearnerService learnerService;

    @RequestMapping("/api/getAllPersonalDatas")
    public Object list() {

        JsonResult jr = new JsonResult();
        jr.setCode(200);
        jr.setObj(personalDataService.list());
        return jr;
        //return learnerService.list();
    }

    @RequestMapping("/api/getPersonalData")
    public Object getPersonalData(@RequestBody Learner learner) {
        JsonResult jr = new JsonResult();
        if (learnerService.pidIfExit(learner.getPid()) != null) {
            jr.setCode(200);
            jr.setMsg("获取成功");
            jr.setObj(personalDataService.getPersonalData(learner.getPid()));
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该账户不存在");
        return jr;
        //200 获取个人信息成功
        //201 该账户不存在
    }

    @RequestMapping("/api/updatePersonalData")
    public Object updatePersonalData(@RequestBody PersonalData personalData) {
        JsonResult jr = new JsonResult();
        System.out.println(personalData.getPid());
        System.out.println(personalData.getMath_done());
        Learner learner1 = learnerService.pidIfExit(personalData.getPid());
        if(learner1!=null) {
            Integer rs = personalDataService.update(personalData);
            if (rs != -1) {
                System.out.println("OK");
                jr.setCode(200);
                jr.setMsg("更新成功");
                return jr;
            }
            jr.setMsg("更新失败");
            jr.setCode(201);
            return jr;
        }
        jr.setMsg("账户不存在");
        jr.setCode(202);
        return jr;
        //return 200 更新成功
        //return 201 更新失败
        //return 202 账户不存在
    }
}

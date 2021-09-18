package njust.myoj.controller;

import njust.myoj.entity.Learner;
import njust.myoj.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 21
 */
@RestController
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @RequestMapping("/api/getAllLearners")
    public List<Learner> list() {
        return learnerService.list();
    }

    @RequestMapping(value = "api/registLearner", method = RequestMethod.GET)
    public Object insert(@RequestBody Learner learner) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("errNo",learnerService.insert(learner));
        return map;
        //return 1 添加成功
        //return 500 已经存在
    }

    @RequestMapping(value = "api/loginLearner", method = RequestMethod.GET)
    public Object login(@RequestBody Learner learner) {
        Map<String, Object> map = new HashMap<>(1);
        if(learnerService.login(learner.getPid(),learner.getPassword())) {
            System.out.println("OK");
            map.put("errNo",200);
            return map;
        }
        map.put("errNo",201);
        return map;
        //return 200 登录成功
        //return 201 登录失败
    }

}

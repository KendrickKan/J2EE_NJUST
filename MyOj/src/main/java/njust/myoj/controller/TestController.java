package njust.myoj.controller;

import njust.myoj.entity.Paper;
import njust.myoj.service.TestService;
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
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "api/getPaper", method = RequestMethod.POST)
    public Object getPaper(@RequestBody Paper paper) {
        JsonResult jr = new JsonResult();
        jr.setCode(200);
        jr.setMsg("获取成功");
        paper = testService.getPaper(paper);
        jr.setObj(paper);
        return jr;
    }

    @RequestMapping(value = "api/submitPaper", method = RequestMethod.POST)
    public Object submitPaper(@RequestBody Paper paper) {
        JsonResult jr = new JsonResult();
        paper= testService.submitPaper(paper);
        if(paper!=null)
        {
            jr.setCode(200);
            jr.setMsg("提交成功");
            jr.setObj(paper);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("提交失败");
        return jr;
    }
}

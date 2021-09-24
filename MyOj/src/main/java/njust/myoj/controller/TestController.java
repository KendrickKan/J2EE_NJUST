package njust.myoj.controller;

import njust.myoj.entity.History;
import njust.myoj.entity.Paper;
import njust.myoj.entity.TestLibrary;
import njust.myoj.service.TestService;
import njust.myoj.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
        paper = testService.getPaper(paper);
        if(paper!=null) {
            jr.setCode(200);
            jr.setMsg("获取成功");
            jr.setObj(paper);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("获取失败");
        return jr;
    }

    @RequestMapping(value = "api/submitPaper", method = RequestMethod.POST)
    public Object submitPaper(@RequestBody Paper paper) {
        JsonResult jr = new JsonResult();
        paper = testService.submitPaper(paper);
        if (paper != null) {
            jr.setCode(200);
            jr.setMsg("提交成功");
            jr.setObj(paper);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("提交失败");
        return jr;
    }

    @RequestMapping(value = "api/getTestById", method = RequestMethod.POST)
    public Object getTestById(@RequestBody TestLibrary testLibrary) {
        JsonResult jr = new JsonResult();
        testLibrary = testService.getTestByID(testLibrary.getQid());
        if (testLibrary != null) {
            jr.setCode(200);
            jr.setMsg("查询成功");
            jr.setObj(testLibrary);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("查询失败，该题目不存在");
        return jr;
    }

    @RequestMapping(value = "api/getPaperReview", method = RequestMethod.POST)
    public Object getPaperReview(@RequestBody Paper paper) {
        JsonResult jr = new JsonResult();
        paper = testService.getPaperReview(paper);
        if (paper != null) {
            jr.setCode(200);
            jr.setMsg("获取成功");
            jr.setObj(paper);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该同学错误题目数量未达10题");
        return jr;
    }

    @RequestMapping(value = "api/getPaperAI", method = RequestMethod.POST)
    public Object getPaperAI(@RequestBody Paper paper) {
        JsonResult jr = new JsonResult();
        paper = testService.getPaperReview(paper);
        if (paper != null) {
            jr.setCode(200);
            jr.setMsg("获取成功");
            jr.setObj(paper);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该同学错误题目数量未达10题");
        return jr;
    }

    @RequestMapping(value = "api/getHistory", method = RequestMethod.POST)
    public Object getHistory(@RequestBody Map<String, String> map) {
        JsonResult jr = new JsonResult();
        List<History> historyList = testService.getHistory(map.get("pid"));
        if(historyList.size()>0){
            jr.setCode(200);
            jr.setMsg("查询成功");
            jr.setObj(historyList);
            return jr;
        }
        jr.setCode(201);
        jr.setMsg("该同学没有做题记录");
        return jr;
    }

}

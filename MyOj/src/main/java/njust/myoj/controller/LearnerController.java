package njust.myoj.controller;

import njust.myoj.entity.Learner;
import njust.myoj.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author 21
 */
@RestController
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @GetMapping("/api/Learners")
    public List<Learner> list() {
        return learnerService.list();
    }
}

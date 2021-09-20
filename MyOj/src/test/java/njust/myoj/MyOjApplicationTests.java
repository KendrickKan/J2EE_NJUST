package njust.myoj;

import njust.myoj.mapper.LearnerMapper;
import njust.myoj.service.LearnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyOjApplicationTests {

    @Autowired
    private LearnerMapper learnerMapper;
    @Autowired
    private LearnerService learnerService;

    @Test
    void contextLoads() {
        System.out.println("Hello");
        System.out.println(learnerService.pidIfExit("919106840423"));

    }

}

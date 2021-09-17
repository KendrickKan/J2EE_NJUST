package njust.myoj;

import njust.myoj.entity.Learner;
import njust.myoj.mapper.LearnerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyOjApplicationTests {

    @Autowired
    private LearnerMapper learnerMapper;

    @Test
    void contextLoads() {
        System.out.println("Hello");
        List<Learner> userList = learnerMapper.selectList(null);
        for(Learner user:userList) {
            System.out.println(user);
        }
    }

}

package njust.myoj;

import njust.myoj.service.PersonalDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyOjApplicationTests {


    @Autowired
    private PersonalDataService personalDataService;

    @Test
    void contextLoads() {
        System.out.println("Hello");
        System.out.println(personalDataService.list());

    }

}

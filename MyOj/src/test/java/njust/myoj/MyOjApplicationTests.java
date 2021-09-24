package njust.myoj;

import njust.myoj.entity.Paper;
import njust.myoj.entity.TestLibrary;
import njust.myoj.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyOjApplicationTests {


    @Autowired
    private TestService testService;

    @Test
    void contextLoads() {
        System.out.println("Hello");
        Paper paper = new Paper();
        paper.setPid("919106840421");
        paper.setDifficulty(1);
        paper.setSubject(1);
        paper.setType(1);
        paper = testService.getPaper(paper);
        if (paper != null)
            for (TestLibrary testLibrary : paper.getTest()) {
                System.out.println(testLibrary);
            }
    }

}

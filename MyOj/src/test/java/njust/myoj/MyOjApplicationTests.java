package njust.myoj;

import njust.myoj.service.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyOjApplicationTests {


    @Autowired
    private TeamService teamService;

    @Test
    void contextLoads() {
        System.out.println("Hello");
        teamService.updateTeamAndTeamDataAsMember("1632481231602");
    }

}

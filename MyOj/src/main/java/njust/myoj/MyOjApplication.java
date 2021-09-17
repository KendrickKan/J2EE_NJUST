package njust.myoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("njust.myoj.mapper")
public class MyOjApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyOjApplication.class, args);
    }

}

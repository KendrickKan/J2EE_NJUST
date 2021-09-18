package njust.myoj.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.sql.*;

@Data
public class Learner {
    @TableId("pid")
    private String pid;
    private String password;
    private String teamid;
    private Integer grade;
    private Integer level;
    private String name;
    private Date birthday;
    private Integer age;
    private String creed;
    private Integer picforhead;
}

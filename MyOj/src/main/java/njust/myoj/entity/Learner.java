package njust.myoj.entity;


import lombok.Data;

import java.sql.*;

@Data
public class Learner {
    private String pid;
    private String password;
    private String teamid;
    private int grade;
    private int level;
    private String name;
    private Date birthday;
    private int age;
    private String creed;
    private int picforhead;
}

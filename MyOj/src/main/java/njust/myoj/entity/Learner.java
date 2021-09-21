package njust.myoj.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Learner {
    @TableId("pid")
    private String pid;
    private String password;
    private String teamid;
    private Integer grade;
    private Integer level;
    private String name;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private Integer age;
    private String creed;
    private Integer picforhead;
}

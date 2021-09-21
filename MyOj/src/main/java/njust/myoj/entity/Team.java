package njust.myoj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Team {
    @TableId("tid")
    private String tid;
    private String lid;
    private Integer level;
    private Integer numofque;
    private String name;
    private Integer picforhead;
}

package njust.myoj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

@Data
@TableName("teamdataasmember")
public class TeamDataAsMember {
    @MppMultiId("teamid")
    private String teamid;
    @MppMultiId("pid")
    private String pid;
    private Integer rankyesterday;
    private Integer ranktoday;
    private Integer up_or_down;
    private boolean mvptoday;
    private boolean ifleader;
}

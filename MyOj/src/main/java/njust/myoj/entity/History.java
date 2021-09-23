package njust.myoj.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

import java.util.Date;

@Data
@TableName("history")
public class History {
    @MppMultiId("pid")
    private String pid;
    @MppMultiId("dotime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date dotime;
    @MppMultiId("qid")
    private String qid;
    private boolean correctness;
    private String answerbefore;

    public History() {

    }
    public History(History history){
        this.pid=history.pid;
        this.dotime=history.dotime;
        this.qid=history.qid;
        this.correctness=history.correctness;
        this.answerbefore=history.answerbefore;
    }
}

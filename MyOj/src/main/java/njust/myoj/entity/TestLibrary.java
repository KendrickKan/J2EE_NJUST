package njust.myoj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 21
 */
@Data
@TableName("testlibrary")
public class TestLibrary {
    @TableId("qid")
    private String qid;
    private Integer subject;
    private Integer grade;
    private String question;
    private String answercorrect;
    private Integer classification_forunit;
    private Integer classification_forans;
    private Integer difficulty;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
}

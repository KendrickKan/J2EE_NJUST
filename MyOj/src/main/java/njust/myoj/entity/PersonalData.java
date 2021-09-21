package njust.myoj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("personaldata")
public class PersonalData {
    @TableId("pid")
    private String pid;
    @TableField(value = "math_done")
    private Integer math_done;//数学做的题数
    @TableField(value = "chinese_done")
    private Integer chinese_done;
    @TableField(value = "english_done")
    private Integer english_done;
    @TableField(value = "math_correct")
    private Integer math_correct;//数学正确题数
    @TableField(value = "chinese_correct")
    private Integer chinese_correct;
    @TableField(value = "english_correct")
    private Integer english_correct;
    @TableField(value = "correctrate_ma")
    private Integer correctrate_ma;//数学正确率
    @TableField(value = "correctrate_ch")
    private Integer correctrate_ch;
    @TableField(value = "correctrate_en")
    private Integer correctrate_en;
    @TableField(value = "correctrate")
    private Integer correctrate;//总正确率
    @TableField(value = "progresspercentage_ma")
    private Integer progresspercentage_ma;//数学学习进度百分比
    @TableField(value = "progresspercentage_ch")
    private Integer progresspercentage_ch;
    @TableField(value = "progresspercentage_en")
    private Integer progresspercentage_en;
    @TableField(value = "progresspercentage")
    private Integer progresspercentage;//总学习进度百分比


    public PersonalData() {

    }

    public PersonalData(String pid) {

        this.setPid(pid);
        this.setMath_done(0);
        this.setChinese_done(0);
        this.setEnglish_done(0);
        this.setMath_correct(0);
        this.setChinese_correct(0);
        this.setEnglish_correct(0);
        this.setCorrectrate_ma(0);
        this.setCorrectrate_ch(0);
        this.setCorrectrate_en(0);
        this.setCorrectrate(0);
        this.setProgresspercentage_ma(0);
        this.setProgresspercentage_ch(0);
        this.setProgresspercentage_en(0);
        this.setProgresspercentage(0);

    }
}

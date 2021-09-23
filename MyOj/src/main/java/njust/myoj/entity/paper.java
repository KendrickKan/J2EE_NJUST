package njust.myoj.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 21
 */
@Data
public class Paper {
    private String pid;
    private Integer subject;
    private Integer type;
    private Integer difficulty;
    private List<TestLibrary> test;
    private List<History> histories;

    public Paper() {
        this.test = new ArrayList<>();
        this.histories = new ArrayList<>();
    }

    public void insertTest(TestLibrary testLibrary) {
        this.test.add(testLibrary);
    }
}

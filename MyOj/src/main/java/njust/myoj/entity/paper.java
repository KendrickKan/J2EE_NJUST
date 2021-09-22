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

    //    private TestLibrary test2;
//    private TestLibrary test3;
//    private TestLibrary test4;
//    private TestLibrary test5;
//    private TestLibrary test6;
//    private TestLibrary test7;
//    private TestLibrary test8;
//    private TestLibrary test9;
//    private TestLibrary test10;

    public Paper(){
        this.test= new ArrayList<>();
    }

    public void insertTest(TestLibrary testLibrary) {
        this.test.add(testLibrary);
    }
}

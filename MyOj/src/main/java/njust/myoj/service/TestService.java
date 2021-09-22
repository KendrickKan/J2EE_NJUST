package njust.myoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import njust.myoj.entity.Paper;
import njust.myoj.entity.TestLibrary;
import njust.myoj.mapper.TestLibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 21
 */
@Service
public class TestService {
    @Autowired
    TestLibraryMapper testLibraryMapper;

    public Paper getPaper(Paper paper) {
        QueryWrapper<TestLibrary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject", paper.getSubject());
        queryWrapper.and(i -> i.eq("difficulty", paper.getDifficulty()).and(j -> j.eq("classification_forans", paper.getType())));
        List<TestLibrary> testLibrarylist = testLibraryMapper.selectList(queryWrapper);
        int i = 0;
        for (TestLibrary testLibrary : testLibrarylist) {
            paper.insertTest(testLibrary);
            i++;
            if (i == 10) {
                break;
            }
        }
        return paper;
    }
}

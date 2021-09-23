package njust.myoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import njust.myoj.entity.History;
import njust.myoj.entity.Paper;
import njust.myoj.entity.PersonalData;
import njust.myoj.entity.TestLibrary;
import njust.myoj.mapper.HistoryMapper;
import njust.myoj.mapper.PersonalDataMapper;
import njust.myoj.mapper.TestLibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 21
 */
@Service
public class TestService {
    @Autowired
    TestLibraryMapper testLibraryMapper;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    PersonalDataMapper personalDataMapper;
    @Autowired
    TeamService teamService;

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

    public Paper submitPaper(Paper paper) {
        List<TestLibrary> testLibraries = new ArrayList<>();
        List<History> histories = paper.getHistories();
        if (histories.size() != 10) {
            return null;
        }
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr1= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Date dotime = null;
        try {
            dotime = dateformat.parse(timeStr1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (History history : histories) {
//            //查询某个题答案,如果返回的paper有，不过应该不行
//            TestLibrary testLibrary = testLibraries.stream()
//                    .filter(item -> history.getQid().equals(item.getQid()))
//                    .findAny()
//                    .orElse(null);
            int historisIndex = histories.indexOf(history);
            History history1 = new History(history);
            history1.setPid(paper.getPid());
            String qid = history.getQid();
            TestLibrary testLibrary = testLibraryMapper.selectById(qid);
            testLibraries.add(testLibrary);//向试卷加入习题
            if (!history.getAnswerbefore().equals(testLibrary.getAnswercorrect())) {
                //答错了
                history1.setCorrectness(false);
            } else {
                history1.setCorrectness(true);
            }
            history1.setQid(qid);
            history1.setDotime(dotime);
            histories.set(historisIndex, history1);//根据下标，修改list里面的元素
            historyMapper.insert(history1);
            //这里还要更改个人信息小队信息等
            //首先更改personnalData
            PersonalData personalData = personalDataMapper.selectById(paper.getPid());
            personalData.updatePersonalData(testLibrary, history1);
            personalDataMapper.updateById(personalData);
            //再更新team;
            if (teamService.getTeamDataAsMember(history.getPid()) != null) {

            }
            //写函数
        }
        return paper;
    }

}

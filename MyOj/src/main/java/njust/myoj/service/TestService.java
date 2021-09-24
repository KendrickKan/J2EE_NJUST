package njust.myoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import njust.myoj.entity.*;
import njust.myoj.mapper.*;
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
    LearnerMapper learnerMapper;
    @Autowired
    TestLibraryMapper testLibraryMapper;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    PersonalDataMapper personalDataMapper;
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    TeamService teamService;
    @Autowired
    LearnerService learnerService;

    public Paper getPaper(Paper paper) {
        if (learnerService.pidIfExit(paper.getPid()) == null) {
            return null;
        }
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
        String timeStr1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Date dotime = null;
        try {
            dotime = dateformat.parse(timeStr1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //提取个人数据
        PersonalData personalData = personalDataMapper.selectById(paper.getPid());
        //提取小队个人信息 检测有没有
        TeamDataAsMember teamDataAsMember = teamService.getTeamDataAsMember(paper.getPid());
        Team team = null;
        if (teamDataAsMember != null) {
            team = teamMapper.selectById(teamDataAsMember.getTeamid());
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
            //设置作答正误
            history1.setCorrectness(history.getAnswerbefore().equals(testLibrary.getAnswercorrect()));
            history1.setQid(qid);
            history1.setDotime(dotime);
            histories.set(historisIndex, history1);//根据下标，修改list里面的元素
            historyMapper.insert(history1);
            //这里还要更改个人信息小队信息等
            //更改personnalData
            personalData.updatePersonalData(testLibrary, history1);
            //再更新team;
            if (team != null) {
                team.updateTeamOneTest(history1);
            }
            //写函数
        }
        //插入personnalData
        personalDataMapper.updateById(personalData);
        //更新team 并插入team;
        if (team != null) {
            team.setLevel(team.getNumofque() / 30);
            teamMapper.updateById(team);
        }
        //再更新learner 也就是更新level
        Learner learner = learnerService.getLearnerByID(paper.getPid());
        learner.setLevel(personalData.getCorrectNum() / 15);//做对15题升一级
        learnerMapper.updateById(learner);
        paper.setTest(testLibraries);
        return paper;
    }

    public TestLibrary getTestByID(String qid) {
        return testLibraryMapper.selectById(qid);
    }

    public Paper getPaperReview(Paper paper) {
        QueryWrapper<History> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", paper.getPid());
        queryWrapper.and(i -> i.eq("correctness", false));
        List<History> historylist = historyMapper.selectList(queryWrapper);
        if (historylist.size() < 10) {
            return null;
        }
        int i = 0;
        for (History history : historylist) {
            paper.insertTest(testLibraryMapper.selectById(history.getQid()));
            i++;
            if (i == 10) {
                break;
            }
        }
        return paper;
    }

    public List<History> getHistory(String pid) {
        QueryWrapper<History> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", pid);
        return historyMapper.selectList(queryWrapper);

    }

}

package njust.myoj.service;

import njust.myoj.entity.Learner;
import njust.myoj.entity.PersonalData;
import njust.myoj.mapper.LearnerMapper;
import njust.myoj.mapper.PersonalDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 21
 */
@Service
public class LearnerService {
    @Autowired
    LearnerMapper learnerMapper;
    @Autowired
    PersonalDataMapper personalDataMapper;

    public List<Learner> list() {
        return learnerMapper.selectList(null);
    }

    public Learner pidIfExit(String pid) {
        //查询到已有，返回learner
        return learnerMapper.selectById(pid);

    }

    public int insert(Learner learner) {
        if (pidIfExit(learner.getPid()) == null) {
            PersonalData personalData = new PersonalData(learner.getPid());
            personalDataMapper.insert(personalData);
            return learnerMapper.insert(learner);
        }
        return 0;
    }

    public boolean login(String pid, String password) {
        return learnerMapper.selectById(pid).getPassword().equals(password);
    }

    public int update(Learner learner) {
        return learnerMapper.updateById(learner);
    }

    public Learner getLearnerByID(Learner learner) {
        return learnerMapper.selectById(learner.getPid());
    }
}

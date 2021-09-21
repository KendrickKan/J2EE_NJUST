package njust.myoj.service;

import njust.myoj.entity.Learner;
import njust.myoj.mapper.LearnerMapper;
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

    public List<Learner> list() {
        return learnerMapper.selectList(null);
    }
    public Learner pidIfExit(String pid)
    {
        //查询到已有，返回learner
        return learnerMapper.selectById(pid);

    }
    public int insert(Learner learner){
        if(pidIfExit(learner.getPid())==null) {
            return 0;
        }
        return learnerMapper.insert(learner);
    }
    public boolean login(String pid,String password){
        return learnerMapper.selectById(pid).getPassword().equals(password);
    }
    public int update(Learner learner) {
        return learnerMapper.updateById(learner);
    }
    public Learner getLearnerByID(Learner learner){
        return learnerMapper.selectById(learner.getPid());
    }
}

package njust.myoj.service;

import njust.myoj.entity.Learner;
import njust.myoj.mapper.LearnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LearnerService {
    @Autowired
    LearnerMapper learnerMapper;

    public List<Learner> list() {
        return learnerMapper.selectList(null);
    }
    public int insert(Learner learner){
        return learnerMapper.insert(learner);
    }
    public boolean login(String pid,String password){
        System.out.println(learnerMapper.selectById(pid).toString());
        return learnerMapper.selectById(pid).getPassword().equals(password);
    }
}

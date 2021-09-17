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
}

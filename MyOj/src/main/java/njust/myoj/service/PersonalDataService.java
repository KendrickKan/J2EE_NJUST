package njust.myoj.service;

import njust.myoj.entity.PersonalData;
import njust.myoj.mapper.PersonalDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDataService {
    @Autowired
    PersonalDataMapper personalDataMapper;

    public List<PersonalData> list() {
        return personalDataMapper.selectList(null);
    }

    public PersonalData getPersonalData(String pid) {
        return personalDataMapper.selectById(pid);
    }

    public int update(PersonalData personalData) {
        return personalDataMapper.updateById(personalData);
    }
}

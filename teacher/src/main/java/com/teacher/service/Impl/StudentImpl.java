package com.teacher.service.Impl;

import com.select.pojo.Achievement;
import com.select.pojo.Student;
import com.teacher.mapper.AchievementMapper;
import com.teacher.mapper.StudentMapper;
import com.teacher.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {
@Autowired
StudentMapper studentMapper;
@Autowired
AchievementMapper achievementMapper;
    @Override
    public List<Student> findstu(String couId) {
        return studentMapper.findstu(couId);
    }

    @Override
    public List<Achievement> findone(String couId) {
        return achievementMapper.findone(couId);
    }

    @Override
    public Integer add(String achId, double achNum, String teaAccount, String couId, String stuAccount, String semester, double achEnd, double achDay, double achEndProportion, double achDayProportion) {
        return achievementMapper.add(achId,achNum,
                teaAccount,couId,stuAccount,semester,
                achEnd,achDay,achEndProportion,achDayProportion);
    }

    @Override
    public Achievement findstuone(String stuAccount, String couId) {
        return achievementMapper.findstuone(stuAccount,couId);
    }
    @Override
    public Integer upda(String achEnd, String achDay, String achNum, String stuAccount){
        return achievementMapper.upda(achEnd,achDay,achNum,stuAccount);
    }

    @Override
    public Achievement findone1(String stuAccount) {
        return achievementMapper.findone1(stuAccount);
    }
}

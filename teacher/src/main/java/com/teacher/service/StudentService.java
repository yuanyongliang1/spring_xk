package com.teacher.service;

import com.select.pojo.Achievement;
import com.select.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 查看学生该课成绩
     * @param couId
     * @return
     */
    List<Student> findstu(String couId);

    /**
     * 查询该课的所有成绩
     * @param couId
     * @return
     */
    List<Achievement> findone(String couId);

    /**
     * 添加成绩
     * @param achId
     * @param achNum
     * @param teaAccount
     * @param couId
     * @param stuAccount
     * @param semester
     * @param achEnd
     * @param achDay
     * @param achEndProportion
     * @param achDayProportion
     * @return
     */
    Integer add(String achId, double achNum, String teaAccount, String couId, String stuAccount, String semester, double achEnd, double achDay, double achEndProportion, double achDayProportion);

    /**
     * 该学生该课的成绩
     * @param stuAccount
     * @param couId
     * @return
     */
    Achievement findstuone(String stuAccount, String couId);

    /**
     * 更新成绩
     * @param achEnd
     * @param achDay
     * @param achNum
     * @param stuAccount
     * @return
     */
    Integer upda(String achEnd, String achDay, String achNum, String stuAccount);

    /**
     * 查该学生所有成绩
     * @param stuAccount
     * @return
     */
    Achievement findone1(String stuAccount);
}

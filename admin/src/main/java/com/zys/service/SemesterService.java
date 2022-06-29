package com.zys.service;

import com.select.pojo.Semester;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/26 - 10:57
 */
@Repository
public interface SemesterService {
    //查询所有学期
    List<Semester> getSemAll();
    //获取最近一个学期的数据
    String getMaxSem();
    //添加学期规则
    int addSem(Semester semester);
    //修改学期规则
    int updateSem(Semester semester);
}

package com.zys.mapper;

import com.select.pojo.Semester;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/26 - 9:16
 */
@Repository
public interface SemesterMapper {
    /**
     * 查询所有学期
     */
    @Select("select * from semester")
    List<Semester> getSemAll();

    /**
     * 获取最近一个学期的数据
     */
    @Select("select * from (SELECT * FROM semester ORDER BY sem_over_time DESC) a limit 1")
    Semester getMaxTimeSem();

    /**
     * 添加学期规则
     * @param semester 对象参数
     */
    @Insert("insert into semester(semester,sel_start_time,sel_over_time,sem_over_time,sem_status)values" +
            "(#{semester},#{selStartTime},#{selOverTime},#{semOverTime},#{semStatus})")
    int addSem(Semester semester);

    /**
     * 修改学期规则
     * @param semester 对象参数
     * @return
     */
    @Update("update semester set sel_start_time=#{selStartTime},sel_over_time = #{selOverTime}," +
            "sem_over_time=#{semOverTime},sem_status=#{semStatus} where semester = #{semester}")
    int updateSem(Semester semester);

}

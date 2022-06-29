package com.teacher.mapper;

import com.select.pojo.Achievement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AchievementMapper {
    /**
     * 查询该课的所有成绩
     * @param couId
     * @return
     */
    @Select("select * from achievement where cou_id=#{couId}")
    List<Achievement> findone(String couId);

    /**
     * 该学生该课的成绩
     * @param stuAccount
     * @param couId
     * @return
     */
    @Select("select * from achievement where stu_account=#{stuAccount} and cou_id=#{couId}")
    Achievement findstuone(@Param("stuAccount") String stuAccount, @Param("couId") String couId);

    /**
     * 查该学生所有成绩
     * @param stuAccount
     * @return
     */
    @Select("select * from achievement where stu_account=#{stuAccount}")
    Achievement findone1(String stuAccount);

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
    @Insert("insert into achievement (ach_id,ach_num,tea_account,cou_id,stu_account,semester,ach_end,ach_day,ach_end_Proportion,ach_day_Proportion) values(#{achId},#{achNum},#{teaAccount},#{couId},#{stuAccount},#{semester},#{achEnd},#{achDay},#{achEndProportion},#{achDayProportion}) ")
    Integer add(@Param("achId") String achId,
                @Param("achNum") double achNum,
                @Param("teaAccount") String teaAccount,
                @Param("couId") String couId, @Param("stuAccount") String stuAccount,
                @Param("semester") String semester, @Param("achEnd") double achEnd,
                @Param("achDay") double achDay, @Param("achEndProportion") double achEndProportion,
                @Param("achDayProportion") double achDayProportion);

    /**
     * 更新成绩
     * @param achEnd
     * @param achDay
     * @param achNum
     * @param stuAccount
     * @return
     */
    @Update("update achievement set ach_end=#{achEnd},ach_day=#{achDay},ach_num=#{achNum} where stu_account=#{stuAccount}")
    Integer upda(@Param("achEnd") String achEnd, @Param("achDay") String achDay, @Param("achNum") String achNum, @Param("stuAccount") String stuAccount);
}
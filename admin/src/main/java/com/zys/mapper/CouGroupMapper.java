package com.zys.mapper;

import com.select.pojo.CouGroup;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/27 - 16:43
 */
@Repository
public interface CouGroupMapper {

    /**
     * （条件）查询课组信息
     * @param couGroup 课组名称参数
     * @return
     */
    @Select("<script> select * from cou_group"+
            "<where>"+
            "<if test='id != null'> and id=#{id}</if>"+
            "<if test='couGroup != null'> and cou_group like concat('%',#{couGroup},'%')</if>"+
            "</where>"+
            "</script>"
    )
    List<CouGroup> getCouGroup(CouGroup couGroup);

}

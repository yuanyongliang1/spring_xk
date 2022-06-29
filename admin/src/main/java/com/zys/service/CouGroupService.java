package com.zys.service;

import com.select.pojo.CouGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/27 - 17:35
 */
@Repository
public interface CouGroupService {
    //查询所有课组
    List<CouGroup> getCouGroup(CouGroup couGroup);
}

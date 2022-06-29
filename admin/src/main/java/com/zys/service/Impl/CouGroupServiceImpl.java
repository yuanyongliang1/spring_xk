package com.zys.service.Impl;

import com.select.pojo.CouGroup;
import com.zys.mapper.CouGroupMapper;
import com.zys.service.CouGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/27 - 17:38
 */
@Service
public class CouGroupServiceImpl implements CouGroupService {

    @Autowired
    private CouGroupMapper couGroupMapper;

    @Override
    public List<CouGroup> getCouGroup(CouGroup couGroup) {
        if(couGroup.getCouGroup() == ""){
            couGroup.setCouGroup(null);
        }
        return couGroupMapper.getCouGroup(couGroup);
    }
}

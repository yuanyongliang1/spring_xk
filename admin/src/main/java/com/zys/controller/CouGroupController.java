package com.zys.controller;

import com.select.pojo.CouGroup;
import com.select.utils.CommonResult;
import com.zys.service.CouGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/27 - 17:40
 */
@RestController
@RequestMapping("admin")
@CrossOrigin
public class CouGroupController {

    @Autowired
    private CouGroupService couGroupService;

    @GetMapping("getCouGroup")
    public CommonResult getCouGroup(CouGroup couGroup){
        List<CouGroup> couGroupList = couGroupService.getCouGroup(couGroup);
        return CommonResult.ok("查询成功",couGroupList);
    }

}

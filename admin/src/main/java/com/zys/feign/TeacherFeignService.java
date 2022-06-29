package com.zys.feign;

import com.select.pojo.Teacher;
import com.select.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @USER 张英帅
 * @date 2021/5/29 - 15:37
 */
@Component
@FeignClient(value = "nocos-teacher" ,fallback = TeacherFeignServiceFallback.class)
public interface TeacherFeignService {
    //查询所有教师
    @GetMapping("/getTeaAll")
    public Map<String, Object> getTeaAll(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                         @RequestParam(value = "limit",defaultValue = "10")Integer limit);
    //通过姓名或账号搜索教师
    @PostMapping("getTeaByAn")
    public List<Teacher> getTeaByAn(@RequestParam("an") String an);
    //通过账号查询教师
    @PostMapping("getTeaByAcc")
    public CommonResult getTeaByAcc(String account);
    @PostMapping("getTeaByAccList")
    public List<Teacher> getTeaByAccList(String account);
}

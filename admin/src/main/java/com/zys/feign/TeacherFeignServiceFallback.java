package com.zys.feign;

import com.select.pojo.Teacher;
import com.select.utils.CommonResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @USER 张英帅
 * @date 2021/5/29 - 17:16
 */
@Component
public class TeacherFeignServiceFallback implements TeacherFeignService {
    @Override
    public Map<String, Object> getTeaAll(Integer pn, Integer limit) {
        Map<String, Object> map = new HashMap();
        map.put("code","200");
        map.put("data","-----服务端宕机或关机时，80客户端PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o");
        return map;
    }

    @Override
    public List<Teacher> getTeaByAn(String an) {
        return null;
    }

    @Override
    public CommonResult getTeaByAcc(String account) {
        return CommonResult.common1(400);
    }

    @Override
    public List<Teacher> getTeaByAccList(String account) {
        return null;
    }
}

package com.teacher.service.Impl;

import com.select.pojo.Teacher;
import com.teacher.mapper.TeacherMapper;
import com.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @USER 张磊
 * @date 2021/5/29 - 15:28
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 查询所有教师
     * @return 查询到的教师集合
     */
    @Override
    public List<Teacher> getTea() {
        return teacherMapper.getTea(null,null);
    }

    /**
     * 搜索老师（通过账号精准查询或姓名模糊查询）
     * @return 教师集合
     */
    @Override
    public List<Teacher> getTeaByAn(String an) {
        //如果传入参数an为空，则直接查询所有
        if(an == "" || an == null ){
            return teacherMapper.getTea(null,null);
        }
        //通过账号精准查询教师
        List<Teacher> teaAll1 = teacherMapper.getTea(an, null);
        //通过姓名模糊查询教师
        List<Teacher> teaAll2 = teacherMapper.getTea(null, an);
        //合并查询结果
        if(!teaAll1.isEmpty() && teaAll2.isEmpty()){    //账号结果不为空，但姓名结果为空
            return teaAll1;
        }else if(teaAll1.isEmpty() && !teaAll2.isEmpty()){  //账号结果为空，但姓名结果不为空
            return teaAll2;
        }else if(!teaAll1.isEmpty() && !teaAll2.isEmpty()){ //账号结果不为空，姓名结果也不为空
            int i = 0;
            for (Teacher teacher : teaAll2) {
                //通过账号的唯一性，判断二者的查询结果是否有重复
                if(!teaAll1.get(i).getTeaAccount().equals(teacher.getTeaAccount())){
                    teaAll1.add(teacher);
                }
            }
            return teaAll1;
        }
        //以上二者的查询结果都为空时，直接返回null
        return null;
    }

    /**
     * 通过账号查询教师
     * @param account 账号
     * @return
     */
    @Override
    public List<Teacher> getTeaByAccount(String account) {
        return teacherMapper.getTea(account,null);
    }
}

package com.zys.service.Impl;

import com.select.pojo.Semester;
import com.zys.mapper.SemesterMapper;
import com.zys.service.SemesterService;
import com.zys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/26 - 10:58
 */
@Service
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private SemesterMapper semesterMapper;

    /**
     * 查询所有学期
     */
    @Override
    public List<Semester> getSemAll() {
        return semesterMapper.getSemAll();
    }

    /**
     * 获取最近一个学期的数据
     */
    @Override
    public String getMaxSem() {
        Semester maxTimeSem = semesterMapper.getMaxTimeSem();

        //获取 xx-xx第x学期
        String maxSem = maxTimeSem.getSemester();
        System.out.println(maxSem);
        //开始年
        int i1 = Integer.parseInt(maxSem.substring(0, 4));
        System.out.println(i1);
        //结束年
        int i2 = Integer.parseInt(maxSem.substring(5, 9));
        System.out.println(i2);
        //第X学期
        String semNum = maxSem.substring(10,11);
        System.out.println(semNum);
        String sem = "";    //定义 xx-xx第x学期
        Semester newSem = new Semester();
        if(semNum.equals("一")){
            sem = i1+"-"+i2+"第二学期";
        }else{
            i1++;
            i2++;
            sem = i1+"-"+i2+"第一学期";
        }
        System.out.println("sem= "+sem);
        return sem;
    }

    /**
     * 添加学期规则
     * @param semester 对象参数
     */
    @Override
    public int addSem(Semester semester) {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date selStartTime = null;
        Date selOverTime = null;

        boolean isAfter = false;
        //比较学期结束时间是否大于上学期
        Semester maxTimeSem = semesterMapper.getMaxTimeSem();
        boolean isAfter2 = false;
        Date semOverTime1 = null;
        Date semOverTime2 = null;

        try {
            selStartTime = format1.parse(semester.getSelStartTime());
            selOverTime = format1.parse(semester.getSelOverTime());
            //输入的要添加学期的结束时间
            semOverTime1 = format1.parse(semester.getSemOverTime());
            //上学期或当前学期结束时间
            semOverTime2 = format1.parse(maxTimeSem.getSemOverTime());
            isAfter = selOverTime.after(selStartTime);
            isAfter2 = semOverTime1.after(semOverTime2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(isAfter && isAfter2 ){
            return semesterMapper.addSem(semester);
        }else{
            return 0;
        }
    }

    /**
     * 修改学期规则
     * @param semester 对象参数
     * @return
     */
    @Override
    public int updateSem(Semester semester) {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date selStartTime = null;
        Date selOverTime = null;

        boolean isAfter = false;
        try {
            selStartTime = format1.parse(semester.getSelStartTime());
            selOverTime = format1.parse(semester.getSelOverTime());
            isAfter = selOverTime.after(selStartTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(isAfter ){
            return semesterMapper.updateSem(semester);
        }else{
            return 0;
        }
    }

}

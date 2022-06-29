package com.teacher.util;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ChengjiData {
    @ExcelProperty("成绩id")
    public String achId;

    @ExcelProperty("教师账号")
    public String teaAccount;
    @ExcelProperty("课程编号")
    public String couId;
    @ExcelProperty("学生账号")
    public String stuAccount;
    @ExcelProperty("学期")
    public String semester;
    @ExcelProperty("期末成绩")
    public Double achEnd;
    @ExcelProperty("平时成绩")
    public Double achDay;
    @ExcelProperty("期末成绩比例")
    public double achEndProportion;
    @ExcelProperty("平时成绩比例")
    public double achDayProportion;
    @ExcelProperty("最后总成绩")
    public Integer achNum;



}

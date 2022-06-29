package com.teacher.util;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EmpSalaryData {


    @ExcelProperty("学生姓名")
    private  String stuName;
    @ExcelProperty("班级")
    private  String stuClass;
    @ExcelProperty("学生账号")
    private  String stuAccount;
    @ExcelProperty("学院")
    private  String stuDepartment;
    @ExcelProperty("年级")
    private  String stuGrade;






}

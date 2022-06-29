package com.teacher.excleContrloller;

import com.alibaba.excel.EasyExcel;
import com.select.pojo.Student;
import com.teacher.service.StudentService;
import com.teacher.util.EmpSalaryData;
import com.teacher.util.ExlFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
public class EmpExlWrite {
    @Autowired

    StudentService studentService;
    private List<EmpSalaryData> data(String couId) {
        List<EmpSalaryData> list = new ArrayList<EmpSalaryData>();
        List<Student> list1 = studentService.findstu(couId);
        EmpSalaryData empData = null;

        for (int i = 0; i < list1.size(); i++) {
            empData=new EmpSalaryData();
            empData.setStuName(list1.get(i).getStuName());
            empData.setStuClass(list1.get(i).getStuClass());
            empData.setStuAccount(list1.get(i).getStuAccount());
            empData.setStuDepartment(list1.get(i).getStuDepartment());
            empData.setStuGrade(list1.get(i).getStuGrade());


            list.add(empData);
        }
        return list;
    }
    @GetMapping("/empSalaryExlWrite/{couId}")
    public void simpleWrite(@PathVariable String couId) {
        System.out.println(couId);
        // 写法1
        String fileName = ExlFileUtil.getPath() + "学生详情表" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, EmpSalaryData.class).sheet("学生详情表").doWrite(data(couId));
/*
        // 写法2
        fileName = ExlFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, EmpSalaryData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
 */
    }
}

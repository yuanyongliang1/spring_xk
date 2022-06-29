package com.teacher.excleContrloller;

import com.alibaba.excel.EasyExcel;
import com.select.pojo.Achievement;
import com.teacher.service.StudentService;
import com.teacher.util.ChengjiData;
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
public class ChengjiExlWrite {
    @Autowired

    StudentService studentService;
    private List<ChengjiData> data(String couId) {
        System.out.println(couId);
        System.out.println("ddddddddddddd");
        List<ChengjiData> list = new ArrayList<ChengjiData>();
        List<Achievement> list1 = studentService.findone(couId);
        ChengjiData cjData= null;

        for (int i = 0; i < list1.size(); i++) {
            cjData=new ChengjiData();
            cjData.setAchId(list1.get(i).getAchId());
            cjData.setTeaAccount(list1.get(i).getTeaAccount());
            cjData.setCouId(list1.get(i).getCouId());
            cjData.setStuAccount(list1.get(i).getStuAccount());
            cjData.setSemester(list1.get(i).getSemester());
            cjData.setAchEnd(list1.get(i).getAchEnd());
            cjData.setAchDay(list1.get(i).getAchDay());
            cjData.setAchEndProportion(list1.get(i).getAchEndProportion());
            cjData.setAchDayProportion(list1.get(i).getAchDayProportion());


            list.add(cjData);
        }
        return list;
    }

    @GetMapping("/empSalaryExlWrite1/{couId}")
    public void simpleWrite(@PathVariable String couId) {

        // 写法1
        String fileName = ExlFileUtil.getPath() + "成績详情表" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ChengjiData.class).sheet("成績详情表").doWrite(data(couId));
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

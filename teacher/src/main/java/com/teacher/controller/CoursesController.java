package com.teacher.controller;

import com.select.pojo.Achievement;
import com.select.pojo.Courses;
import com.select.pojo.Teacher;
import com.select.pojo.vo.StudentVo;
import com.select.utils.CommonResult;
import com.teacher.service.Impl.CoursesServiceImpl;
import com.teacher.service.LoginService;
import com.teacher.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@CrossOrigin
@Controller
public class CoursesController {
    @Autowired
    CoursesServiceImpl coursesService;
    Courses courses = new Courses();

    /**
     * 根据工号  查看该老师所有课程
     *
     * @param teaAccount
     * @return
     */
    @GetMapping("/findAll")
    @ResponseBody
    public List<Courses> findOne(@RequestParam String teaAccount) {

        List<Courses> list = coursesService.findAll(teaAccount);
        return list;
    }

    /**
     * 查看该课程所有信息
     *
     * @param couId
     * @return
     */
    @GetMapping("/findone")
    @ResponseBody
    public Courses findOne1(@RequestParam String couId) {

        courses = coursesService.findone(couId);
        return courses;
    }

    /**
     * 更新课程信息
     *
     * @param couTime
     * @param couWeek
     * @param crPlace
     * @param couIntroduce
     * @param couId
     * @return
     */
    @GetMapping("/edit")
    @ResponseBody
    public Integer findOne2(@RequestParam("couTime") String couTime,
                            @RequestParam("couWeek") String couWeek,
                            @RequestParam("crPlace") String crPlace,
                            @RequestParam("couIntroduce") String couIntroduce,
                            @RequestParam("couId") String couId) {

        Integer i = coursesService.edit(couTime, couWeek, crPlace, couIntroduce, couId);
        return i;

    }

    @Autowired
    StudentService studentService;

    /**
     * 添加成绩
     *
     * @param achId
     * @param achNum
     * @param teaAccount
     * @param couId
     * @param stuAccount
     * @param semester
     * @param achEnd
     * @param achDay
     * @param achEndProportion
     * @param achDayProportion
     * @return
     */
    @GetMapping("/add")
    @ResponseBody
    public Integer add(@RequestParam String achId, @RequestParam double achNum,
                       @RequestParam String teaAccount, @RequestParam String couId,
                       @RequestParam String stuAccount,
                       @RequestParam String semester, @RequestParam double achEnd,
                       @RequestParam double achDay, @RequestParam double achEndProportion,
                       @RequestParam double achDayProportion) {
        Integer i = studentService.add(achId, achNum,
                teaAccount, couId, stuAccount, semester,
                achEnd, achDay, achEndProportion, achDayProportion);
        return i;
    }

    /**
     * 该学生该课的成绩
     *
     * @param stuAccount
     * @param couId
     * @return
     */
    @GetMapping("/sel")
    @ResponseBody
    public Achievement findStu(@RequestParam String stuAccount,
                               @RequestParam String couId) {
        return studentService.findstuone(stuAccount, couId);
    }

    /**
     * 查该学生所有成绩
     *
     * @param stuAccount
     * @return
     */
    @GetMapping("/sel1")
    @ResponseBody
    public Achievement findStu1(@RequestParam String stuAccount) {
        return studentService.findone1(stuAccount);
    }

    @Autowired
    LoginService loginService;

    /**
     * 查看老师信息
     *
     * @param teaAccount
     * @return
     */
    @GetMapping("/selTea")
    @ResponseBody
    public Teacher findTea(@RequestParam String teaAccount) {
        return loginService.findOneTea(teaAccount);
    }

    /**
     * 修改老师等级
     *
     * @param teaLev
     * @param teaAccount
     * @return
     */
    @GetMapping("/up")
    @ResponseBody
    public Integer up(@RequestParam String teaLev, @RequestParam String teaAccount) {
        Integer i = loginService.up(teaLev, teaAccount);
        return i;
    }

    /**
     * 更新成绩
     *
     * @param achEnd
     * @param achDay
     * @param achNum
     * @param stuAccount
     * @return
     */
    @GetMapping("/upda")
    @ResponseBody
    public Integer upda(@RequestParam String achEnd,
                        @RequestParam String achDay,
                        @RequestParam String achNum,
                        @RequestParam String stuAccount) {
        Integer i = studentService.upda(achEnd, achDay, achNum, stuAccount);
        return i;
    }


    @PostMapping("/enterscore")
    public CommonResult enterScore(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        System.out.println(file == null);
        if (file.isEmpty()) {
            return CommonResult.ok(666, null, "空文件");
        } else {
            Enumeration<String> headerNames = request.getHeaderNames();
            System.out.println(headerNames);
            while (headerNames.hasMoreElements()) {
                String headName = headerNames.nextElement();
                System.out.println("---------" + headName);
                System.out.println("headName---------" + request.getHeader(headName));
//                if (headName.equals("likuntoken") && request.getHeader(headName).equals("wojiaolikun")) {
                try {
                    String fileName = file.getOriginalFilename();
//                        log.info("读取的文件名为：" + fileName);//写日志
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
//                        log.info("文件的后缀名为：" + suffixName);//写日志
//                        List<TbStudentEntity> list1 = new ArrayList<TbStudentEntity>();
                    List<StudentVo> list = new ArrayList();
                    XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    int lastRowNum = sheet.getLastRowNum();
                    for (int i = 2; i <= lastRowNum; i++) {
                        System.out.println("最大行数" + lastRowNum);
                        StudentVo student = new StudentVo();

                        XSSFRow row = sheet.getRow(i);
                        if (row != null) {
                            System.out.println(row.getLastCellNum());
                            //获取成绩
                            student.setAchEnd(row.getCell(5).getNumericCellValue());
                            //获取学号
                            student.setStuAccount(row.getCell(0).getStringCellValue());
                            list.add(student);
                        }
                    }
                    coursesService.enterScore(list);
                    return CommonResult.common1(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                }
            }
            return CommonResult.common1(200);
        }
    }
}

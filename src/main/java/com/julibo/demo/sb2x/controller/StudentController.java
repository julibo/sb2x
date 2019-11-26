package com.julibo.demo.sb2x.controller;

import com.github.pagehelper.PageInfo;
import com.julibo.demo.sb2x.exception.CustomException;
import com.julibo.demo.sb2x.model.StudentModel;
import com.julibo.demo.sb2x.service.StudentService;
import com.julibo.demo.sb2x.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author carson
 * @date 2019-11-25
 */
@RestController
@RequestMapping("/student")
@Api(tags = "0.0.1", value = "用户管理")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentService studentService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = ApiDataType.INT, paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "pageSize", value = "条数", dataType = ApiDataType.INT, paramType = ApiParamType.QUERY),
    })
    public PageInfo<StudentVo> getStudentPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return studentService.selectPage(pageNum, pageSize);
    }

    @GetMapping("")
    public ResponseEntity getStudents() {
        return ResponseEntity.ok(studentService.selectAll());
    }

    @PostMapping("")
    public ResponseEntity addUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "code") String code,
            @RequestParam(value = "sex") Integer sex,
            @RequestParam(value = "birthday") Date birthday,
            @RequestParam(value = "village") String village,
            @RequestParam(value = "remark", required = false) String remark
            )
    {
        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setCode(code);
        studentModel.setSex(sex);
        studentModel.setBirthday(birthday);
        studentModel.setVillage(village);
        studentModel.setRemark(remark);
        studentService.insert(studentModel);
        return ResponseEntity.ok("添加成功");
    }

    @GetMapping("/log")
    public ResponseEntity logging() {
        // 级别由低到高 trace<debug<info<warn<error
        logger.trace("这是一个trace日志...");
        logger.debug("这是一个debug日志...");
        // SpringBoot默认是info级别，只会输出info及以上级别的日志
        logger.info("这是一个info日志...");
        logger.warn("这是一个warn日志...");
        logger.error("这是一个error日志...");

        return ResponseEntity.ok("日志配置");
    }

    @GetMapping("/test1")
    public String test1() {
        // TODO 这里只是模拟异常，假设业务处理的时候出现错误了，或者空指针了等等...
        int i = 10 / 0;


        return "test1";
    }

    @GetMapping("/test2")
    public Map<String, String> test2() {
        Map<String, String> result = new HashMap<>(16);
        // TODO 直接捕获所有代码块，然后在 cache
        try {
            int i = 10 / 0;
            result.put("code", "200");
            result.put("data", "具体返回的结果集");
        } catch (Exception e) {
            throw new CustomException(500, "请求错误");
        }
        return result;
    }

}

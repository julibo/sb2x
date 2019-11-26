package com.julibo.demo.sb2x.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.julibo.demo.sb2x.dao.StudentDao;
import com.julibo.demo.sb2x.domain.SexEnum;
import com.julibo.demo.sb2x.model.StudentModel;
import com.julibo.demo.sb2x.service.StudentService;
import com.julibo.demo.sb2x.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author carson
 * @date 2019-11-25
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<StudentVo> selectAll() {
        List<StudentModel> list = studentDao.selectAll();
        return list.stream().map(student -> packageStudent(student)).collect(Collectors.toList());
    }

    private StudentVo packageStudent(StudentModel student) {
        LocalDateTime createTime = student.getCreatedAt().toLocalDateTime();
        LocalDateTime updatetime = student.getUpdatedAt().toLocalDateTime();
        return StudentVo.builder()
                .id(student.getId())
                .name(student.getName())
                .code(student.getCode())
                .sex(SexEnum.getSexByKey(student.getSex()))
                .birthday(student.getBirthday())
                .domain(student.getVillage())
                .remarks(student.getRemark())
                .createTime(createTime)
                .updateTime(updatetime)
                .build();
    }

    @Override
    public PageInfo<StudentVo> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentModel> students = studentDao.selectAll();
        List<StudentVo> list = students.stream().map(student -> packageStudent(student)).collect(Collectors.toList());
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public int insert(StudentModel record) {
        return studentDao.insert(record);
    }

}

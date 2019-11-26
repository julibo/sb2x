package com.julibo.demo.sb2x.service;

import com.github.pagehelper.PageInfo;
import com.julibo.demo.sb2x.model.StudentModel;
import com.julibo.demo.sb2x.vo.StudentVo;

import java.util.List;

/**
 * @author carson
 * @date 2019-11-25
 */
public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<StudentVo> selectAll();

    /**
     * 分页查询学生
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<StudentVo> selectPage(int pageNum, int pageSize);

    /**
     * 新增学生
     * @param record
     * @return
     */
    int insert(StudentModel record);
}

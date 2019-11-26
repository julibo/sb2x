package com.julibo.demo.sb2x.dao;

import com.julibo.demo.sb2x.model.StudentModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author carson
 * @date 2019-11-25
 */
@Mapper
public interface StudentDao {

    /**
     * 查询所有学生
     * @return
     */
    List<StudentModel> selectAll();

    /**
     * 新增学生
     * @param record
     * @return
     */
    int insert(StudentModel record);

}

package com.julibo.demo.sb2x.model;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author carson
 * @date 2019-11-25
 */
@Data
public class StudentModel {

    private Integer id;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Timestamp deletedAt;

    private String code;

    private String name;

    private Integer sex;

    private Date birthday;

    private String village;

    private String remark;

}

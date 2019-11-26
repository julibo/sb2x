package com.julibo.demo.sb2x.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author carson
 * @date 2019-11-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

    private Integer id;

    private String name;

    private String code;

    private String sex;

    private Date birthday;

    private String domain;

    private String remarks;

    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updateTime;

}

package com.codeify.springboot01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.ClobTypeHandler;
import org.apache.ibatis.type.LocalDateTypeHandler;

import java.time.LocalDateTime;

/**
 * @author codeify
 * @since 2022/04/28 23:51
 */
@TableName("t_user")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    private Integer age;

    private Integer score;

    @TableField(value = "create_time", typeHandler = LocalDateTypeHandler.class)
    private LocalDateTime createTime;

    @TableField(value = "update_time", typeHandler = LocalDateTypeHandler.class)
    private LocalDateTime updateTime;

    @TableField(value = "c_json", typeHandler = ClobTypeHandler.class)
    private String json;
}

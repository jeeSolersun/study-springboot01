package com.codeify.springboot01.mapper;

import com.codeify.springboot01.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author codeify
 * @since 2022/04/28 23:33
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    // 根据id查询用户信息
    User findById(@Param("id") Integer id);
}

package com.codeify.springboot01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeify.springboot01.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author codeify
 * @since 2022/04/28 23:33
 */
//@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    // 根据id查询用户信息
    User findById(@Param("id") Integer id);
}

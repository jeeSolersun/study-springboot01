package com.codeify.springboot01.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.codeify.springboot01.entity.User;
import com.codeify.springboot01.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {
    public void test01() {

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAge, 22);
        // SimpleQuery.list
        /*List<String> list = SimpleQuery.list(lambdaQueryWrapper, User::getName, System.out::println, val -> System.out.println(val));
        System.out.println("list = " + list);*/
        // SimpleQuery.keyMap
        /*Map<String, User> stringUserMap = SimpleQuery.keyMap(lambdaQueryWrapper, val -> val.getName(), val -> System.out.println(val));
        System.out.println("stringUserMap = " + stringUserMap);*/
        // SimpleQuery.map
        /*Map<String, Integer> map = SimpleQuery.map(lambdaQueryWrapper, val -> val.getName(), val -> val.getAge(), val -> System.out.println(val));
        System.out.println("map = " + map);*/

       // Map<String, List<User>> group = SimpleQuery.group(lambdaQueryWrapper, val -> val.getName(), val -> System.out.println(val));
       // Map<String, List<User>> group = SimpleQuery.group(lambdaQueryWrapper, User::getName, true, val -> System.out.println(val));
       // Map<String, List<String>> group = SimpleQuery.group(lambdaQueryWrapper, User::getName,
       //         Collectors.mapping(User::getId, Collectors.toList()), System.out::println);
        Map<String, List<String>> group = SimpleQuery.group(lambdaQueryWrapper, User::getName,
                Collectors.mapping(User::getId, Collectors.toList()),true,  System.out::println);
         System.out.println("group = " + group);

    }

    private static void test02() {
        User byId = Db.getById(1782413088146923521L, User.class);
        System.out.println("byId = " + byId);
    }

    public User findById(Integer id) {
        return baseMapper.findById(id);
    }

}

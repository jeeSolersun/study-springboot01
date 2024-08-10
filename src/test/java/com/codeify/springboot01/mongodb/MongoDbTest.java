package com.codeify.springboot01.mongodb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author: codeify
 * @date: 2024/7/25 00:14
 */
@SpringBootTest
public class MongoDbTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void test() {

    }
}

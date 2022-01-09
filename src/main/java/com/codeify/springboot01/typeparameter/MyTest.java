package com.codeify.springboot01.typeparameter;

import com.codeify.springboot01.SpringSpringboot01Application;
import com.codeify.springboot01.typeparameter.user.UserAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author codeify
 * @since 2021/08/26 00:13
 */
public class MyTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringSpringboot01Application.class);
        UserAction userAction = ac.getBean(UserAction.class);
        userAction.printBaseService();
        System.out.println(ac.getBean(BaseAction.class));
        ac.close();

    }
}

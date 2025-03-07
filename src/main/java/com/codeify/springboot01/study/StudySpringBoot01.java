// package com.codeify.springboot01.study;
//
// import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
// import org.springframework.beans.factory.support.DefaultListableBeanFactory;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.context.ApplicationContextInitializer;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.context.annotation.*;
// import org.springframework.context.support.GenericApplicationContext;
// import org.springframework.core.io.support.SpringFactoriesLoader;
// import org.springframework.core.type.AnnotationMetadata;
//
// import java.util.List;
//
// /**
//  * @author: codeify
//  * @date: 2024/12/1 13:48
//  */
// public class StudySpringBoot01 {
//     public static void main(String[] args) {
//         GenericApplicationContext ac = new GenericApplicationContext();
//         DefaultListableBeanFactory defaultListableBeanFactory = ac.getDefaultListableBeanFactory();
//         // 设置setAllowBeanDefinitionOverriding为false
//         defaultListableBeanFactory.setAllowBeanDefinitionOverriding(false);
//         // 注入解析@Import的postProcessor
//         ac.registerBean(ConfigurationClassPostProcessor.class);
//         System.out.println(">>>>>>>>>>>>>>>>>>");
//         for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
//             System.out.println("beanDefinitionName = " + beanDefinitionName);
//         }
//         System.out.println(">>>>>>>>>>>>>>>>>>");
//         ac.registerBean(MyAutoConfiguration1.class);
//         ac.refresh();
//         System.out.println(">>>>>>>>>>>>>>>>>>");
//         for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
//             System.out.println("beanDefinitionName = " + beanDefinitionName);
//         }
//         System.out.println(">>>>>>>>>>>>>>>>>>");
//         ac.close();
//     }
//     @Configuration
//     @Import({MyImportSelector.class})
//     static class MyAutoConfiguration1 {
//         @Bean
//         public Bean1 bean1() {
//             return new Bean1();
//         }
//     }
//     static class Bean1 {
//     }
//
//     // 外部的配置
//     @Configuration
//     static class MyAutoConfiguration2 {
//         @Bean
//         @ConditionalOnMissingBean
//         public Bean1 bean1() {
//             return new Bean1();
//         }
//     }
//     // static class MyImportSelector implements ImportSelector {
//     static class MyImportSelector implements DeferredImportSelector {
//         @Override
//         public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//             // List<MyAutoConfiguration2> list = SpringFactoriesLoader.loadFactories(MyAutoConfiguration2.class, null);
//             // System.out.println("list = " + list);
//             List<String> names = SpringFactoriesLoader.loadFactoryNames(MyImportSelector.class, null);
//             System.out.println("names = " + names);
//             return names.toArray(new String[0]);
//         }
//     }
//
//     private static void test01(String[] args) {
//         SpringApplication springApplication = new SpringApplication(StudySpringBoot01.class);
//         springApplication.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
//             @Override
//             public void initialize(ConfigurableApplicationContext applicationContext) {
//                 if (applicationContext instanceof GenericApplicationContext) {
//                     GenericApplicationContext gac = (GenericApplicationContext) applicationContext;
//                     gac.registerBean("bean3", Bean3.class);
//                 }
//             }
//         });
//         ConfigurableApplicationContext context = springApplication.run(args);
//         ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//         for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//             String resourceDescription = beanFactory.getBeanDefinition(beanDefinitionName).getResourceDescription();
//             System.out.printf("name = %s, 来源 = %s\n", beanDefinitionName, resourceDescription);
//         }
//         context.close();
//         // new AnnotatedBeanDefinitionReader((GenericApplicationContext) context)
//     }
//
//     static class Bean3 {}
//
//     @Bean
//     public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
//         return new TomcatServletWebServerFactory();
//     }
// }

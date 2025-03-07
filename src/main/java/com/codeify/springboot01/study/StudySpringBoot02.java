// package com.codeify.springboot01.study;
//
// import org.springframework.context.annotation.*;
// import org.springframework.context.support.GenericApplicationContext;
// import org.springframework.core.io.support.SpringFactoriesLoader;
// import org.springframework.core.type.AnnotatedTypeMetadata;
// import org.springframework.core.type.AnnotationMetadata;
// import org.springframework.util.ClassUtils;
//
// import java.lang.annotation.ElementType;
// import java.lang.annotation.Retention;
// import java.lang.annotation.RetentionPolicy;
// import java.lang.annotation.Target;
// import java.util.List;
// import java.util.Map;
//
// /**
//  * @author: codeify
//  * @date: 2024/12/22 13:54
//  */
// public class StudySpringBoot02 {
//     public static void main(String[] args) {
//         GenericApplicationContext context = new GenericApplicationContext();
//         context.setAllowBeanDefinitionOverriding(true);
//         AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
//         context.registerBean(MyConfiguration.class);
//         context.refresh();
//         for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//             String resourceDescription = context.getBeanDefinition(beanDefinitionName).getResourceDescription();
//             System.out.println(beanDefinitionName + " 来源：" + resourceDescription);
//         }
//         context.close();
//     }
//
//
//     static class MyCondition implements Condition {
//         @Override
//         public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//             Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
//             String className = annotationAttributes.get("className").toString();
//             Boolean exist = (Boolean) annotationAttributes.get("exist");
//             boolean present = ClassUtils.isPresent(className, null);
//             return exist ? present : !present;
//         }
//     }
//
//     @Target({ElementType.FIELD, ElementType.TYPE})
//     @Retention(value = RetentionPolicy.RUNTIME)
//     @Conditional(MyCondition.class) // 组合org.springframework.context.annotation.Conditional的功能
//     @interface ConditionalOnClass {
//         String className();
//         boolean exist();
//     }
//
//     @Configuration
//     @ConditionalOnClass(className = "dm.jdbc.driver.DmDriver", exist = false)
//     static class AutoConfiguration1 {
//         @Bean
//         public Bean1 bean1()
//         {
//             return new Bean1();
//         }
//     }
//
//     @Configuration
//     @ConditionalOnClass(className = "dm.jdbc.driver.DmDriver", exist = true)
//     static class AutoConfiguration2  {
//         @Bean
//         public Bean2 bean2()
//         {
//             return new Bean2();
//         }
//     }
//
//     static class Bean1 {}
//     static class Bean2  {}
//
//     @Configuration
//     @Import(MyImportSelector.class)
//     static class MyConfiguration {
//         // @Bean
//         // public Bean1 bean1()
//         // {
//         //     return new Bean1();
//         // }
//     }
//
//     static class MyImportSelector implements DeferredImportSelector {
//         @Override
//         public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//             List<String> names = SpringFactoriesLoader.loadFactoryNames(MyImportSelector.class, null);
//             return names.toArray(new String[0]);
//         }
//     }
// }

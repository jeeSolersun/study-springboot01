//package com.codeify.springboot01.juc.threadAndExecutor.chapter6;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * 反射获取Unsafe实例对象
// *
// * @author codeify
// * @since 2022/03/12 21:19
// */
//public class UnsafeAccessor {
//    private static Unsafe unsafe;
//
//    static {
//        Field theUnsafe = null;
//        try {
//            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            unsafe = (Unsafe) theUnsafe.get(null);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Unsafe getUnsafe() {
//        return unsafe;
//    }
//}

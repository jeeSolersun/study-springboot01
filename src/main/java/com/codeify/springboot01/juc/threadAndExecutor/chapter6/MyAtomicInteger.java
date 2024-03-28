//package com.codeify.springboot01.juc.threadAndExecutor.chapter6;
//
//import sun.misc.Unsafe;
//
///**
// * 使用unsafe对象实现自定义AtomicInteger功能
// *
// * @author codeify
// * @since 2022/03/13 15:12
// */
//public class MyAtomicInteger implements Account{
//    public static void main(String[] args) {
//        // 测试
//        Account.demo(new MyAtomicInteger(10000));
//    }
//    private int value;
//    // value字段偏移量
//    private static long valueOffset;
//    private static final Unsafe UNSAFE;
//    public MyAtomicInteger(int value) {
//        this.value = value;
//    }
//
//    static {
//        UNSAFE = UnsafeAccessor.getUnsafe();
//        try {
//            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void decrement(int amount) {
//        for(;;) {
//            int prev = this.value;
//            int next = this.value - amount;
//            // 调用UNSAFE对象的compareAndSwapInt方法
//            if (UNSAFE.compareAndSwapInt(this, valueOffset, prev, next)) {
//                break;
//            }
//        }
//
//    }
//
//    @Override
//    public int getBalance() {
//        return value;
//    }
//
//    @Override
//    public void withDraw(int amount) {
//        decrement(amount);
//    }
//}

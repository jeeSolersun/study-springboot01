package com.codeify.springboot01.extendsTest;

/**
 * created by sunhanbing on 2021/08/03 23:16
 */

class Node {
    final Node getOne(){
        return new Node();
    }
}
class TreeNode extends Node {

}
public class Phone {

    private String brand;
    private int price;
    public Phone(String brand, int price){
        this.brand = brand;
        this.price = price;
    }
    public static void main(String[] args) {
//        Phone phone = new Phone();
//        System.out.println(phone);
        /*for (int i = 0; ; i++){
            System.out.println(i);
            if (i == 100) break;
        }*/
        Node one = new TreeNode().getOne();
        System.out.println(one);
        System.out.println(1==1 && 2==2);
    }
}

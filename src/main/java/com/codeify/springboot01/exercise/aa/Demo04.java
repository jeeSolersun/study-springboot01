package com.codeify.springboot01.exercise.aa;

/**
 * @author codeify
 * @since 2022/01/07 21:58
 */
public class Demo04 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        String find = scanner.next();
        String str = "aAbc123";
//        String replace = str.replace("a", "S");
        String replace = str.replaceAll("a", "S");
        System.out.println("str = " + str);
        System.out.println("replace = " + replace);

    }
}

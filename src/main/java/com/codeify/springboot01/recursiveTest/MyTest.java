package com.codeify.springboot01.recursiveTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by sunhanbing on 2021/08/08 23:43
 */
public class MyTest {

    static List<TreeNode> testData = new ArrayList<>();
    static {
        TreeNode node1 = new TreeNode("root", "null", "root", new ArrayList<>());
        TreeNode node2 = new TreeNode("node2", "root", "node2", new ArrayList<>());
        TreeNode node3 = new TreeNode("node3", "root", "node3", new ArrayList<>());
        TreeNode node4 = new TreeNode("node4", "node2", "node4", new ArrayList<>());
        testData.add(node1);
        testData.add(node2);
        testData.add(node3);
        testData.add(node4);

    }

    public static void main(String[] args) {
//        treeData.stream().collect(Collectors.toMap());
//        int a = 22;
//        String a = "aa";
        TreeNode treeNode = genTreeNodeStructure("root", testData);
        System.out.println(treeNode);
    }

    public static TreeNode genTreeNodeStructure(String id, List<TreeNode> tree){
        TreeNode current = new TreeNode();
        List<TreeNode> containsCurrent = tree.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
        TreeNode findCurrent = containsCurrent.get(0);
        current.setId(findCurrent.getId());
        current.setParentId(findCurrent.getParentId());
        current.setName(findCurrent.getName());
        // 设置relations
        ArrayList<TreeNode> relations = new ArrayList<>();
        tree.stream().forEach(item -> {
            if(id.equals(item.getParentId())){
                relations.add(genTreeNodeStructure(item.getId(), tree));
            }
        });
        current.setRelations(relations);
        return current;
    }
}

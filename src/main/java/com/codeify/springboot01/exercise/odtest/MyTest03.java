package com.codeify.springboot01.exercise.odtest;

import java.util.*;

/**
 * @author codeify
 * @since 2022/01/10 21:45
 */
public class MyTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> relation = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            String[] s = input.split(" ");
            relation.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        System.out.println(relation);
        int idToDelete = Integer.parseInt(scanner.nextLine());
        Node node = new Node(0);
        genNode(node, relation);
        System.out.println("node = " + node);
        Node byId = node.findById(idToDelete);
        System.out.println("byId = " + byId);
        byId.remove(idToDelete);
        Node.list.stream().sorted().forEach(item -> {
            System.out.print(item + " ");
        });


    }

    public static void genNode(Node root, Map<Integer, Integer> relation) {
        Set<Map.Entry<Integer, Integer>> entries = relation.entrySet();
        for (Map.Entry<Integer, Integer> entry: entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(root.getId())) {
                Node node = new Node(key);
                root.addChild(node);
                genNode(node, relation);
            }
        }
    }

}
class Node {
    private Integer id;
    public List<Node> childs;
    public static List<Integer> list = new LinkedList<>();
//    private Node child;
    public Node(int id) {
        this.id = id;
        this.childs = new LinkedList<>();
        list.add(id);

    }

    public boolean remove(Integer id) {
        list.remove(id);
        for(Node node : childs) {
            node.remove(node.getId());
        }
        return false;
    }

    public Node findById(Integer id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            Node findNode = null;
            for (Node node : childs) {
                findNode = node.findById(id);
                if (findNode != null) {
                    return findNode;
                }
            }
        }
        return null;
    }

    public Node addChild(Node child) {
        if (list.contains(id)) {
            childs.add(child);
        }
        return child;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", childs=" + childs +
                '}';
    }
}
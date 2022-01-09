package com.codeify.springboot01.recursiveTest;

import java.util.List;

/**
 * created by sunhanbing on 2021/08/08 23:39
 */
public class TreeNode {
    public TreeNode() {
    }

    public TreeNode(String id, String parentId, String name, List<TreeNode> relations) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.relations = relations;
    }

    private String id;
    private String parentId;
    private String name;
    private List<TreeNode> relations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getRelations() {
        return relations;
    }

    public void setRelations(List<TreeNode> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", relations=" + relations +
                '}';
    }
}

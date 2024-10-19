package com.ruleengine;

public class Node {
    private String type; // "operator" for AND/OR, "operand" for conditions
    private Node left; // left child
    private Node right; // right child
    private String value; // Optional value for operand nodes

    // Constructor for operator nodes (AND/OR)
    public Node(String type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    // Constructor for operand nodes (age > 30, salary > 50000)
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Getters and setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }

    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    @Override
    public String toString() {
        if (this.type.equals("operand")) {
            return this.value;
        } else {
            return "(" + left.toString() + " " + this.type + " " + right.toString() + ")";
        }
    }
}

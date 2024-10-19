package com.ruleengine;

import java.util.Stack;

public class RuleParser {

    // Parse the input rule string into an AST
    public Node parseRule(String rule) {
        Stack<Node> stack = new Stack<>();
        String[] tokens = rule.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "AND":
                case "OR":
                    Node right = stack.pop();
                    Node left = stack.pop();
                    stack.push(new Node(token, left, right));
                    break;
                default:
                    stack.push(new Node("operand", token));
            }
        }
        return stack.pop();
    }
}

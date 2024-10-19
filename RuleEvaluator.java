package com.ruleengine;

import java.util.Map;

public class RuleEvaluator {

    // Evaluate the AST (root node) against the given user attributes
    public boolean evaluate(Node root, Map<String, Object> attributes) {
        if (root.getType().equals("operand")) {
            return evaluateOperand(root.getValue(), attributes);
        } else if (root.getType().equals("AND")) {
            return evaluate(root.getLeft(), attributes) && evaluate(root.getRight(), attributes);
        } else if (root.getType().equals("OR")) {
            return evaluate(root.getLeft(), attributes) || evaluate(root.getRight(), attributes);
        }
        return false;
    }

    // Helper function to evaluate operand nodes
    private boolean evaluateOperand(String condition, Map<String, Object> attributes) {
        if (condition.contains(">")) {
            String[] parts = condition.split(">");
            String key = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());
            return (int) attributes.get(key) > value;
        } else if (condition.contains("<")) {
            String[] parts = condition.split("<");
            String key = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());
            return (int) attributes.get(key) < value;
        }
        // More conditions can be added for =, != etc.
        return false;
    }
}

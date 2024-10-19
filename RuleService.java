package com.ruleengine;

import com.google.gson.Gson;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class RuleService {
    private RuleParser parser = new RuleParser();
    private RuleEvaluator evaluator = new RuleEvaluator();
    private Gson gson = new Gson(); // For JSON serialization/deserialization
    private Connection connection;

    public RuleService(String dbUrl, String dbUser, String dbPassword) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    // Create an AST from a rule string
    public Node createRule(String ruleString) {
        return parser.parseRule(ruleString);
    }

    // Combine multiple rules into a single AST (default combination with AND)
    public Node combineRules(List<String> rules) {
        if (rules.isEmpty()) {
            return null;
        }
        Node combinedRoot = parser.parseRule(rules.get(0));
        for (int i = 1; i < rules.size(); i++) {
            Node nextRule = parser.parseRule(rules.get(i));
            combinedRoot = new Node("AND", combinedRoot, nextRule); // Combine with AND
        }
        return combinedRoot;
    }

    // Evaluate a rule against user data
    public boolean evaluateRule(Node root, Map<String, Object> data) {
        return evaluator.evaluate(root, data);
    }

    // Save the rule and its AST to the database
    public void saveRule(String ruleString, Node ast) throws SQLException {
        String astJson = gson.toJson(ast);
        String query = "INSERT INTO rules (rule_string, ast_data) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ruleString);
            stmt.setString(2, astJson);
            stmt.executeUpdate();
        }
    }

    // Retrieve a rule by ID from the database
    public Node getRuleById(int id) throws SQLException {
        String query = "INSERT INTO rules (rule_string, ast_data) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String astJson = rs.getString("ast_data");
                return gson.fromJson(astJson, Node.class);
            }
        }
        return null;
    }
}

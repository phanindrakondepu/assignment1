package com.ruleengine;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the RuleService with database connection
            RuleService ruleService = new RuleService("jdbc:mysql://localhost:3306/rule_engine", "root", "klu123");

            String rule1 = "age > 30 AND department = 'Sales'";
            Node ast1 = ruleService.createRule(rule1);
            System.out.println("AST 1: " + ast1);

            ruleService.saveRule(rule1, ast1);

            Node fetchedRule = ruleService.getRuleById(1);
            System.out.println("Fetched AST: " + fetchedRule);

            // Create test data
            Map<String, Object> userData = new HashMap<>();
            userData.put("age", 35);
            userData.put("department", "Sales");

            boolean isEligible = ruleService.evaluateRule(fetchedRule, userData);
            System.out.println("Is user eligible: " + isEligible);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

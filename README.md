# Java Rule Engine

## Overview
This Java Rule Engine allows users to define rules using simple expressions (e.g., `age > 30 AND department = 'Sales'`). The engine parses these rules into an Abstract Syntax Tree (AST) and evaluates them against user data. The rules can be stored in a MySQL database for persistent storage.

## Features
- Define rules using logical expressions
- Parse rules into an Abstract Syntax Tree (AST)
- Evaluate rules against user data
- Persist rules in a MySQL database

## Technologies Used
- Java
- MySQL
- JDBC
- Gson (for JSON serialization)

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Server
- Maven (optional, for dependency management)

## Setup

### Database Setup
1. **Create Database:**
   ```sql
   CREATE DATABASE rule_engine;
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.25</version>
</dependency>
javac -cp ".:mysql-connector-java-8.0.25.jar:gson-2.8.8.jar" com/ruleengine/Main.java
java -cp ".:mysql-connector-java-8.0.25.jar:gson-2.8.8.jar" com.ruleengine.Main
String rule1 = "age > 30 AND department = 'Sales'";

### Customization
You can customize this README by adding sections like:
- **Contact Information**: For users to reach out for support.
- **Additional Features**: If you've implemented other functionalities not mentioned above.
- **Testing**: Instructions on how to run tests if applicable.
- **Known Issues**: Any known bugs or limitations.

Make sure to adjust the paths and dependency versions according to your project's requirements!

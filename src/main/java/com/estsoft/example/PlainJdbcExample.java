package com.estsoft.example;

import java.sql.*;


 // TODO
 // stduent, instructor, lecture_course, lecture_applicants 테이블 데이터
 // 조회, 저장, 수정 실습 for 2~30 minutes
 // 예전엔 이렇게 하나하나 반복작업을 했었음.

public class PlainJdbcExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/example";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "SELECT * FROM student";

    public static void main(String[] args) {
        // Open & get a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set after execute query
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.println(", desc: " + rs.getString("desc"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

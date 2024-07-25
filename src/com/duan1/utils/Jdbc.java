/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.utils;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dung8
 */
public class Jdbc {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=GreenMart";
    private static String username = "sa";
    private static String password = "123";

    /*
 * Nạp driver
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Xây dựng PreparedStatement
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     * @return PreparedStatement tạo được
     * @throws java.sql.SQLException lỗi sai cú pháp
     */
    public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    /**
     * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu
     * thao tác dữ liệu
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql *
     */
    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int executeUpdateAndReturnGeneratedId(String sql, Object... args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dburl, username, password); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Creating HoaDon failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating HoaDon failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ
     * liệu
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     */
    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeKho(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);

            boolean hasResultSet = stmt.execute();

            if (hasResultSet) { // Kiểm tra xem có kết quả trả về là ResultSet hay không
                return stmt.getResultSet(); // Nếu là ResultSet, trả về kết quả
            } else {
                // Xử lý khi không có kết quả trả về, nếu cần thiết
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null; // Trả về null khi có lỗi xảy ra
        }
    }

    public static int excuteKhho(String idsp, int sl) {
        int result = 5;
        String sql = "{ CALL ProcessProductQuantity (?, ?,?) }"; // Sử dụng ? để tham số hóa stored procedure
        try (Connection conn = DriverManager.getConnection(dburl, username, password); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, idsp); // Thiết lập giá trị cho tham số đầu tiên
            stmt.setInt(2, sl); // Thiết lập giá trị cho tham số thứ hai
            stmt.registerOutParameter(3, java.sql.Types.INTEGER); // Đăng ký tham số trả về

            stmt.execute(); // Thực thi stored procedure

            result = stmt.getInt(3); // Lấy kết quả trả về từ tham số đã đăng ký

            System.out.println("Kết quả: " + result);
            //         Xử lý kết quả ở đây nếu cần thiết
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

}

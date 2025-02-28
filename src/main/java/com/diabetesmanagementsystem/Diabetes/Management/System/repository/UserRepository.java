package com.diabetesmanagementsystem.Diabetes.Management.System.repository;


import com.diabetesmanagementsystem.Diabetes.Management.System.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long save(User user) {
        String sql = "INSERT INTO USERS (NAME, PASSWORD, EMAIL) " +
                "VALUES (?, ?, ?)";
        return (long) jdbcTemplate.update(sql, user.getName(), user.getPassword(),
                user.getEmail());
    }
    // RowMapper to map rows of result set to User object
    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getLong("user_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

    // Method to get all users from the database
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";  // Assuming the table is named 'users'
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

}


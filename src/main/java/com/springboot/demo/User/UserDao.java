package com.springboot.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertUser(UUID userId, User user){
        String query = "" +
                "INSERT INTO usuario (" +
                " user_id, " +
                " user_name, " +
                " user_password, " +
                " first_name, " +
                " last_name, " +
                " email " +
                ") " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                query,
                userId,
                user.getUserName(),
                user.getUserPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
    }

    public List<User> selectAllUsers(){
        String query = "" +
                "SELECT" +
                " user_id, " +
                " user_name, " +
                " user_password, " +
                " first_name, " +
                " last_name, " +
                " email " +
                "FROM usuario";
        return jdbcTemplate.query(
                query,
                mapUserFromDb());
    }

    public int deleteUser(UUID userId){
        String query = "" +
                "DELETE FROM usuario " +
                "WHERE user_id = ?";
        return jdbcTemplate.update(query, userId);
    }

    public int updateUser(UUID userId, User user){
        String query = "" +
                "UPDATE usuario " +
                "SET user_name = ?, " +
                "user_password = ?, " +
                "first_name = ?, " +
                "last_name = ?, " +
                "email = ? " +
                "WHERE user_id = ?";
        return jdbcTemplate.update(query,
                user.getUserName(),
                user.getUserPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                userId);
    }


    private RowMapper<User> mapUserFromDb() {
        return (resultSet, i) -> {
            String userIdStr = resultSet.getString("user_id");
            UUID userId = UUID.fromString(userIdStr);
            String userName = resultSet.getString("user_name");
            String userPassword = resultSet.getString("user_password");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");

            return new User(
                    userId,
                    userName,
                    userPassword,
                    firstName,
                    lastName,
                    email
            );
        };
    }
}

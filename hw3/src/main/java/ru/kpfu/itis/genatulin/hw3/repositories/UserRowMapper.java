package ru.kpfu.itis.genatulin.hw3.repositories;

import org.springframework.jdbc.core.RowMapper;
import ru.kpfu.itis.genatulin.hw3.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setId(resultSet.getLong(User.ID_COLUMN_NAME));
        user.setUsername(resultSet.getString(User.USERNAME_COLUMN_NAME));
        user.setEmail(resultSet.getString(User.EMAIL_COLUMN_NAME));
        user.setPassword(resultSet.getString(User.PASSWORD_COLUMN_NAME));

        return user;
    }
}

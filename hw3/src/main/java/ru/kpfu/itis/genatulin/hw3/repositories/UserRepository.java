package ru.kpfu.itis.genatulin.hw3.repositories;

import ru.kpfu.itis.genatulin.hw3.models.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User getById(Long id);
    List<User> getByEmail(String email);
    List<User> getByUsername(String username);
    void deleteById(Long id);
    void updateEmail(Long id, String email);
    void updateUsername(Long id, String username);
}

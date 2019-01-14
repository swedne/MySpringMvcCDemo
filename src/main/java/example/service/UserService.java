package example.service;

import example.entity.User;

/**
 * 用户接口层
 */
public interface UserService {
    User findUserById(String id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(String id);
}

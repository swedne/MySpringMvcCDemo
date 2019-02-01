package example.service.impl;

import example.entity.User;
import example.mapper.UserMapper;
import example.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Brian on 2016/3/3.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public User findUserById(String id) {
        User user = userMapper.queryUserById(id);
        return user;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

}

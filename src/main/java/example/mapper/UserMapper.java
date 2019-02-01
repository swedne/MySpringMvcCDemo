package example.mapper;

import example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User queryUserById(String id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(String id);

    List<User> getAllUsers();
}

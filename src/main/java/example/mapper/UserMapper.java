package example.mapper;

import example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    User queryUserById(String id);

    User queryUserByPhone(String phone);

    void register(User user);

    void updateUser(User user);

    void deleteUser(String id);

    List<User> getAllUsers();


}

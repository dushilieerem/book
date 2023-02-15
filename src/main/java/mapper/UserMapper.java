package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {
    int addUser(User user);
//    queryUserByUsername(String name)
    User queryUserByUsername(@Param("name") String name);
//    queryUserByUsernameAndPassword
  User queryUserByUsernameAndPassword(@Param("name") String name, @Param("password") String Password);
//    public int saveUser(User user)

    int deleteUser(@Param("id") Integer id);
}

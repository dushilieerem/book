package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface SpecialSql {
    List<User> getUserByLike(@Param("username") String name);
    int deleteMore(@Param("ids") String ids);
    List<User> getUserByTable(@Param("tablename") String tablename);
    void insertUser(User user);
}

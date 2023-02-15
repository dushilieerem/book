package mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User getUserById(@Param("id") Integer id);
    List<User> getUserList();
    int getcount();
    Map<String,Object> getUserToMap(@Param("id") Integer id);
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
    List<Map<String,Object>> getAllUserToMap2();
}

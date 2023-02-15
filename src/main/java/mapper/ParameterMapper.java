package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.Map;

public interface ParameterMapper {
    User getUserByUsername(String Username);
    User checkLogin(String username,String password);
    User checkLoginByMap(Map<String, Object> map);
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}

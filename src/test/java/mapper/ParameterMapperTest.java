package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParameterMapperTest {

    @Test
    void getUserByUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        User user=parameterMapper.getUserByUsername("admin");
        System.out.println(user);
    }
    @Test
    void checkLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        User user=parameterMapper.checkLogin("admin","admin");
        System.out.println(user);
    }
    @Test
    void checkLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","admin");
        User user=parameterMapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    void checkLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper=sqlSession.getMapper(ParameterMapper.class);
        User user=parameterMapper.checkLoginByParam("admin","admin");
        System.out.println(user);
    }
}
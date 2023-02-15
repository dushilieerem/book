package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SelectMapperTest {

    @Test
    void getUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
    }
    @Test
    void getUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
    }
    @Test
    void getcount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int i = mapper.getcount();
        System.out.println(i);
    }
    @Test
    void getUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = mapper.getUserToMap(1);
        System.out.println(userToMap);
    }
    @Test
    void getAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = mapper.getAllUserToMap();
        System.out.println(userToMap);
    }
    @Test
    void getAllUserToMap2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> allUserToMap2 = mapper.getAllUserToMap2();
        System.out.println(allUserToMap2);
    }


}
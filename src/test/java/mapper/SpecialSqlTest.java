package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialSqlTest {

    @Test
    void getUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSql mapper = sqlSession.getMapper(SpecialSql.class);
        List<User> bb = mapper.getUserByLike("bb");
        System.out.println(bb);

    }
    @Test
    void deleteMore() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSql mapper = sqlSession.getMapper(SpecialSql.class);
        int i = mapper.deleteMore("28,30");
        System.out.println(i);
    }
    @Test
    void getUserByTable() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSql mapper = sqlSession.getMapper(SpecialSql.class);
        List<User> t_user = mapper.getUserByTable("t_user");
        System.out.println(t_user);
    }
    @Test
    void insertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSql mapper = sqlSession.getMapper(SpecialSql.class);
        User user=new User("2222","8299","11@qq.com",null);
       mapper.insertUser(user);
        System.out.println(user);
    }
}
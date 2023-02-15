package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;


import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Test
    void insertUser() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);


    }
    @Test
    void queryUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserByUsername("xdkl");
        System.out.println(user);
    }
    @Test
    void queryUserByUsernameAndPassword(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserByUsernameAndPassword("xdkl","12345");
        System.out.println(user);
    }
}
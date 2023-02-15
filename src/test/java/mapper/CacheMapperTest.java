package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.Employee;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CacheMapperTest {

    @Test
    void cacheone() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Employee cacheone = mapper.cacheone(1);
        sqlSession.clearCache();
        Employee cacheone1 = mapper.cacheone(1);
        System.out.println(cacheone);
    }
    @Test
    void cacheTwo() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession session = sessionFactory.openSession(true);
            SqlSession session1 = sessionFactory.openSession(true);
            CacheMapper mapper = session.getMapper(CacheMapper.class);
            CacheMapper mapper1 = session1.getMapper(CacheMapper.class);
            mapper.cacheTwo(1);

            mapper1.cacheTwo(1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
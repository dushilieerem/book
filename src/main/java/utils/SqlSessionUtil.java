package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
  public static SqlSession getSqlSession(){
      SqlSession session=null;
      try {
          InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
          SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
           session = sqlSessionFactory.openSession(true);

      } catch (IOException e) {
          e.printStackTrace();
      }
      return session;
  }
}

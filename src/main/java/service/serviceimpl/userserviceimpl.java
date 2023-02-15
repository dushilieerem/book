package service.serviceimpl;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.User;
import service.userservice;
import utils.SqlSessionUtil;

public class userserviceimpl implements userservice {
    @Override
    public int registUser(User user) {
        String name=user.getUsername();
        int i=0;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        boolean b = existsUsername(user.getUsername());
        if(b==false)
         i = mapper.addUser(user);
        else i=0;
        return i;

    }

    @Override
    public User login(User user) {
        if (user==null) return null;
        String name=user.getUsername();
        String password=user.getPassword();
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        if(!name.equals("")&&!password.equals("")){
            return mapper.queryUserByUsernameAndPassword(name,password);
        }
        return null;
    }

    @Override
    public boolean existsUsername(String name) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserByUsername(name);
        if(user!=null) return true;
     else   return false;
    }
}

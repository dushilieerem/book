package service.serviceimpl;

import org.junit.jupiter.api.Test;
import pojo.User;
import service.userservice;

import static org.junit.jupiter.api.Assertions.*;

class userserviceimplTest {
    userserviceimpl userserviceimpl = new userserviceimpl();
    @Test
    void registUser() {
        User user = new User("xdkl1","123456",null,null);
        int i = userserviceimpl.registUser(user);
        System.out.println(i);
    }

    @Test
    void login() {
        User user = new User("xdkl","123456",null,null);
        User login = userserviceimpl.login(user);
        if(login==null) {System.out.println("登录失败"); return;}
        if (user.getPassword().equals(login.getPassword())) {

            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    @Test
    void existsUsername() {
        boolean xdkl = userserviceimpl.existsUsername("xdkl");
        System.out.println(xdkl);
    }
}
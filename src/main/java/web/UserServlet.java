package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.User;
import service.serviceimpl.userserviceimpl;
import service.userservice;
import utils.WebUtils;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    userservice userservice=new userserviceimpl();
    protected void regist(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("yzm");

        //        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if ("abc".equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userservice.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

//        跳回注册页面
                req.getRequestDispatcher("page/user/regist.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Sservice保存到数据库
                userservice.registUser(new User(username, password, email,null));
//
//        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("page/user/login.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息，保存到Request域中
            req.setAttribute("tsmsg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("page/user/regist.jsp").forward(req, resp);
        }
    }


    protected void login(HttpServletRequest Request,HttpServletResponse Response) throws ServletException, IOException {
        userservice userserviceimpl = new userserviceimpl();
        String username=Request.getParameter("username");
        String password=Request.getParameter("password");
        User login = userserviceimpl.login(new User(username, password, null, null));
        if(login==null){
            System.out.println("登录失败");
            Request.setAttribute("tsmsg","账号或者密码错误");
            Request.setAttribute("username",username);
            Request.getRequestDispatcher("page/user/login.jsp");
        }else{
            Request.getSession().setAttribute("user",login);
            Request.getRequestDispatcher("index.jsp").forward(Request,Response);
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String action=request.getParameter("action");
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            declaredMethod.invoke(this,request,response);
            System.out.println("11");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

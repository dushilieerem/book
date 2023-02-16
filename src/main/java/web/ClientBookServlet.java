package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Page;
import utils.WebUtils;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "ClientBookServlet", value = "/ClientBookServlet")
public class ClientBookServlet extends HttpServlet {


    protected  void page(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
     int pageNO= WebUtils.parseInt(request.getParameter("pageNo"),1);
     int pageSize=WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

system.out.println("11");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

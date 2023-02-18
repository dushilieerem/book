package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojo.Book;
import pojo.Page;
import service.bookservice;
import service.serviceimpl.bookserviceimpl;
import utils.WebUtils;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "ClientBookServlet", value = "/ClientBookServlet")
public class ClientBookServlet extends HttpServlet {
    bookservice bookservice = new bookserviceimpl();
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            int min=WebUtils.parseInt(req.getParameter("min"),0);
            int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
            int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
            int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookservice.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("ClientBookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/page/client/index.jsp").forward(req,resp);


    }

    protected  void page(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page=bookservice.page(pageNo,pageSize);
     page.setUrl("ClientBookServlet?action=page");
     request.setAttribute("page",page);

     request.getRequestDispatcher("/page/client/index.jsp").forward(request,response);

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        try {

            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

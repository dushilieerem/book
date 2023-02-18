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
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private bookservice bookService=new bookserviceimpl();
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
// 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
// 2、调用 BookService.updateBook( book );修改图书
        bookService.updateBook(book);
// 3、重定向回图书列表管理页面
// 地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/BookServlet?action=list");
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("BookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/manager/book_manager.jsp").forward(req,resp);
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
//1 获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//2 调用 bookService.queryBookById 查询图书
        Book book = bookService.queryBookById(id);
//3 保存到图书到 Request 域中
        req.setAttribute("book", book) ;
//4 请求转发到。pages/manager/book_edit.jsp 页面
        req.getRequestDispatcher("/manager/book_edit.jsp").forward(req,resp);
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
//1 通过 BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
//2 把全部图书保存到 Request 域中
        req.setAttribute("books", books);
//3、请求转发到/pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/manager/book_manager.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
// 1、获取请求的参数 id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
// 2、调用 bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
// 3、重定向回图书列表管理页面
// /book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/BookServlet?action=list");
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
// 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        if(book.getName().equals("")) return;
// 2、调用 BookService.addBook()保存图书
        bookService.addBook(book);
// 3、跳到图书列表页面
// /manager/bookServlet?action=list
// req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/BookServlet?action=list");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");

        try {

            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

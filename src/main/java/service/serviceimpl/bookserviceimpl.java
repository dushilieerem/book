package service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.bookMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Book;
import pojo.Page;
import service.bookservice;
import utils.SqlSessionUtil;

import java.util.List;
import java.util.Objects;

public class bookserviceimpl implements bookservice {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    bookMapper mapper = sqlSession.getMapper(bookMapper.class);


    @Override
    public Page<Book> page(int pageNo, int pageSize) {
//        // 设置每页显示的数量
//        page.setPageSize(pageSize);
//        // 求总记录数
//        Integer pageTotalCount = bookDao.queryForPageTotalCount();
//        // 设置总记录数
//        page.setPageTotalCount(pageTotalCount);
//        // 求总页码
//        Integer pageTotal = pageTotalCount / pageSize;
//        if (pageTotalCount % pageSize > 0) {
//            pageTotal+=1;
//        }
//        // 设置总页码
//        page.setPageTotal(pageTotal);
//
//        // 设置当前页码
//        page.setPageNo(pageNo);
//
//        // 求当前页数据的开始索引
//        int begin = (page.getPageNo() - 1) * pageSize;
//        // 求当前页数据
//        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
//        // 设置当前页数据
//        page.setItems(items);

       Page<Book> bookPage=new Page<Book>();
        // 设置每页显示的数量
        bookPage.setPageSize(pageSize);
        // 求总记录数
        PageHelper.startPage(pageNo,pageSize);
        List<Book> books = mapper.queryBooks();
        PageInfo<Book> pageInfo=new PageInfo<Book>(books,5);
        bookPage.setItems(books);

//        System.out.println(pageInfo.getPages());//总页数
//        System.out.println(pageInfo.getPageSize());//每页显示的条数
//        System.out.println(pageInfo.getPageNum());//当前页的页码
//        System.out.println(pageInfo.getTotal());//总记录数
//        System.out.println(pageInfo.getSize());//每页显示的条数
        int PageNum=(int) pageInfo.getPageNum();
        bookPage.setPageNo( PageNum);
        bookPage.setPageSize(pageInfo.getPageSize());
        bookPage.setPageTotal(pageInfo.getPages());
        return bookPage;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        PageHelper.startPage(pageNo,pageSize);
        List<Book> books = mapper.queryForPageItemsByPrice(pageNo,pageSize,min,max);
        Page<Book> bookPage=new Page<Book>();
        // 设置每页显示的数量
        bookPage.setPageSize(pageSize);
        // 求总记录数

        PageInfo<Book> pageInfo=new PageInfo<Book>(books,5);
        bookPage.setItems(books);
        int PageNum=(int) pageInfo.getPageNum();
        bookPage.setPageNo( PageNum);
        bookPage.setPageSize(pageInfo.getPageSize());
        bookPage.setPageTotal(pageInfo.getPages());
        return bookPage;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void deleteBookById(Integer id) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public Book queryBookById(Integer id) {
        return null;
    }

    @Override
    public List<Book> queryBooks() {
        List<Book> books = mapper.queryBooks();
        return books;
    }

    @Override
    public int queryForPageTotalCount() {
        return 0;
    }
}

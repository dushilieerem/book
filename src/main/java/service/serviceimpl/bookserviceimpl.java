package service.serviceimpl;

import pojo.Book;
import pojo.Page;
import service.bookservice;
import utils.SqlSessionUtil;

import java.util.List;

public class bookserviceimpl implements bookservice {

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        return null;
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
        return null;
    }
}

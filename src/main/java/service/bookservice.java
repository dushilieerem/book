package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

public interface bookservice {
public Page<Book> page(int pageNo,int pageSize);
public Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max);
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book  queryBookById(Integer id);
    public List<Book> queryBooks();

}
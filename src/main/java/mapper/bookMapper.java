package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Book;

import java.util.List;

public interface bookMapper {
//    public void addBook(Book book);
    public void addBook(Book book);
    public void deleteBookById(@Param("id") Integer id);
     public void updateBook(Book book);
     public Book  queryBookById(@Param("id") Integer id);
    public List<Book> queryBooks();
}

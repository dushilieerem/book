package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Book;
import utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class bookMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    bookMapper mapper = sqlSession.getMapper(bookMapper.class);
    @Test
    void addBook1() {
        int i = mapper.queryForPageTotalCount();
        System.out.println(i);
    }
    @Test
    void queryForPageItemsByPric() {
        List<Book> books = mapper.queryForPageItemsByPrice(1, 5, 20, 100);
        System.out.println(books);
    }

    @Test
    void addBook() {
        Book book = new Book(1,"11",null,null,2,null,null);
        mapper.addBook(book);
    }

    @Test
    void deleteBookById() {
        mapper.deleteBookById(35);
    }

    @Test
    void updateBook() {
    }

    @Test
    void queryBookById() {
        Book book = mapper.queryBookById(1);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = mapper.queryBooks();
        System.out.println(books);
    }
}
package service.serviceimpl;

import org.junit.jupiter.api.Test;
import pojo.Book;
import pojo.Page;
import service.bookservice;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class bookserviceimplTest {

    bookservice bookserviceimpl = new bookserviceimpl();
    @Test
    void page() {
        Page<Book> page = bookserviceimpl.page(1, 4);

    }

    @Test
    void pageByPrice() {
        Page<Book> page = bookserviceimpl.pageByPrice(1, 5, 20, 100);


    }

    @Test
    void addBook() {
    }

    @Test
    void deleteBookById() {
    }


    @Test
    void updateBook() {
    }

    @Test
    void queryBookById() {
    }

    @Test
    void queryBooks() {
        List<Book> books = bookserviceimpl.queryBooks();
        System.out.println(books);
    }
}
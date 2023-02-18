package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

/**
 * The interface Bookservice.
 */
public interface bookservice {
    /**
     * Page page.
     *
     * @param pageNo   the page no
     * @param pageSize the page size
     * @return the page
     */
    public Page<Book> page(int pageNo,int pageSize);

    /**
     * Page by price page.
     *
     * @param pageNo   the page no
     * @param pageSize the page size
     * @param min      the min
     * @param max      the max
     * @return the page
     */
    public Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max);

    /**
     * Add book.
     *
     * @param book the book
     */
    public void addBook(Book book);

    /**
     * Delete book by id.
     *
     * @param id the id
     */
    public void deleteBookById(Integer id);

    /**
     * Update book.
     *
     * @param book the book
     */
    public void updateBook(Book book);

    /**
     * Query book by id book.
     *
     * @param id the id
     * @return the book
     */
    public Book  queryBookById(Integer id);

    /**
     * Query books list.
     *
     * @return the list
     */
    public List<Book> queryBooks();

    /**
     * Query for page total count int.
     *
     * @return the int
     */
    public int queryForPageTotalCount();

}

package njust.data;

import java.util.*;

public interface IBookDao {
   public List<Book> getAllBooks();
   public Book getBook(int id);
   public boolean updateBook(Book book);
   public boolean deleteBookByName(Book book);
   public boolean deleteBookById(Book book);
   public boolean addBook(Book book);
   public boolean addBatchedBook(List<Book> books);
   public int  getCountofBooks();
   public List<Book> getAllBooks(int curPage,int pageSize);

}

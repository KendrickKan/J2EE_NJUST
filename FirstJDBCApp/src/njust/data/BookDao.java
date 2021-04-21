package njust.data;

import java.util.*;

public interface BookDao {
   public List<Book> getAllBooks();
   public Book getBook(int id);
   public boolean updateBook(Book book);
   public boolean deleteBook(Book book);
   public boolean addBook(Book book);

}

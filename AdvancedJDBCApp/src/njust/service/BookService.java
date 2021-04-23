package njust.service;

import njust.data.*;
import java.util.*;

public class BookService {
    private BookDaoImpl bdi = null;
    
	public BookService() {
		bdi = new BookDaoImpl();
	}
	
	public boolean addSingleBook(Book book){
		if(bdi.getBook(book.getBookId()) == null){
		   return bdi.addBook(book);
		}
		return false;
	}
	
	public boolean delBookById(Book book){
		if(bdi.getBook(book.getBookId()) != null){
			return bdi.deleteBookById(book);
		}
		return false;		
	}
	
	public boolean updateBook(Book book){
		if(bdi.getBook(book.getBookId()) != null){
		   return bdi.updateBook(book);
		}
		return false;
	}
	
	public List<Book> getAllBooks(){
		return bdi.getAllBooks();
	}

}

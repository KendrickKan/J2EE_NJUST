package njust.data;

public class Book {
	
	private int bookId;
	private String author;
	private String title;
	private int quantity;
	
	public Book(){
		
	}
	
	public Book(int id, String author, String title, int quantity){
		 this.bookId = id;
		 this.author = author;
		 this.title = title;
		 this.quantity = quantity;
	}
	 
	public Book(int id){
	   this.bookId = id;
	   this.author = "";
	   this.title ="";
	   this.quantity = 0;
	}
	
	public int getBookId() {
	  return bookId;
	}
		 
	public void setBookId(int id) {
	  this.bookId = id;
	}
	 
	public String getAuthor() {
	  return author;
	}
	 
	public void setAuthor(String author) {
	  this.author = author;
	}
	
	public String getTitle() {
	  return title;
	}
		 
	public void settTitle(String title) {
	  this.title = title;
	}
	
	public int getQuantity() {
	  return quantity;
	}
			 
	public void setQuantity(int count) {
	  this.quantity = count;
	}
}

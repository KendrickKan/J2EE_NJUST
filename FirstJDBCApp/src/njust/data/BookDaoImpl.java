package njust.data;

import java.sql.*;

import javax.sql.*;

import java.util.*;

import njust.utils.SimpleJDBCUtils;


public class BookDaoImpl implements BookDao{
	//�б��ǵ���һ�����ݿ�
	   List<Book> books;
	 
	   public BookDaoImpl(){
		  books = new ArrayList<Book>();
  
	   }
	   
	   @Override
	   public boolean deleteBook(Book book) {
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "delete from books where id="+book.getBookId();
		   //System.out.println(sql);
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     rows = stmt.executeUpdate(sql);
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, null);
		   if(rows > 0){
			   return true;
		   }else {
			   return false;
		   }
	   }
	 
	   //�����ݿ��м���ѧ������
	   @Override
	   public List<Book> getAllBooks() {
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   Book book = null;
		   String sql = "select * from books";
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery(sql);
		     while(rs.next()){
		    	 book = new Book();
		    	 book.setBookId(rs.getInt(1));
		    	 book.setAuthor(rs.getString(2));
		    	 book.settTitle(rs.getString(3));
		    	 book.setQuantity(rs.getInt(4));
		    	 books.add(book);		    	 
		     }
		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, rs);
	       return books;
	   }
	 
	   @Override
	   public Book getBook(int id) {
		   Connection conn =null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   Book book = null;
		   String sql = "select * from books where id="+id;
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery(sql);
		     while(rs.next()){
		    	 book = new Book();
		    	 book.setBookId(rs.getInt(1));
		    	 book.setAuthor(rs.getString(2));
		    	 book.settTitle(rs.getString(3));
		    	 book.setQuantity(rs.getInt(4));
		    	 books.add(book);		    	 
		     }		     
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, rs);
	       return book;
	   }
	 
	   @Override
	   public boolean updateBook(Book book) {
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "update books set author ='"+book.getAuthor() +"', title='"+book.getTitle()+
				   "', quantity=" +book.getQuantity() +" where id=" +book.getBookId();
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     rows = stmt.executeUpdate(sql);
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, null);
		   if(rows > 0){
			   return true;
		   }else {
			   return false;
		   }	    
	   }
	   
	   public boolean addBook(Book book){
		   Connection conn =null;
		   Statement stmt = null;
		   int rows = -1;
		   String sql = "insert into books values("+book.getBookId() + ",'"+book.getAuthor() 
				                        +"','"+book.getTitle()+"'," +book.getQuantity() +")";
		   //System.out.println(sql);
		   try{
		     conn = SimpleJDBCUtils.getConnection();
		     stmt = conn.createStatement();
		     Book tmp = this.getBook(book.getBookId());
		     if(tmp == null){
		       rows = stmt.executeUpdate(sql);
		     }
		   }catch(SQLException e){
			   e.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   SimpleJDBCUtils.release(conn, stmt, null);
		   if(rows > 0){
			   return true;
		   }else {
			   return false;
		   }	
	   }
	   
	   public static void main(String[] args) {
		   BookDaoImpl bdi = new BookDaoImpl();
		   
		   //1������getAllBooks()
		   List<Book> listB = bdi.getAllBooks();
		   System.out.println(listB);
		   if(listB!=null){
			   int size = listB.size();
			   for(int i=0;i<size;i++){
				  Book book = listB.get(i);
				  System.out.println(book.getBookId()+"  "+book.getAuthor()+" "
				               +book.getTitle()+"  "+ book.getQuantity());
			   }			   
		   }
		   
		   //2������insert����,�����ظ�������ͬid����
		   Book book1 = new Book();
		   book1.setBookId(10);
		   book1.setAuthor("njust-cs");
		   book1.settTitle("servlet���");
		   book1.setQuantity(1230);
		   bdi.addBook(book1);
		   
		   //3������update����
		   book1.setAuthor("njust-cs-se");
		   book1.settTitle("servlet���");
		   book1.setQuantity(1210);
		   bdi.updateBook(book1);
		   
		   //4������update����
		   book1.setBookId(1);
		   bdi.deleteBook(book1);
		   
		   //5������find����
		   book1 = bdi.getBook(10);
		   System.out.println(book1.getBookId()+"  "+book1.getAuthor()+" "
	               +book1.getTitle()+"  "+ book1.getQuantity());
	   }

}

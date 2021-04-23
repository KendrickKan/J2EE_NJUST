package njust.data;

import java.sql.*;

import javax.sql.*;

import java.util.*;

import njust.utils.*;


public class BookDaoImpl implements IBookDao{
	   List<Book> books;
	 
	   public BookDaoImpl(){
		  books = new ArrayList<Book>();
  
	   }
	   
		@Override
		public boolean deleteBookByName(Book book) {
			Map<String, Object> whereMap = new HashMap<>();
		    whereMap.put("title", book.getTitle());
		    try {
	            int count = DBUtil.delete("books", whereMap);
	            if(count > 0){
	            	return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
		}

		@Override
		public boolean deleteBookById(Book book) {
			Map<String, Object> whereMap = new HashMap<>();
		    whereMap.put("id", book.getBookId());
		    try {
	            int count = DBUtil.delete("books", whereMap);
	            if(count > 0){
	            	return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
		}
	 
	   //从数据库中检索
	   @Override
	   public List<Book> getAllBooks() {
		   Map<String, Object> map = null;
		   Book book = null;
		   try {
			   List<Map<String, Object>> list = DBUtil.query("books",null);
			   int size = list.size();
			   for(int i=0;i<size;i++){
				   map = list.get(i);
				   book = new Book(((Integer)map.get("id")).intValue(),
						   (String)map.get("author"),
						   (String)map.get("title"),
						   ((Integer)map.get("quantity")).intValue());
				   books.add(book);
			   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
		   
	       return books;
	   }
	 
	   @Override
	   public Book getBook(int id) {
		   Book book = null;
		   Map<String, Object> map = null;
		   Map<String, Object> whereMap = new HashMap<>();
		   whereMap.put("id", id);
		   try {
			   List<Map<String, Object>> list = DBUtil.query("books",whereMap);
			   int size = list.size();
			   if(size == 1){
				   map = list.get(0);
				   book = new Book(((Integer)map.get("id")).intValue(),
						   (String)map.get("author"),
						   (String)map.get("title"),
						   ((Integer)map.get("quantity")).intValue());
			   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	       return book;
	   }
	 
	   @Override
	   public boolean updateBook(Book book) {
		   Map<String, Object> whereMap = new HashMap<>();
		   whereMap.put("id", book.getBookId());
		   Map<String, Object> valueMap = new HashMap<>();
		   if( book.getAuthor()!=null ){
		      valueMap.put("author", book.getAuthor());
		   }
		   if( book.getTitle()!=null ){
			  valueMap.put("title", book.getTitle());
		   }
		   valueMap.put("quantity", book.getQuantity());		   
		   
		   try {
			   int count = DBUtil.update("books",valueMap, whereMap);
			   if(count > 0){
				   return true;
			   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
		    return false;
	   }
	   
	   public boolean addBook(Book book){
		   Map<String, Object> valueMap = new HashMap<>();
		   valueMap.put("id", book.getBookId());
		   valueMap.put("author",book.getAuthor());
		   valueMap.put("title",book.getTitle());
		   valueMap.put("quantity",book.getQuantity());
		   try {
			   int count = DBUtil.insert("books", valueMap);
			   if(count > 0){
				   return true;
			   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
		    return false;		   
	   }
	   
		@Override
		public boolean addBatchedBook(List<Book> books) {
		    List<Map<String, Object>> datas = new ArrayList<>();
		    if(books != null){
			    for (int i = 0; i < books.size(); i++) {
			        Map<String, Object> map = new HashMap<>();
			        map.put("id", books.get(i).getBookId());
			        map.put("author", books.get(i).getAuthor());
			        map.put("title", books.get(i).getTitle());
			        map.put("quantity", books.get(i).getQuantity());
			        datas.add(map);
			     }
			     try {
			        long start = System.currentTimeMillis();
			        DBUtil.insertAll("books", datas);
			        System.out.println("共耗时" + (System.currentTimeMillis() - start));
			     } catch (SQLException e) {
			        e.printStackTrace();
			     }
		    }
		    return false;
		}
		
		@Override
		public int getCountofBooks() {
			try {
			   List<Map<String, Object>> list = DBUtil.query("books",null);
			   return list.size();
		    } catch (SQLException e) {
		       e.printStackTrace();
		    } catch (Exception e){
		       e.printStackTrace();
		    }
			return 0;
		}

		@Override
		public List<Book> getAllBooks(int curPage, int pageSize) {
			Map<String, Object> map = null;
			Book book = null;
			String sql ="select * from books limit "+ (curPage-1)*pageSize+","+pageSize;
			try {
				List<Map<String, Object>> list = DBUtil.query(sql);
				int size = list.size();
				for(int i=0;i<size;i++){
				  map = list.get(i);
				  book = new Book(((Integer)map.get("id")).intValue(),
						   (String)map.get("author"),
						   (String)map.get("title"),
			    		   ((Integer)map.get("quantity")).intValue());
			      books.add(book);
		        }
		     } catch (SQLException e) {
		        e.printStackTrace();
		     } catch (Exception e){
		        e.printStackTrace();
		     }
			 return books;
		}
	   
	   public static void main(String[] args) {
		   BookDaoImpl bdi = new BookDaoImpl();
		   
		   //1、测试getAllBooks()
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
		   
		   //2、测试insert操作,不能重复插入相同id的书
		   Book book1 = new Book();
		   book1.setBookId(11);
		   book1.setAuthor("njust-cs");
		   book1.settTitle("servlet编程");
		   book1.setQuantity(1230);
		   if(bdi.getBook(book1.getBookId()) == null){
			   bdi.addBook(book1);
		   }
		   
		   
		   //3、测试update操作
		   book1.setAuthor("njust-cs-se");
		   book1.settTitle("servlet编程");
		   book1.setQuantity(1210);
		   bdi.updateBook(book1);
		   
		   //4、测试delete操作
		   book1.setBookId(1);
		   bdi.deleteBookById(book1);
		   
		   //5、测试find操作
		   book1 = bdi.getBook(10);
		   System.out.println(book1.getBookId()+"  "+book1.getAuthor()+" "
	               +book1.getTitle()+"  "+ book1.getQuantity());
		   
		   //6、批量添加 
		   int COUNT =20;
		   listB = new ArrayList<Book>();		   
		   for(int j = 0;j<COUNT;j++){
			   Book book= new Book(500+j,"njust-"+j,"软件课程设计--"+j,1200);
			   listB.add(book);
		   }
		   bdi.addBatchedBook(listB);		   
	   }



}

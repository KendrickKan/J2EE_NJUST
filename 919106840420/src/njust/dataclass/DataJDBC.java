package njust.dataclass;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

public class DataJDBC {
	private String driverName;
	private String dbpName;
	private String dbUrl;
	private int maxCharLiteralLength;
	private int maxColumnsInTable;
	
	private int maxRowSize;
	private int maxConnections;
	private int maxTablesInSelect;
	Connection con=null;
	DatabaseMetaData dbMetaData;
	String url="jdbc:mysql://localhost:3306/CourseManagement";
	String user="root";
	String password="kendrick21";
	
	public DataJDBC(int type){
		try{
			if(type == 1){
			   con = this.getConnectionByDriverManager();
			}else {
			   con = this.getConnectionByDataSource();
			}
			if (con != null){
				dbMetaData=con.getMetaData();
				driverName=dbMetaData.getDriverName();
				dbpName=dbMetaData.getDatabaseProductName();
				dbUrl=dbMetaData.getURL();
				System.out.println(dbUrl);
				maxCharLiteralLength=dbMetaData.getMaxCharLiteralLength();
				maxColumnsInTable=dbMetaData.getMaxColumnsInTable();
				maxRowSize=dbMetaData.getMaxRowSize();
				maxConnections=dbMetaData.getMaxConnections();
				maxTablesInSelect=dbMetaData.getMaxTablesInSelect();
				con.close();
			}else {
				System.out.println("fail to construct a connection to Mysql");
			}
		}catch(SQLException e){
			System.err.println("SQLException:"+e.getMessage());
		}
	
	}
	
	public Connection getConnectionByDriverManager(){
		Connection conn = null;
		try{
		   Class.forName("com.mysql.jdbc.Driver");
		   conn=DriverManager.getConnection(url,user,password);
		}catch(SQLException e){
		   System.err.println("SQLException:"+e.getMessage());
		}catch(ClassNotFoundException e){
		   System.err.println("ClassNotFoundException:"+e.getMessage());
		}
		return conn;
	}
	
	public Connection getConnectionByDataSource(){
		Connection conn = null;
		try{
			String jndi = "java:comp/env/jdbc/lib";
			
			Context ctx = (Context) new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(jndi);
			System.out.println(jndi);
			System.out.println(ds);
			conn = ds.getConnection();
		}catch(SQLException e){
		   System.err.println("SQLException:"+e.getMessage());
		}catch(NamingException e){
		   System.err.println("ClassNotFoundException:"+e.getMessage());
		}
		return conn;
	}
	
	public String getDriverName(){
		return driverName;
	}
	
	public void setDriverName(String driverName){
		this.driverName=driverName;
	}
	
	public String getDbpName(){
			return dbpName;
		}
	
	public void setDbpName(String dbpName){
		this.dbpName=dbpName;
	}
	
	public String getDbUrl(){
			return dbUrl;
		}
	
	public void setDbUrl(String dbUrl){
		this.dbUrl=dbUrl;
	}
	
	
	public int getMaxCharLiteralLength() {
		return maxCharLiteralLength;
	}
	
	public void setMaxCharLiteralLength(int maxCharLiteralLength) {
		this.maxCharLiteralLength = maxCharLiteralLength;
	}
	
	public int getMaxColumnsInTable() {
		return maxColumnsInTable;
	}
	
	public void setMaxColumnsInTable(int maxColumnsInTable) {
		this.maxColumnsInTable = maxColumnsInTable;
	}
	
	public int getMaxRowSize() {
		return maxRowSize;
	}
	
	public void setMaxRowSize(int maxRowSize) {
		this.maxRowSize = maxRowSize;
	}
	
	public int getMaxConnections() {
		return maxConnections;
	}
	
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
	
	public int getMaxTablesInSelect() {
		return maxTablesInSelect;
	}
	
	public void setMaxTablesInSelect(int maxTablesInSelect) {
		this.maxTablesInSelect = maxTablesInSelect;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DataJDBC(1);
		System.out.print("execute successfully!");

	}
}

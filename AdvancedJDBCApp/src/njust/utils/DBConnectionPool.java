package njust.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���ݿ����ӳض��󣬵���
 * Created by yuandl on 2016-12-16.
 */
public class DBConnectionPool {
    private static volatile DBConnectionPool dbConnection;
    private ComboPooledDataSource cpds;

    /**
     * �ڹ��캯����ʼ����ʱ���ȡ���ݿ�����
     */
    private DBConnectionPool() {
        try {
            /**ͨ�������ļ���ȡ���ݿ����ӵĲ���ֵ**/
        	String driverClassName = null;
            String url = null;
            String username = null;
            String password = null;
            Properties properties = new Properties();
//            FileInputStream fileInputStream = new FileInputStream("src/config/jdbc-mysql.properties");;
            InputStream is = DBConnectionPool.class.getClassLoader().getResourceAsStream("/db.properties");
            if(is!=null){
                properties.load(is);
                System.out.println("here");
                //��ȡ�����ļ�����Ϣ
                driverClassName = properties.getProperty("driver");            
                url = properties.getProperty("url");
                username = properties.getProperty("username");
                password = properties.getProperty("password");
             }else {
            	 driverClassName = "com.mysql.jdbc.Driver";            
                 url = "jdbc:mysql://localhost:3306/store";
                 username = "root";
                 password = "root";
             }  

            /**���ݿ����ӳض���**/
            cpds = new ComboPooledDataSource();

            /**�������ݿ���������**/
            cpds.setDriverClass(driverClassName);
            /**�������ݿ����ӵ�ַ**/
            cpds.setJdbcUrl(url);
            /**�������ݿ������û���**/
            cpds.setUser(username);
            /**�������ݿ���������**/
            cpds.setPassword(password);

            /**��ʼ��ʱ������������,Ӧ��minPoolSize��maxPoolSize֮��ȡֵ.Ĭ��Ϊ3**/
            cpds.setInitialPoolSize(3);
            /**���ӳ��б����������������.Ĭ��Ϊ15**/
            cpds.setMaxPoolSize(10);
            /**�����ӳ��е���������ʱ��C3POһ���Դ����µ�������Ŀ;**/
            cpds.setAcquireIncrement(1);
            /**�����������������ӳ��еĿ�������,Ĭ��Ϊ0��ʾ�����;**/
            cpds.setIdleConnectionTestPeriod(60);
            /**������ʱ��,��������ʱ������ӽ�������.Ϊ0����������������.Ĭ��Ϊ0;**/
            cpds.setMaxIdleTime(3000);

            /**���������Ĵ���ֻ����Ҫ��ʱ��ʹ�����������Ϊtrue��ô��ÿ��connection�ύ��
             ʱ�򶼽�У������Ч�ԡ�����ʹ��idleConnectionTestPeriod��automaticTestTable
             �ȷ������������Ӳ��Ե����ܡ�Default: false**/
            cpds.setTestConnectionOnCheckout(true);

            /**�����Ϊtrue��ô��ȡ�����ӵ�ͬʱ��У�����ӵ���Ч�ԡ�Default: false **/
            cpds.setTestConnectionOnCheckin(true);
            /**�����ڴ����ݿ��ȡ�µ�����ʧ�ܺ��ظ����Ի�ȡ�Ĵ�����Ĭ��Ϊ30;**/
            cpds.setAcquireRetryAttempts(30);
            /**���������м��ʱ��Ĭ��Ϊ1000����**/
            cpds.setAcquireRetryDelay(1000);
            /** ��ȡ����ʧ�ܽ����������еȴ���ȡ���ӵ��߳��쳣,
             ��������Դ����Ч�ı���,�����´ε���getConnection()��ʱ��������Ի�ȡ����.�����Ϊtrue,
             ��ô���Ի�ȡ����ʧ�ܺ������Դ�������Ѿ��Ͽ������ùر�.Ĭ��Ϊfalse**/
            cpds.setBreakAfterAcquireFailure(true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }

    /**
     * ��ȡ���ݿ����Ӷ��󣬵���
     *
     * @return
     */
    public static DBConnectionPool getInstance() {
        if (dbConnection == null) {
            synchronized (DBConnectionPool.class) {
                if (dbConnection == null) {
                    dbConnection = new DBConnectionPool();
                }
            }
        }
        return dbConnection;
    }

    /**
     * ��ȡ���ݿ�����
     *
     * @return ���ݿ�����
     */
    public final synchronized Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    /**
     * finalize()�������������ռ���ɾ������֮ǰ�����������õġ�
     *
     * @throws Throwable
     */
    protected void finalize() throws Throwable {
        DataSources.destroy(cpds);
        super.finalize();
    }
}

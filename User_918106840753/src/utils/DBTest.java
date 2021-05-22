package utils;

import utils.DBUtil;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by xj on 2020-04-14.
 */
public class DBTest {

    public static void main(String[] args) {
    	// 1.���Ե�������
    	//testInsertSingleCourses();
    	// 2.���Ը���
    	//testUpdateCourse();
    	// 3.����ɾ��
    	//testDeleteCourse();
    	// 4.������������
    	//testBatchInsert(10);
		String sql="select * from usr";// limit + 0 +","+10;
		try {
			List<Map<String, Object>> list = DBUtil.query(sql);
	        System.out.println(list.size()+"aaa");
	    }  catch (Exception e){
	        e.printStackTrace();
	     }
    }

    /**
     * ������������
     */
    private static void testBatchInsert(int count) {
        List<Map<String, Object>> datas = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "JDBCUtil����-"+i);
            map.put("creator", "developer-"+i);
            map.put("cdate", new java.sql.Date(System.currentTimeMillis()));
            datas.add(map);
        }
        try {
            long start = System.currentTimeMillis();
            DBUtil.insertAll("courses", datas);
            System.out.println("����ʱ" + (System.currentTimeMillis() - start));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���Բ���
     */
    private static void testInsertSingleCourses() {
        Map<String, Object> map = new HashMap<>();        
        map.put("name", "JSP");
        map.put("creator", "developer-2");
        map.put("cdate", new java.sql.Date(System.currentTimeMillis()));
        try {
            int count = DBUtil.insert("courses", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * ���Ը���
     */
    private static void testUpdateCourse() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "���Ը���");

        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("cId", "7");
        try {
            int count = DBUtil.update("courses", map, whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * ����ɾ��
     */
    private static void testDeleteCourse() {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("cId", 6);
        try {
            int count = DBUtil.delete("courses", whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ѯ��ʽһ
     */
    public static void testQuery1() {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("salary", "10000");
        try {
            DBUtil.query("emp_test", whereMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ѯ��ʽ��
     */
    public static void testQuery2() {
        String where = "job = ?  AND salary = ? ";
        String[] whereArgs = new String[]{"clerk", "3000"};

        try {
            List<Map<String, Object>> list = DBUtil.query("emp_test", where, whereArgs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ѯ��ʽ��
     */
    public static void testQuery3() {
        try {
            List<Map<String, Object>> list = DBUtil.query("emp_test", false, null, null, null, null, null, null, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * SQLע������
     */
    public static void query4() {
        String name = "'1' OR '1'='1'";
        String password = "'1' OR '1'='1'";

        String sql = "SELECT * FROM emp_test WHERE name = " + name + " and password = " + password;
        String where = "name = ?  AND password = ? ";
        String[] whereArgs = new String[]{name, password};

        try {
            DBUtil.query(sql);
            DBUtil.query("emp_test", false, null, where, whereArgs, null, null, null, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

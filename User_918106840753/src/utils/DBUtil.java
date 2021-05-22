package utils;

//import com.sun.istack.internal.Nullable;



import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

import utils.JDBCUtils;

/**
 * ���ݿ�JDBC���ӹ�����
 * Created by yuandl on 2016-12-16.
 */
public class DBUtil {

    /**
     * ִ�����ݿ�������
     *
     * @param valueMap  �������ݱ���keyΪ������valueΪ�ж�Ӧ��ֵ��Map����
     * @param tableName Ҫ��������ݿ�ı���
     * @return Ӱ�������
     * @throws SQLException SQL�쳣
     */
    public static int insert(String tableName, Map<String, Object> valueMap) throws SQLException {

        /**��ȡ���ݿ�����Map�ļ�ֵ�Ե�ֵ**/
        Set<String> keySet = valueMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        /**Ҫ������ֶ�sql����ʵ������keyƴ������**/
        StringBuilder columnSql = new StringBuilder();
        /**Ҫ������ֶ�ֵ����ʵ���ǣ�**/
        StringBuilder unknownMarkSql = new StringBuilder();
        Object[] bindArgs = new Object[valueMap.size()];
        int i = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            columnSql.append(i == 0 ? "" : ",");
            columnSql.append(key);

            unknownMarkSql.append(i == 0 ? "" : ",");
            unknownMarkSql.append("?");
            bindArgs[i] = valueMap.get(key);
            i++;
        }
        /**��ʼƴ�����sql���**/
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(tableName);
        sql.append(" (");
        sql.append(columnSql);
        sql.append(" )  VALUES (");
        sql.append(unknownMarkSql);
        sql.append(" )");
        return executeUpdate(sql.toString(), bindArgs);
    }

    /**
     * ִ�����ݿ�������
     *
     * @param datas     �������ݱ���keyΪ������valueΪ�ж�Ӧ��ֵ��Map�����List����
     * @param tableName Ҫ��������ݿ�ı���
     * @return Ӱ�������
     * @throws SQLException SQL�쳣
     */
    public static int insertAll(String tableName, List<Map<String, Object>> datas) throws SQLException {
        /**Ӱ�������**/
        int affectRowCount = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            /**�����ݿ����ӳ��л�ȡ���ݿ�����**/
            connection = JDBCUtils.getConnection();


            Map<String, Object> valueMap = datas.get(0);
            /**��ȡ���ݿ�����Map�ļ�ֵ�Ե�ֵ**/
            Set<String> keySet = valueMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            /**Ҫ������ֶ�sql����ʵ������keyƴ������**/
            StringBuilder columnSql = new StringBuilder();
            /**Ҫ������ֶ�ֵ����ʵ���ǣ�**/
            StringBuilder unknownMarkSql = new StringBuilder();
            Object[] keys = new Object[valueMap.size()];
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                keys[i] = key;
                columnSql.append(i == 0 ? "" : ",");
                columnSql.append(key);

                unknownMarkSql.append(i == 0 ? "" : ",");
                unknownMarkSql.append("?");
                i++;
            }
            /**��ʼƴ�����sql���**/
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ");
            sql.append(tableName);
            sql.append(" (");
            sql.append(columnSql);
            sql.append(" )  VALUES (");
            sql.append(unknownMarkSql);
            sql.append(" )");

            /**ִ��SQLԤ����**/
            preparedStatement = connection.prepareStatement(sql.toString());
            /**���ò��Զ��ύ���Ա����ڳ����쳣��ʱ�����ݿ�ع�**/
            connection.setAutoCommit(false);
            System.out.println(sql.toString());
            for (int j = 0; j < datas.size(); j++) {
                for (int k = 0; k < keys.length; k++) {
                    preparedStatement.setObject(k + 1, datas.get(j).get(keys[k]));
                }
                preparedStatement.addBatch();
            }
            int[] arr = preparedStatement.executeBatch();
            connection.commit();
            affectRowCount = arr.length;
            System.out.println("�ɹ��˲�����" + affectRowCount + "��");
            System.out.println();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return affectRowCount;
    }

    /**
     * ִ�и��²���
     *
     * @param tableName ����
     * @param valueMap  Ҫ���ĵ�ֵ
     * @param whereMap  ����
     * @return Ӱ�������
     * @throws SQLException SQL�쳣
     */
    public static int update(String tableName, Map<String, Object> valueMap, Map<String, Object> whereMap) throws SQLException {
        /**��ȡ���ݿ�����Map�ļ�ֵ�Ե�ֵ**/
        Set<String> keySet = valueMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        /**��ʼƴ�����sql���**/
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append(tableName);
        sql.append(" SET ");

        /**Ҫ���ĵĵ��ֶ�sql����ʵ������keyƴ������**/
        StringBuilder columnSql = new StringBuilder();
        int i = 0;
        List<Object> objects = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            columnSql.append(i == 0 ? "" : ",");
            columnSql.append(key + " = ? ");
            objects.add(valueMap.get(key));
            i++;
        }
        sql.append(columnSql);

        /**���µ�����:Ҫ���ĵĵ��ֶ�sql����ʵ������keyƴ������**/
        StringBuilder whereSql = new StringBuilder();
        int j = 0;
        if (whereMap != null && whereMap.size() > 0) {
            whereSql.append(" WHERE ");
            iterator = whereMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                whereSql.append(j == 0 ? "" : " AND ");
                whereSql.append(key + " = ? ");
                objects.add(whereMap.get(key));
                j++;
            }
            sql.append(whereSql);
        }
        return executeUpdate(sql.toString(), objects.toArray());
    }

    /**
     * ִ��ɾ������
     *
     * @param tableName Ҫɾ���ı���
     * @param whereMap  ɾ��������
     * @return Ӱ�������
     * @throws SQLException SQLִ���쳣
     */
    public static int delete(String tableName, Map<String, Object> whereMap) throws SQLException {
        /**׼��ɾ����sql���**/
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ");
        sql.append(tableName);

        /**���µ�����:Ҫ���ĵĵ��ֶ�sql����ʵ������keyƴ������**/
        StringBuilder whereSql = new StringBuilder();
        Object[] bindArgs = null;
        if (whereMap != null && whereMap.size() > 0) {
            bindArgs = new Object[whereMap.size()];
            whereSql.append(" WHERE ");
            /**��ȡ���ݿ�����Map�ļ�ֵ�Ե�ֵ**/
            Set<String> keySet = whereMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                whereSql.append(i == 0 ? "" : " AND ");
                whereSql.append(key + " = ? ");
                bindArgs[i] = whereMap.get(key);
                i++;
            }
            sql.append(whereSql);
        }
        return executeUpdate(sql.toString(), bindArgs);
    }

    /**
     * ����ִ���������޸ģ�ɾ��
     *
     * @param sql      sql���
     * @param bindArgs �󶨲���
     * @return Ӱ�������
     * @throws SQLException SQL�쳣
     */
    public static int executeUpdate(String sql, Object[] bindArgs) throws SQLException {
        /**Ӱ�������**/
        int affectRowCount = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            /**�����ݿ����ӳ��л�ȡ���ݿ�����**/
            connection = JDBCUtils.getConnection();
            /**ִ��SQLԤ����**/
            preparedStatement = connection.prepareStatement(sql.toString());
            /**���ò��Զ��ύ���Ա����ڳ����쳣��ʱ�����ݿ�ع�**/
            connection.setAutoCommit(false);
            System.out.println(getExecSQL(sql, bindArgs));
            if (bindArgs != null) {
                /**�󶨲�������sqlռλ���е�ֵ**/
                for (int i = 0; i < bindArgs.length; i++) {
                    preparedStatement.setObject(i + 1, bindArgs[i]);
                }
            }
            /**ִ��sql**/
            affectRowCount = preparedStatement.executeUpdate();
            connection.commit();
            String operate;
            if (sql.toUpperCase().indexOf("DELETE FROM") != -1) {
                operate = "ɾ��";
            } else if (sql.toUpperCase().indexOf("INSERT INTO") != -1) {
                operate = "����";
            } else {
                operate = "�޸�";
            }
            System.out.println("�ɹ�" + operate + "��" + affectRowCount + "��");
            System.out.println();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return affectRowCount;
    }

    /**
     * ͨ��sql��ѯ����,
     * ���ã�����sqlע������
     *
     * @param sql
     * @return ��ѯ�����ݼ���
     * @throws SQLException
     */
    public static List<Map<String, Object>> query(String sql) throws SQLException {
        return executeQuery(sql, null);
    }

    /**
     * ִ��sqlͨ�� Map<String, Object>�޶���ѯ������ѯ
     *
     * @param tableName ����
     * @param whereMap  where����
     * @return List<Map<String, Object>>
     * @throws SQLException
     */
    public static List<Map<String, Object>> query(String tableName,
                                                  Map<String, Object> whereMap) throws Exception {
        String whereClause = "";
        Object[] whereArgs = null;
        if (whereMap != null && whereMap.size() > 0) {
            Iterator<String> iterator = whereMap.keySet().iterator();
            whereArgs = new Object[whereMap.size()];
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                whereClause += (i == 0 ? "" : " AND ");
                whereClause += (key + " = ? ");
                whereArgs[i] = whereMap.get(key);
                i++;
            }
        }
        return query(tableName, false, null, whereClause, whereArgs, null, null, null, null);
    }

    /**
     * ִ��sql������������ʽ�Ĳ�ѯ
     *
     * @param tableName   ����
     * @param whereClause where������sql
     * @param whereArgs   where������ռλ���е�ֵ
     * @return List<Map<String, Object>>
     * @throws SQLException
     */
    public static List<Map<String, Object>> query(String tableName,
                                                  String whereClause,
                                                  String[] whereArgs) throws SQLException {
        return query(tableName, false, null, whereClause, whereArgs, null, null, null, null);
    }

    /**
     * ִ��ȫ���ṹ��sql��ѯ
     *
     * @param tableName     ����
     * @param distinct      ȥ��
     * @param columns       Ҫ��ѯ������
     * @param selection     where����
     * @param selectionArgs where������ռλ���е�ֵ
     * @param groupBy       ����
     * @param having        ɸѡ
     * @param orderBy       ����
     * @param limit         ��ҳ
     * @return List<Map<String, Object>>
     * @throws SQLException
     */
    public static List<Map<String, Object>> query(String tableName,
                                                  boolean distinct,
                                                  String[] columns,
                                                  String selection,
                                                  Object[] selectionArgs,
                                                  String groupBy,
                                                  String having,
                                                  String orderBy,
                                                  String limit) throws SQLException {
        String sql = buildQueryString(distinct, tableName, columns, selection, groupBy, having, orderBy, limit);
        return executeQuery(sql, selectionArgs);

    }

    /**
     * ִ�в�ѯ
     *
     * @param sql      Ҫִ�е�sql���
     * @param bindArgs �󶨵Ĳ���
     * @return List<Map<String, Object>>���������
     * @throws SQLException SQLִ���쳣
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object[] bindArgs) throws SQLException {
        List<Map<String, Object>> datas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            /**��ȡ���ݿ����ӳ��е�����**/
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (bindArgs != null) {
                /**����sqlռλ���е�ֵ**/
                for (int i = 0; i < bindArgs.length; i++) {
                    preparedStatement.setObject(i + 1, bindArgs[i]);
                }
            }
            System.out.println(getExecSQL(sql, bindArgs));
            /**ִ��sql��䣬��ȡ�����**/
            resultSet = preparedStatement.executeQuery();
            datas = getDatas(resultSet);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return datas;
    }


    /**
     * ������������װ��List<Map<String, Object>> ����
     *
     * @param resultSet �������
     * @return ����ķ�װ
     * @throws SQLException
     */
    private static List<Map<String, Object>> getDatas(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> datas = new ArrayList<>();
        /**��ȡ����������ݽṹ����**/
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            Map<String, Object> rowMap = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                rowMap.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            datas.add(rowMap);
        }
        System.out.println("�ɹ���ѯ����" + datas.size() + "������");
        for (int i = 0; i < datas.size(); i++) {
            Map<String, Object> map = datas.get(i);
//            System.out.println("��" + (i + 1) + "�У�" + map);
        }
        return datas;
    }


    /**
     * Build an SQL query string from the given clauses.
     *
     * @param distinct true if you want each row to be unique, false otherwise.
     * @param tables   The table names to compile the query against.
     * @param columns  A list of which columns to return. Passing null will
     *                 return all columns, which is discouraged to prevent reading
     *                 data from storage that isn't going to be used.
     * @param where    A filter declaring which rows to return, formatted as an SQL
     *                 WHERE clause (excluding the WHERE itself). Passing null will
     *                 return all rows for the given URL.
     * @param groupBy  A filter declaring how to group rows, formatted as an SQL
     *                 GROUP BY clause (excluding the GROUP BY itself). Passing null
     *                 will cause the rows to not be grouped.
     * @param having   A filter declare which row groups to include in the cursor,
     *                 if row grouping is being used, formatted as an SQL HAVING
     *                 clause (excluding the HAVING itself). Passing null will cause
     *                 all row groups to be included, and is required when row
     *                 grouping is not being used.
     * @param orderBy  How to order the rows, formatted as an SQL ORDER BY clause
     *                 (excluding the ORDER BY itself). Passing null will use the
     *                 default sort order, which may be unordered.
     * @param limit    Limits the number of rows returned by the query,
     *                 formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return the SQL query string
     */
    private static String buildQueryString(
            boolean distinct, String tables, String[] columns, String where,
            String groupBy, String having, String orderBy, String limit) {
        if (isEmpty(groupBy) && !isEmpty(having)) {
            throw new IllegalArgumentException(
                    "HAVING clauses are only permitted when using a groupBy clause");
        }
        if (!isEmpty(limit) && !sLimitPattern.matcher(limit).matches()) {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + limit);
        }

        StringBuilder query = new StringBuilder(120);

        query.append("SELECT ");
        if (distinct) {
            query.append("DISTINCT ");
        }
        if (columns != null && columns.length != 0) {
            appendColumns(query, columns);
        } else {
            query.append(" * ");
        }
        query.append("FROM ");
        query.append(tables);
        appendClause(query, " WHERE ", where);
        appendClause(query, " GROUP BY ", groupBy);
        appendClause(query, " HAVING ", having);
        appendClause(query, " ORDER BY ", orderBy);
        appendClause(query, " LIMIT ", limit);
        return query.toString();
    }

    /**
     * Add the names that are non-null in columns to s, separating
     * them with commas.
     */
    private static void appendColumns(StringBuilder s, String[] columns) {
        int n = columns.length;

        for (int i = 0; i < n; i++) {
            String column = columns[i];

            if (column != null) {
                if (i > 0) {
                    s.append(", ");
                }
                s.append(column);
            }
        }
        s.append(' ');
    }

    /**
     * addClause
     *
     * @param s      the add StringBuilder
     * @param name   clauseName
     * @param clause clauseSelection
     */
    private static void appendClause(StringBuilder s, String name, String clause) {
        if (!isEmpty(clause)) {
            s.append(name);
            s.append(clause);
        }
    }

    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    private static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    /**
     * the pattern of limit
     */
    private static final Pattern sLimitPattern =
            Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    /**
     * After the execution of the complete SQL statement, not necessarily the actual implementation of the SQL statement
     *
     * @param sql      SQL statement
     * @param bindArgs Binding parameters
     * @return Replace? SQL statement executed after the
     */
    private static String getExecSQL(String sql, Object[] bindArgs) {
        StringBuilder sb = new StringBuilder(sql);
        if (bindArgs != null && bindArgs.length > 0) {
            int index = 0;
            for (int i = 0; i < bindArgs.length; i++) {
                index = sb.indexOf("?", index);
                sb.replace(index, index + 1, String.valueOf(bindArgs[i]));
            }
        }
        return sb.toString();
    }
}

package njust.utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import njust.dataclass.course;

public class DBCourseManagementTest {
	
	
	private static void testInsertSingleCourses(course testCourse){
		Map<String, Object> map = new HashMap<>();    
		//map.put("id",testCourse.getId());
		map.put("title", testCourse.getTitle());
		map.put("userid", testCourse.getUserid());
		map.put("name", testCourse.getName());
		map.put("newdate", testCourse.getNewdate());
		map.put("newtime", testCourse.getNewtime());
		map.put("id",testCourse.getId());
		try {
            int count = DBUtil.insert("course", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	

	public static void main(String[] args) {
		course testCourse = new course();
		testCourse.setId(2);
		testCourse.setTitle("C++Homework");
		testCourse.setUserid("919106840420");
		testCourse.setName("�۶�");
		testCourse.setNewdate("2021-05-02");
		testCourse.setNewtime("15:00:00");
    	// 1.���Ե�������
//    	testInsertSingleCourses(testCourse);
    	// 2.���Ը���
//    	testUpdateCourse();
    	// 3.����ɾ��
//    	testDeleteCourse();
    	// 4.������������
//    	testBatchInsert(10);

    }
	
}

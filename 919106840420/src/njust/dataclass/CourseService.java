package njust.dataclass;

public class CourseService {
	public int addCourseService(course testcourse){
		courseDAO serCourseDAO = new courseDAO();
		boolean addbool = serCourseDAO.addCourse(testcourse);
		if(addbool)
			return 200;
		else return 201;
	}
}

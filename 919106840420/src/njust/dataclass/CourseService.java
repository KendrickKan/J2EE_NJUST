package njust.dataclass;

public class CourseService {
	public int addCourseService(course testcourse){
		courseDAO serCourseDAO = new courseDAO();
		boolean addbool = serCourseDAO.addCourse(testcourse);
		if(addbool)
			return 200;
		else return 201;
	}
	public int delCourseService(int id)
	{
		courseDAO serCourseDAO = new courseDAO();
		course serCourse = serCourseDAO.getCourse(id);
		boolean delbool = serCourseDAO.deleteCourse(serCourse);
		if(delbool)
			return 200;
		else return 201;
	}
}

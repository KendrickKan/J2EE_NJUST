package njust.dataclass;

public class LoginService {
	public int finishLogin(Login login){
//		System.out.println(login.getPassword().toString());
		LoginDAO logdao = new LoginDAO();
		Login testLogin = logdao.getLogin(login.getUserid().toString());
//		System.out.println(testLogin.getPassword());
//		System.out.println(testLogin.getPassword().toString().equals(login.getPassword().toString()));
		if(testLogin == null)
			return 201;//没有这个id
		else if(testLogin.getPassword().toString().equals(login.getPassword().toString()))
		{
			return 200;//成功
		}
		else return 202;//密码错误
	}
//	public static void main(String[] args) {
//	LoginService logs = new LoginService();
//	Login loh = new Login();
//	loh.setUserid("919106840420");
//	loh.setPassword("123456");
//	System.out.println(logs.finishLogin(loh));
////	Login testLogin = new Login();
////	testLogin.setName("阚东");
////	testLogin.setUserid("919106840420");
////	testLogin.setPassword("123456");
////	testLogin.setAcademy("计算机科学与工程学院");
////	testLogin.setDepartment("计算机科学与技术");
////	System.out.println(testDao.addLogin(testLogin));
//}
}

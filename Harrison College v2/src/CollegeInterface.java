


import java.util.ArrayList;
import model.Huser;



public class CollegeInterface {

	CollegeDB db = new CollegeDB();
	public boolean isUserMatching(String userName, String pwd)
	{
		boolean isExist = false;
		
		Huser t = db.getProfile(userName, pwd);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	public boolean createNewAccount(String email, String password,String position,String FN,String major,String year){
		boolean isSuccess = false;
		
		//create new account
		if(db.createNewUser(email, password,position,FN,major,year)){
			isSuccess = true;
		}
		
		return isSuccess;
		
	}
	
	public ArrayList<Huser> pullUser(){
		ArrayList<Huser> UserList= new ArrayList<Huser>();
			CollegeDB WD = new CollegeDB();
			UserList= WD.getAllUsers();
			
			return UserList;
	}
	
	public ArrayList<Huser> pullStudent(String position){
		ArrayList<Huser> ProductsList= new ArrayList<Huser>();
			CollegeDB WD = new CollegeDB();
			ProductsList= WD.getStudent(position);
			
			return ProductsList;
	}
	
}

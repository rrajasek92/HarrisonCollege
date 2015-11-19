

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Huser;


/**
 * Servlet implementation class advisor
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		Huser hu = new Huser();
		
		ArrayList<Huser> UserList= new ArrayList<Huser>();
		
		
		CollegeInterface T = new CollegeInterface();
		
		String position="student";
		
		UserList= T.pullStudent();
		String tableinfo = "";
		
	
		 System.out.println("UserList.size()++"+UserList.size());
		
		for(int i=0;i<UserList.size();i++)
		{
			hu=UserList.get(i);
			long id1=hu.getUserId();
			tableinfo += "<tr><td>" + hu.getFullName()+"</td><td>" + hu.getPosition()+"</td><td>"+ hu.getEntryYear()+"</td><td>" + hu.getEmail()+"</td><td> <a href=\"Adminposition.jsp?id="+id1+"\">" + "ChangePosition"+"</td></tr>";
			
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/admin.jsp")
		.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

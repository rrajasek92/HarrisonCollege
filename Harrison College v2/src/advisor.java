

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Huser;


/**
 * Servlet implementation class advisor
 */
@WebServlet("/advisor")
public class advisor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advisor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		Huser hu = new Huser();
		HttpSession session = request.getSession();
		System.out.println("logged in as advisor");
		session.setAttribute("advisor_logged_in", true);
		ArrayList<Huser> ProductsList= new ArrayList<Huser>();
		
		
		CollegeInterface T = new CollegeInterface();
		
		String position="student";
		
		ProductsList= T.pullStudent(position);
		String tableinfo = "";
		 
		 
		
		for(int i=0;i<ProductsList.size();i++)
		{
			hu=ProductsList.get(i);
			long id1=hu.getUserId();
			tableinfo += "<tr><td>" + hu.getFullName()+"</td><td>" + hu.getMajor()+"</td><td>" + hu.getEntryYear()+"</td><td>" + hu.getEmail()+"</td><td> <a class=\"btn btn-danger btn-xs\" role=\"button\" href=\"advisorViewClasslist?studentid="+id1+"\">" + "Course Details"+"</td></tr>";
			
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/Advisor.jsp")
		.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

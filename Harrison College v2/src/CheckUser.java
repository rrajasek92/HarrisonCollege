

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Huser;




/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
			
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
		
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		Huser hu = new Huser();
		String email= request.getParameter("email");
		 String PWD= request.getParameter("Password");
		 PrintWriter out = response.getWriter();
		 CollegeInterface T = new CollegeInterface();
		 HttpSession session = request.getSession();
		 session.setAttribute("email", email);
		 System.out.println("Username======"+session.getAttribute("email"));
		 
		 
		 boolean ExistingUser= T.isUserMatching(email,PWD);
		 
		 
		 //start---- user id into session
		 
		 
			ArrayList<Huser> ProductsList= new ArrayList<Huser>();
			
			ProductsList= T.pullUser();

			if(ExistingUser)
			{
			for(int i=0;i<ProductsList.size();i++)
			{
				
				hu=ProductsList.get(i);
				
				//start regex
				String pattern ="(.*)(@admin.com)";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(email);
				
				
				//end regex
				
				if(email.equalsIgnoreCase(hu.getEmail()))
				{
				System.out.println("user id=="+hu.getUserId());
				long id=hu.getUserId();
				session.setAttribute("userid", id);
				String position= hu.getPosition();
					if(position.equalsIgnoreCase("advisor"))
					{
						out.println("<script type=\"text/javascript\">");
						  
						   out.println("location='advisor';");
						   out.println("</script>");
					}
					if(position.equalsIgnoreCase("instructor"))
					{
						out.println("<script type=\"text/javascript\">");
						  
						   out.println("location='instructor';");
						   out.println("</script>");
					}
					if(position.equalsIgnoreCase("student"))
					{
						out.println("<script type=\"text/javascript\">");
						  
						   out.println("location='studentClasslistServlet';");
						   out.println("</script>");
					
					}
					if(position.equalsIgnoreCase("admin") || m.find())
					{
						
						out.println("<script type=\"text/javascript\">");
						  
						   out.println("location='student';");
						   out.println("</script>");
					
					}
				
				
				
				}
				
				
				//tableinfo += "<tr><td>" + pd.getProductid()+"</td><td>" + pd.getProductname()+"</td><td>" + pd.getPrice()+"</td><td> <a href=\"ProductDetail?id="+id1+"\">" + "ClickForDetails"+"</td></tr>";
				
				
			}	
			}
			
			
			
		 
		 //end-- user id into session
		 
		 //ExistingUser=T.isUserExist(UN);
		 /*if(UN.equalsIgnoreCase("admin"))
		 {
			 out.println("<script type=\"text/javascript\">");
			  
			   out.println("location='Admin';");
			   out.println("</script>");
			 
		 }*/
		/* 
		 if(ExistingUser)
		 {
			 
			 
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Logging in');");
			   out.println("location='studentClasslistServlet';");
			   out.println("</script>");
		 
		 }*/
		
		 else
		 {
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Enter values again');");
			   out.println("location='Login.html';");
			   out.println("</script>");
			 
		 }
	}

}

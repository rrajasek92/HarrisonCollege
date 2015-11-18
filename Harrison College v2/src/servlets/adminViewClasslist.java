package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClassEnrollment;

/**
 * Servlet implementation class adminViewClasslist
 */
@WebServlet("/adminViewClasslist")
public class adminViewClasslist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminViewClasslist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listDB(request,response);
	}
	public void listDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long userid=(long) session.getAttribute("userid");
		System.out.println(userid);
		List<ClassEnrollment> cEnroll= new ArrayList<ClassEnrollment>();
		cEnroll = getClassEnrollment(userid);
		String tableinfo="";
		for(int i=0;i<cEnroll.size();i++){
			tableinfo += "<tr><td>" + cEnroll.get(i).getHuser().getUserId()+"</td><td>" + cEnroll.get(i).getHclass().getCrn()+"</td><td>" + cEnroll.get(i).getHclass().getCours().getCourseId()+"</td><td>" + cEnroll.get(i).getHclass().getCours().getCourseName()+"</td><td>" + cEnroll.get(i).getHclass().getCours().getSemester()+"</td><td>" + cEnroll.get(i).getHclass().getClassroom().getMaxCapacity()+"</td><td><a href=\"http://localhost:8080/Harrison_College_v2/dropCourse?crn="+cEnroll.get(i).getHclass().getCrn()+"&eid="+cEnroll.get(i).getEnrollmentId()+"&uid="+cEnroll.get(i).getHuser().getUserId()+"\">Drop</a></td></tr>";

		}
		request.setAttribute("tableinfo", tableinfo);
		
	     getServletContext()
	     	.getRequestDispatcher("/StudentClasses.jsp")
	     		.forward(request, response);
		
		
	}
	
	public static List<ClassEnrollment> getClassEnrollment(long userid){
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
	       String q="SELECT c FROM ClassEnrollment c where c.huser.userId=:userid";
		TypedQuery<ClassEnrollment> qT = em.createQuery(q, ClassEnrollment.class);
		qT.setParameter("userid", userid);
		List<ClassEnrollment> cEnroll;
		try{
			cEnroll=qT.getResultList();
			if (cEnroll==null||cEnroll.isEmpty())
				cEnroll=null;
		} finally {
			
		em.close();	
		}
		return cEnroll;
	}

}
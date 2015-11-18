package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClassEnrollment;
import model.Hclass;
import model.Huser;
import customTools.DBUtil;

/**
 * Servlet implementation class adminDropCourse
 */
@WebServlet("/adminDropCourse")
public class adminDropCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDropCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dropDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	public void dropDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int crn= Integer.parseInt(request.getParameter("crn"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		
	
	
		ClassEnrollment cEnroll = new ClassEnrollment();
		HttpSession session= request.getSession();
		//String student= (String) session.getAttribute("userid");
		String student=request.getParameter("uid");
		Huser hstudent=new Huser();
		Hclass hclass= new Hclass();
		hstudent.setUserId(Integer.parseInt(student));
		hclass.setCrn(crn);
		cEnroll.setEnrollmentId(eid);
		cEnroll.setHuser(hstudent);
		cEnroll.setHclass(hclass);
		delete(cEnroll);
		getServletContext()
     	.getRequestDispatcher("/studentClasslistServlet")
     		.forward(request, response);
	}
	
	public static void delete(ClassEnrollment cEnroll) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(cEnroll));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}


		
}
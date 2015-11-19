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
 * Servlet implementation class advisorAddCourse
 */
@WebServlet("/advisorAddCourse")
public class advisorAddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advisorAddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	public void addDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int crn= Integer.parseInt(request.getParameter("crn"));
		
	
	
		ClassEnrollment cEnroll = new ClassEnrollment();
		HttpSession session= request.getSession();
		long student= Long.parseLong((String)session.getAttribute("a_student_id"));
		System.out.println(student);
		Huser hstudent=new Huser();
		Hclass hclass= new Hclass();
		hstudent.setUserId((int) student);
		hclass.setCrn(crn);
		cEnroll.setHuser(hstudent);
		cEnroll.setHclass(hclass);
		insert(cEnroll);
		getServletContext()
     	.getRequestDispatcher("/advisorViewClasslist?studentid="+student)
     		.forward(request, response);
	}
	
	public static void insert(ClassEnrollment cEnroll) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(cEnroll);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

}
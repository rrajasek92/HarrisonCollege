

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

import model.Cours;
import model.Department;
import model.Hclass;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_Course
 */
@WebServlet("/adm_Course")
public class adm_Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_Course() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cours> courses = new ArrayList<Cours>();
		courses = getCourses();
		request.setAttribute("Courses", courses);
		List<Department> dept = new ArrayList<Department>();
		dept = getDepartments();
		HttpSession depsession = request.getSession();
		depsession.setAttribute("departments", dept);
		
		getServletContext().getRequestDispatcher("/adm_Course.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public static List<Cours> getCourses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT c FROM Cours c";
		TypedQuery<Cours> q = em.createQuery(qString, Cours.class);
		List<Cours> hclasses = null;
		try {
			hclasses = q.getResultList();
			if (hclasses == null || hclasses.isEmpty())
				hclasses = null;
		} finally {
			em.close();
		}
		return hclasses;
	}
	
	public static List<Department> getDepartments(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d FROM Department d";
		TypedQuery<Department> q = em.createQuery(qString, Department.class);
		List<Department> hclasses = null;
		try {
			hclasses = q.getResultList();
			if (hclasses == null || hclasses.isEmpty())
				hclasses = null;
		} finally {
			em.close();
		}
		return hclasses;
	}
	

}

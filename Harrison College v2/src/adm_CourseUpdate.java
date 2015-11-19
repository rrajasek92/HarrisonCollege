

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.Cours;
import model.Department;

/**
 * Servlet implementation class adm_CourseUpdate
 */
@WebServlet("/adm_CourseUpdate")
public class adm_CourseUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_CourseUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname = request.getParameter("coursename");
		String subj = request.getParameter("subjectcode");
		String desc = request.getParameter("description");
		String cre = request.getParameter("credits");
		int credit = Integer.parseInt(cre);
		String semester = request.getParameter("semester");
		String did = request.getParameter("departmentid");
		int depid = Integer.parseInt(did);
		HttpSession courssession = request.getSession();
		Cours c = (Cours) courssession.getAttribute("course");
		c.setCourseName(cname);
		c.setCredits((credit));
		c.setDepartment(getDepartment(depid));
		c.setDescription(desc);
		c.setSemester(semester);
		c.setSubjectCode(subj);
		
		UpdateCourse(c);
		getServletContext().getRequestDispatcher("/adm_Course").forward(
				request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	public static Department getDepartment(int depid)
	{
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Department> query = (TypedQuery) em.createQuery("select d from Department d where d.departmentId = :depid",
				Department.class);
		query.setParameter("depid", depid);
		Department myDepartment = query.getSingleResult();
		em.close();
		return myDepartment;
	}
	
	public static void UpdateCourse(Cours cours){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(cours);
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}


}

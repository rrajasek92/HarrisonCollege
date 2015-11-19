

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cours;
import model.Department;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_DepartmentPreUpdate
 */
@WebServlet("/adm_DepartmentPreUpdate")
public class adm_DepartmentPreUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DepartmentPreUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String didd = request.getParameter("did");
		int did = Integer.parseInt(didd);
		Department d = new Department();
		d = getDepartment(did);
		HttpSession depsession = request.getSession();
		depsession.setAttribute("department", d);
		getServletContext().getRequestDispatcher("/adm_DepartmentUpdate.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	public static Department getDepartment(int did){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "SELECT d Department FROM Department d WHERE d.departmentId = :did";
		TypedQuery<Department> qt = em.createQuery(q, Department.class);
		qt.setParameter("did", did);
		Department cours = null;
		try {
			cours=qt.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
			return cours;
	}

}



import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Department;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_DepartmentRemove
 */
@WebServlet("/adm_DepartmentRemove")
public class adm_DepartmentRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DepartmentRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Department dept = new Department();
		String rnr = request.getParameter("did");
		int did = Integer.parseInt(rnr);
		dept = getDepartment(did);
		removeDepartment(dept);
		getServletContext().getRequestDispatcher("/adm_Department").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public static Department getDepartment(int did) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d FROM Department d WHERE d.departmentId = :did";
		TypedQuery<Department> q = em.createQuery(qString, Department.class);
		q.setParameter("did", did);
		
		Department dept = null;
		try {
			dept = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return dept;
	}
	public static void removeDepartment(Department dept){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try{
			em.remove(em.merge(dept));
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}

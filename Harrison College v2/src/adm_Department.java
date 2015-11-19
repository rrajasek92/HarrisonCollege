

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

import model.Classroom;
import model.Department;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_Department
 */
@WebServlet("/adm_Department")
public class adm_Department extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_Department() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Department> departments = new ArrayList<Department>();
		departments = getDepartments();
		request.setAttribute("Departments", departments);
		getServletContext().getRequestDispatcher("/adm_Department.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
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

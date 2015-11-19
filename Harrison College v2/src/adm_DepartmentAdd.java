

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Classroom;
import model.ClassroomPK;
import model.Department;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_DepartmentAdd
 */
@WebServlet("/adm_DepartmentAdd")
public class adm_DepartmentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_DepartmentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dname = request.getParameter("departmentname");
		
		
		Department d = new Department();
		d.setDepartmentName(dname);
		addDepartment(d);
		getServletContext().getRequestDispatcher("/adm_Department").forward(
				request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	public static void addDepartment(Department cours){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(cours);
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}

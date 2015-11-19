
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

import customTools.DBUtil;
import model.ClassEnrollment;

/**
 * Servlet implementation class afterHome
 */
@WebServlet("/afterHome")
public class afterHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public afterHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ClassEnrollment> cEnroll = new ArrayList<ClassEnrollment>();
		String crn = request.getParameter("crn");
		int intcrn = Integer.parseInt(crn);
		
		HttpSession session = request.getSession();
		cEnroll = getStudents(intcrn);
		session.setAttribute("StudentList", cEnroll);
		session.setAttribute("crn", crn);

		getServletContext().getRequestDispatcher("/ins_classRoster").forward(
				request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static List<ClassEnrollment> getStudents(int crn) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT c FROM ClassEnrollment c WHERE c.hclass.crn = :crn";
		TypedQuery<ClassEnrollment> q = em.createQuery(qString,
				ClassEnrollment.class);
		q.setParameter("crn", crn);
		List<ClassEnrollment> cenroll = null;
		try {
			cenroll = q.getResultList();
			if (cenroll == null || cenroll.isEmpty())
				cenroll = null;
		} finally {
			em.close();
		}
		return cenroll;
	}

}

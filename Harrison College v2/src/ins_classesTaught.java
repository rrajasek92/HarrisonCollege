

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
import model.Hclass;

/**
 * Servlet implementation class ins_classesTaught
 */
@WebServlet("/ins_classesTaught")
public class ins_classesTaught extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ins_classesTaught() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		long userid = Long.parseLong((String)session.getAttribute("userid"));
		long userid = (long) session.getAttribute("userid");
		
		List<Hclass> classList = new ArrayList<Hclass>();
		//TESTING 001
		
		
		
		classList = getClasses(userid, "F15");
		
		request.setAttribute("ClassList", classList);
		ArrayList<Integer> assigned = new ArrayList<Integer>();
		
		session.setAttribute("assigned", assigned);
		
		
		getServletContext().getRequestDispatcher("/ins_Home.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static List<Hclass> getClasses(long instructorId, String semester) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM Hclass h WHERE h.instructorId = :instructorId AND h.semester = :semester";
		TypedQuery<Hclass> q = em.createQuery(qString, Hclass.class);
		q.setParameter("instructorId", Long.toString(instructorId));
		q.setParameter("semester", semester);
		List<Hclass> hclasses = null;
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

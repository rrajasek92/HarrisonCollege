

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

import model.Hclass;
import customTools.DBUtil;

/**
 * Servlet implementation class ins_preHome
 */
@WebServlet("/ins_preHome")
public class ins_preHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ins_preHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		long userid = (long) session.getAttribute("userid");
		String semester = request.getParameter("semester");
		
		List<Hclass> preSem = new ArrayList<Hclass>();
		preSem = getClasses(userid,semester);
		request.setAttribute("preClassList", preSem);
		getServletContext().getRequestDispatcher("/ins_preHome.jsp").forward(
				request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
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



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

import customTools.DBUtil;
import model.Cours;
import model.Department;

/**
 * Servlet implementation class adm_CoursePreUpdate
 */
@WebServlet("/adm_CoursePreUpdate")
public class adm_CoursePreUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_CoursePreUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cidd = request.getParameter("cid");
		int cid = Integer.parseInt(cidd);
		Cours c = new Cours();
		c = getCourse(cid);
		HttpSession courssession = request.getSession();
		courssession.setAttribute("course", c);
		getServletContext().getRequestDispatcher("/adm_CourseUpdate.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	public static Cours getCourse(int cid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "SELECT c Cours FROM Cours c WHERE c.courseId = :cid";
		TypedQuery<Cours> qt = em.createQuery(q, Cours.class);
		qt.setParameter("cid", cid);
		Cours cours = null;
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

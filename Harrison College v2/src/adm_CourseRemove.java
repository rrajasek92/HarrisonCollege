

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cours;

import customTools.DBUtil;

/**
 * Servlet implementation class adm_CourseRemove
 */
@WebServlet("/adm_CourseRemove")
public class adm_CourseRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_CourseRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cours course = new Cours();
		String ci = request.getParameter("cid");
		int cid = Integer.parseInt(ci);
		course = getCourse(cid);
		removeCourse(course);
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
	
	public static Cours getCourse(int courseId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT c FROM Cours c WHERE c.courseId = :courseId";
		TypedQuery<Cours> q = em.createQuery(qString, Cours.class);
		q.setParameter("courseId", courseId);
		Cours cours = null;
		try {
			cours = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return cours;
	}
	public static void removeCourse(Cours cours){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try{
			em.remove(em.merge(cours));
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}

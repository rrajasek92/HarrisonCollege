

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

import model.Classroom;

import customTools.DBUtil;

/**
 * Servlet implementation class adm_ClassroomRemove
 */
@WebServlet("/adm_ClassroomRemove")
public class adm_ClassroomRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_ClassroomRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Classroom croom = new Classroom();
		String bn = request.getParameter("bn");
		String rnr = request.getParameter("rn");
		int rn = Integer.parseInt(rnr);
		croom = getClassroom(bn,rn);
		removeClassroom(croom);
		getServletContext().getRequestDispatcher("/adm_Classroom").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public static Classroom getClassroom(String bn, int rn) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT c FROM Classroom c WHERE c.id.buildingName = :bn AND c.id.roomNumber = :rn";
		TypedQuery<Classroom> q = em.createQuery(qString, Classroom.class);
		q.setParameter("bn", bn);
		q.setParameter("rn", rn);
		Classroom classroom = null;
		try {
			classroom = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return classroom;
	}
	public static void removeClassroom(Classroom classroom){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try{
			em.remove(em.merge(classroom));
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}

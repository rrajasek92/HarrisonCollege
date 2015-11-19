

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

import model.Classroom;
import model.ClassroomPK;
import model.Cours;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_ClassroomPreUpdate
 */
@WebServlet("/adm_ClassroomPreUpdate")
public class adm_ClassroomPreUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_ClassroomPreUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bn = request.getParameter("bn");
		String rna = request.getParameter("rn");
		int rn = Integer.parseInt(rna);
		
		Classroom c = new Classroom();
		ClassroomPK pk = new ClassroomPK();
		c = getClassroom(bn, rn);
		HttpSession classsession = request.getSession();
		classsession.setAttribute("classroompk", pk);
		classsession.setAttribute("classroom", c);
		getServletContext().getRequestDispatcher("/adm_ClassroomUpdate.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public static Classroom getClassroom(String bn, int rn){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String q = "SELECT c Classroom FROM Classroom c WHERE c.id.buildingName = :bn AND c.id.roomNumber = :rn";
		TypedQuery<Classroom> qt = em.createQuery(q, Classroom.class);
		qt.setParameter("bn", bn);
		qt.setParameter("rn", rn);
		Classroom cours = null;
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

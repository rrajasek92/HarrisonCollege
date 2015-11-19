

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

import model.Grade;
import model.Hclass;
import customTools.DBUtil;

/**
 * Servlet implementation class ins_preClassRoster
 */
@WebServlet("/ins_preClassRoster")
public class ins_preClassRoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ins_preClassRoster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Grade> g = new ArrayList<Grade>();
		String crna =  request.getParameter("Crn");
		int precrn = Integer.parseInt(crna);
		g = getPreviousGrades(precrn);
		request.setAttribute("PreStudentList", g);
		
		getServletContext().getRequestDispatcher("/ins_preRoster.jsp").forward(
				request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

	
	public static List<Grade> getPreviousGrades(int crn){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT g FROM Grade g WHERE g.crn = :crn";
		TypedQuery<Grade> qs = em.createQuery(qString, Grade.class);
		qs.setParameter("crn", crn);
		List<Grade> pregrade = null;
		try {
			pregrade = qs.getResultList();
			if (pregrade == null || pregrade.isEmpty())
				pregrade = null;
		} finally {
			em.close();
		}
		return pregrade;
	}
}

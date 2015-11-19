

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Grade;
import customTools.DBUtil;

/**
 * Servlet implementation class ins_assignGrade
 */
@WebServlet("/ins_assignGrade")
public class ins_assignGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ins_assignGrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Grade g  = new Grade();
		String sid = request.getParameter("studentid");
		int id = Integer.parseInt(sid);
		String grade = request.getParameter("grade");
		HttpSession session = request.getSession();
		String crn = (String) session.getAttribute("crn");
		int intcrn = Integer.parseInt(crn);
		
		g.setCrn(new BigDecimal(intcrn));
		g.setLetterGrade(grade);
		g.setStudentId(new BigDecimal(id));
		insert(g);
		ArrayList<Integer> assigned = (ArrayList<Integer>) session.getAttribute("assigned");
		assigned.add(id);
		session.setAttribute("assigned", assigned);
		
		getServletContext().getRequestDispatcher("/ins_classRoster").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	public static void insert(Grade grade){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try{
			em.persist(grade);
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
	}
}



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

import model.Classroom;
import model.Cours;
import customTools.DBUtil;

/**
 * Servlet implementation class adm_Classroom
 */
@WebServlet("/adm_Classroom")
public class adm_Classroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_Classroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Classroom> classrooms = new ArrayList<Classroom>();
		classrooms = getClassrooms();
		request.setAttribute("Classrooms", classrooms);
		getServletContext().getRequestDispatcher("/adm_Classroom.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	public static List<Classroom> getClassrooms(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT c FROM Classroom c";
		TypedQuery<Classroom> q = em.createQuery(qString, Classroom.class);
		List<Classroom> hclasses = null;
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

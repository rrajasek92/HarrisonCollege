

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.Classroom;
import model.ClassroomPK;
import model.Cours;

/**
 * Servlet implementation class adm_ClassroomUpdate
 */
@WebServlet("/adm_ClassroomUpdate")
public class adm_ClassroomUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_ClassroomUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bn = request.getParameter("buildingname");
		String rna = request.getParameter("roomnumber");
		int rn = Integer.parseInt(rna);
		String maxc = request.getParameter("maxcapacity");
		int max = Integer.parseInt(maxc);
		HttpSession classsession = request.getSession();
		Classroom c = (Classroom) classsession.getAttribute("classroom");
		ClassroomPK pk = (ClassroomPK) classsession.getAttribute("classroompk");
		pk.setBuildingName(bn);
		pk.setRoomNumber(rn);
		c.setId(pk);
		c.setMaxCapacity(new BigDecimal(max));
		UpdateClassroom(c);
		getServletContext().getRequestDispatcher("/adm_Classroom").forward(
				request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	public static void UpdateClassroom(Classroom cours){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(cours);
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}


}

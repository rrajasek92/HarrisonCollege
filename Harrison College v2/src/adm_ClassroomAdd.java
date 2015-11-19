

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;
import model.Classroom;
import model.ClassroomPK;
import model.Cours;

/**
 * Servlet implementation class adm_ClassroomAdd
 */
@WebServlet("/adm_ClassroomAdd")
public class adm_ClassroomAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adm_ClassroomAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rna = request.getParameter("roomnumber");
		int rn = Integer.parseInt(rna);
		String bn = request.getParameter("buildingname");
		String maxc = request.getParameter("maxcapacity");
		int max = Integer.parseInt(maxc);
		Classroom cr = new Classroom();
		ClassroomPK pk = new ClassroomPK();
		pk.setBuildingName(bn);
		pk.setRoomNumber(rn);
		cr.setId(pk);
		cr.setMaxCapacity(new BigDecimal(max));
		addClassroom(cr);
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
	
	public static void addClassroom(Classroom cours){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(cours);
			trans.commit();
		} catch (Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}

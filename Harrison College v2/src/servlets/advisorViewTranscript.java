package servlets;

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

import model.Grade;
import model.Hclass;

/**
 * Servlet implementation class advisorViewTranscript
 */
@WebServlet("/advisorViewTranscript")
public class advisorViewTranscript extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advisorViewTranscript() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listDB(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void listDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = customTools.DBUtil.getEmFactory().createEntityManager();
		long stid=Long.parseLong(request.getParameter("studentid"));
		//long stid= (long) request.getSession().getAttribute("studentid");
	       String q="SELECT g FROM Grade g where g.studentId= :stid";
//	       String q="SELECT g FROM Grade g";

	       String q2="SELECT h FROM Hclass h where h.crn=:crn";
		TypedQuery<Grade> qT = em.createQuery(q, Grade.class);
//		List<Grade> cGrade = qT.getResultList();
	//	List<Grade> sGrade=0;
		List<Grade> cGrade=qT.setParameter("stid", stid).getResultList();
		TypedQuery<Hclass> qT2 = em.createQuery(q2, Hclass.class);
		Hclass hclass= null;
		List<Integer> credits=new ArrayList<Integer>();
		List<String> gpList=new ArrayList<String>();
//		List<Hclass> hclass= qT2.getResultList();
		for(int i=0;i<cGrade.size();i++){
			hclass= qT2.setParameter("crn", cGrade.get(i).getCrn()).getSingleResult();
			credits.add(hclass.getCours().getCredits());
			gpList.add(cGrade.get(i).getLetterGrade());
		}
		double gpa=gpa(gpList,credits);
		
		String tableinfo="";
		
			tableinfo += "<tr><td>" + stid+"</td><td>" + gpa+"</td></tr>";

		
		request.setAttribute("tableinfo", tableinfo);
		request.setAttribute("studentid", stid);
		
	     getServletContext()
	     	.getRequestDispatcher("/advisorTranscript.jsp")
	     		.forward(request, response);
		
		
	}
	
	public double gpConvert(String g){
		switch (g){
		case "A": return 4;
		case "B": return 3;
		case "C": return 2;
		case "D": return 1;
		case "F": return 0;
		default: return 0;
		}
	}
	public double gpa(List<String> gp, List<Integer> credits){
		double gpi=0;
		int cdi=0;
		for (int i=0;i<gp.size();i++){
			
			gpi+=(gpConvert(gp.get(i))*credits.get(i));
			cdi+=credits.get(i);
		}
		
		double gpa=gpi/cdi;
		
		return gpa;
	}
}



import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.*;
import model.*;

/**
 * Servlet implementation class CatalogBrowsing
 */
@WebServlet("/CatalogBrowsing")
public class CatalogBrowsing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogBrowsing() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchType = request.getParameter("search_type");
		//		String searchType = "ac_by_department";
		System.out.println(searchType);
		switch(searchType)
		{
		case "ac_cs":
			processAcCs(request, response);
			break;
		case "ac_by_instructor_cs":
			processAcByInstructorCs(request, response);
			break;
		case "ac_by_department":
			processAcByDepartment(request, response);
			break;
		case "ac_by_department_cs":
			processAcByDepartmentCs(request, response);
			break;
		case "majors_by_department":
			processMajorsByDepartment(request, response);
			break;
		}
	}

	private void processAcCs(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String jpql = "select hc from Hclass hc where hc.semester = :currentSemester";
		List<Hclass> classesList = DBUtil.getEmFactory().createEntityManager().createQuery(jpql, Hclass.class).setParameter("currentSemester", "F15").getResultList();
		System.out.println("classesList size: " + classesList.size());
		request.setAttribute("classes_list", classesList);
		try {
			getServletContext().getRequestDispatcher("/s_courses.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processMajorsByDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<String> majorsList = new ArrayList<String>();
		Department myDepartment = new Department();
		String departmentName = request.getParameter("department_name").toLowerCase();
		String jpql1 = "select hu from Huser hu where hu.departmentId = :departmentId";
		String jpql2 = "select d from Department d where d.departmentName = :departmentName";
		try
		{
			myDepartment = DBUtil.getEmFactory().createEntityManager().createQuery(jpql2, Department.class).setParameter("departmentName", departmentName).getSingleResult();
		}
		catch(NoResultException e)
		{
			request.setAttribute("no_results", true);
			try 
			{
				getServletContext().getRequestDispatcher("/majors_list.jsp").forward(request, response);
			} 
			catch (ServletException | IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		List<Huser> usersList = DBUtil.getEmFactory().createEntityManager().createQuery(jpql1, Huser.class).setParameter("departmentId", myDepartment.getDepartmentId()).getResultList();
		for(Huser user:usersList)
		{
			if(!majorsList.contains(user.getMajor()))
			{
				majorsList.add(user.getMajor());
			}
			
		}
		request.setAttribute("department_name", departmentName);
		request.setAttribute("majors_list", majorsList);
		try 
		{
			getServletContext().getRequestDispatcher("/majors_list.jsp").forward(request, response);
		} 
		catch (ServletException | IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//		String jpql2 = "select d from Department d where d.departmentId = :departmentId";
		//		List<Huser> usersList = customTools.DBUtil.getEmFactory().createEntityManager().createQuery(jpql1, Huser.class).setParameter("currentSemester", "F15").getResultList();
		//		List<BigDecimal> departmentIdList = new ArrayList<BigDecimal>();
		//		List<Department> departmentsList = new ArrayList<Department>();
		//		for(Huser user:usersList)
		//		{
		//			if(!departmentIdList.contains(user.getDepartmentId()))
		//				departmentIdList.add(user.getDepartmentId());
		//		}
		//		for(BigDecimal id:departmentIdList)
		//		{
		//			departmentsList.add(customTools.DBUtil.getEmFactory().createEntityManager().createQuery(jpql2, Department.class).setParameter("departmentId", id).getSingleResult());
		//		}
		//		request.setAttribute("departments_list", departmentsList);
		//		try 
		//		{
		//			getServletContext().getRequestDispatcher("/.jsp").forward(request, response);
		//		} catch (ServletException | IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}

	private void processAcByDepartmentCs(
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String departmentName = request.getParameter("department_name").toLowerCase();
		String jpql = "select hc from Hclass hc where hc.cours.department.departmentName = :departmentName and hc.semester = :currentSemester";
		TypedQuery<Hclass> query = customTools.DBUtil.getEmFactory().createEntityManager().createQuery(jpql, Hclass.class);
		query.setParameter("departmentName", departmentName);
		query.setParameter("semester", "F15");
		List<Hclass> classesList = query.getResultList();
		System.out.println("classesList size: " + classesList.size());
		request.setAttribute("classes_list", classesList);
		try 
		{
			getServletContext().getRequestDispatcher("/s_courses.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processAcByDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String departmentName = request.getParameter("department_name").toLowerCase();
		String jpql = "select hc from Hclass hc where hc.cours.department.departmentName = :departmentName";
		List<Hclass> classesList = customTools.DBUtil.getEmFactory().createEntityManager().createQuery(jpql, Hclass.class).setParameter("departmentName", departmentName).getResultList();
		System.out.println("classesList size: " + classesList.size());
		request.setAttribute("classes_list", classesList);
		try {
			getServletContext().getRequestDispatcher("/s_courses.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processAcByInstructorCs(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String jpql = "select hc from Hclass hc where hc.semester = :currentSemester and hc.instructorId = :instructorId";
		Huser instructor;
		String instructorName = request.getParameter("instructor_name");
		try
		{
			instructor = customTools.DBUtil.getEmFactory().createEntityManager().createQuery("select hu from Huser hu where "
					+ "hu.fullName = :instructorName", Huser.class).setParameter("instructorName", instructorName).getSingleResult();
			System.out.println("instructor: " + instructor.getFullName());
		}
		catch(NoResultException e)
		{
			// Catch the no result exception and set the user ID to something that'd never be set in practice. 
			// This way the error page won't be loaded.
			instructor = new Huser();
			instructor.setUserId(-1);
		}
		TypedQuery<Hclass> query = customTools.DBUtil.getEmFactory().createEntityManager().createQuery(jpql, Hclass.class);
		query.setParameter("currentSemester", "F15");
		System.out.println("intructor ID: "+ instructor.getUserId());
		query.setParameter("instructorId", Long.toString(instructor.getUserId()));
		List<Hclass> classesList = query.getResultList();
		System.out.println("classesList size: " + classesList.size());
		request.setAttribute("classes_list", classesList);
		try {
			getServletContext().getRequestDispatcher("/s_courses.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

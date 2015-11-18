

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import model.Huser;
import customTools.DBUtil;

public class CollegeDB {

	public Huser getProfile(String email, String pwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Huser usr = null;
		
		try {
			String sql = "select u from Huser u where u.email = :email and u.password = :pwd";
			TypedQuery<Huser> q = em.createQuery(sql, Huser.class);
			q.setParameter("email", email);
			q.setParameter("pwd", pwd);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	public ArrayList<Huser> getStudent(String position){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Huser> fd = null;
		
		try {
			String sql = "select u from Huser u where u.position = :position";
			TypedQuery<Huser> results = em.createQuery(sql, Huser.class);
			results.setParameter("position", position);
			
			
			fd = results.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Huser>(fd);
	}
	
	
	public boolean createNewUser(String email, String pwd,String position,String FN,String major,String year){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Huser user = new Huser();
		user.setPassword(pwd);
		user.setEmail(email);
		user.setPosition(position);
		user.setFullName(FN);
		user.setMajor(major);
		user.setEntryYear(year);
		
		trans.begin();
		
		try{
			em.persist(user);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}
	
	public ArrayList<Huser> getAllUsers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Huser> fd = null;
		
		try {
			String sql = "SELECT p from Huser p";
			TypedQuery<Huser> results = em.createQuery(sql, Huser.class);
			
			fd = results.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Huser>(fd);
	}
	
}

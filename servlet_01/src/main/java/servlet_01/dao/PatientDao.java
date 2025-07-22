package servlet_01.dao;

import java.beans.PersistenceDelegate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlet_01.dto.PatientDto;

public class PatientDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//------------------insert---------------------
	public String insert(PatientDto dto) {
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
		return "data inserted";
	}
//	----------------fetch-------------
	public Object findById(int id) {
		PatientDto pdto=entityManager.find(PatientDto.class,id);
		if(pdto==null) {
		return "no data found";
		}
		else
			return pdto;
	}
//	--------------fetchall------------
	public List<PatientDto> fetchAll() {
		   //select a from table_name a--->Jpql
		   Query q=entityManager.createQuery("Select a from PatientDto a");
		   List<PatientDto> list=q.getResultList();
		   if(list.isEmpty()) {
			   return null;
		   }else
			   return list;
	   }
//	--------------deletebyid-----------
	public String deleteById(int cid) {
		PatientDto pdto=entityManager.find(PatientDto.class,cid);
		   if(pdto!=null) {
			   entityTransaction.begin();
			   entityManager.remove(pdto);
			   entityTransaction.commit();
			   return "data deleted successfully";
		   }else
			   return "No data available";
	}
//	----------------deleteall-----------
	public String deleteAll() {
		Query q=entityManager.createQuery("Select a from PatientDto a");
		List<PatientDto> list=q.getResultList();
		if(list.isEmpty()) {
			return "no data found";
		}else {
			for(PatientDto p:list) {
				entityTransaction.begin();
				entityManager.remove(p);
				entityTransaction.commit();
			}
			return "data deleted successfully";
		}
	}
	
	
}

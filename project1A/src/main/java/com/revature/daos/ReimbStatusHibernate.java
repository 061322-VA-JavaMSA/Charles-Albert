package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.ReimbStatus;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbStatusHibernate implements ReimburseStatusDAO {

	@Override
	public ReimbStatus getStatusById(int id) {
		ReimbStatus rs = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession();){
			 
			 rs= s.get(ReimbStatus.class, id);
			 
			 
		 }
		return rs;
		
	}

	@Override
	public ReimbStatus getStatusByState(String state) {
		ReimbStatus rs = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ReimbStatus> cq = cb.createQuery(ReimbStatus.class);
			Root<ReimbStatus> root = cq.from(ReimbStatus.class);
			
			Predicate status = cb.equal(root.get("status"), state);
			cq.select(root).where(status);
			
			rs = (ReimbStatus) s.createQuery(cq).getSingleResult();
		}
		
		
		
		
		
		return rs;
	}

}

package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.models.Reimbursement;

public class ReimbursementService {

private ReimbursementDAO rd = new ReimbursementHibernate();
	
	public List<Reimbursement> getReimbursements() {
		return rd.getReimbursements();
	}
	
	public List<Reimbursement> getReimbursementsByAuthorId(int id) {
		return rd.getReimbursementsByAuthorId(id);
	}

	public Reimbursement createreimbursement ( Reimbursement reques) {
		Reimbursement n = rd.insertReimbursement(reques);
		return reques;
		
	}

}
package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbStatus;
import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement insertReimbursement(Reimbursement r);
	
	List<Reimbursement> getReimbursements();
	
	List<Reimbursement> getReimbursementsByAuthorId(int id);
	
	List<Reimbursement> getReimbursementsByResolverId(int id);
	
	Reimbursement updateReimbursement(Reimbursement r);
	
	List<Reimbursement> getReimbursementsByStatus(ReimbStatus rs);

}

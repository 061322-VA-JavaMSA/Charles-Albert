package com.revature.services;

import com.revature.daos.ReimbStatusHibernate;
import com.revature.daos.ReimburseStatusDAO;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.ReimbStatus;

public class ReimbStatusService {
	
private ReimburseStatusDAO rsd = new ReimbStatusHibernate();
	
	public ReimbStatus getStatus (String state) throws  ItemNotFoundException {
		
		ReimbStatus rs = rsd.getStatusByState(state);
		
		if (rsd== null) {
			throw new ItemNotFoundException();
		}
		
		return rs;
		
	}
	public ReimbStatus getStatusById(int id ) throws ItemNotFoundException {
		ReimbStatus rs = rsd.getStatusById(id);
		
		if (rs == null) {
			throw new ItemNotFoundException();
			
		}
		return rs;
		
	}

}

package com.revature.daos;

import com.revature.models.ReimbStatus;

public interface ReimburseStatusDAO {

	ReimbStatus getStatusById(int id);
	ReimbStatus getStatusByState (String state);
}

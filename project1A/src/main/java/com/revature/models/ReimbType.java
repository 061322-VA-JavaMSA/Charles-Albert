package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Reimbursement_type")
public class ReimbType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="type")
	private String type;

	public ReimbType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbType(int i) {
		id = i;
		switch (i) {
		case 1 :
			type = "lodging";
			break;
		case 2 :
			type = "travel";
			break;
		case 3 :
			type = "food";
			break;
		case 4 :
			type ="other";
			break;
			default :
				type ="";
				
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbType other = (ReimbType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ReimbType [id=" + id + ", type=" + type + "]";
	}
	
	
	
	
	

}

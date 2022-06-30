package com.revature.models;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
public class Employee extends User{
	
	private String keyCode;

	
	private void readPropertiesFile(String string) throws IOException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("connection.properties"));
		
		String employeeAccess = prop.getProperty("employeeAccess");
		setemployeeAccess1(employeeAccess);
	}
	
	private void setemployeeAccess1(String employeeAccess) {
		
		keyCode = employeeAccess;
	}
	
	public String getemployeeAccess() {
		return keyCode;
	}

	public boolean checkemployeeAccess(String accessCheck) {
		if(accessCheck.equals(keyCode)) {
			return true;
		}
		return false;
	}
	
	
	public Employee() {
		super();
		
		try {
				readPropertiesFile("ePermissions.properties");
		}catch (IOException e) {
			// log.error("Exception thrown: " 
			e.fillInStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", name=" + name
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(keyCode);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(keyCode, other.keyCode);
	}

	
	

}

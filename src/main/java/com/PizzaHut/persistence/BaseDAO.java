package com.PizzaHut.persistence;
import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDAO {
	protected final Connection getConnection() {
		 Connection result = null;
		 try {
			 result = DriverManager.getConnection("jdbc:sqlite:PizzaHut.db");;
		 } catch (Exception ex) {
			 throw new RuntimeException(ex);
		 }	
		 return result;
	}
}

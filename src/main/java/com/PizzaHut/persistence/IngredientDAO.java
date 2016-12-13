package com.PizzaHut.persistence;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.PizzaHut.model.Ingredient;

public class IngredientDAO extends BaseDAO{

	public List<Ingredient> getAllIngredients(){
		return find("SELECT * FROM INGREDIENTEN");
	}
	
	public List<Ingredient> find(String query){
		List<Ingredient> ingredienten = new ArrayList<Ingredient>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				Ingredient i = getIngredientByName(result.getString("naam"));
				ingredienten.add(i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ingredienten;
	}
	
	public Ingredient getIngredientByName(String name){
		Ingredient i = null;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM ingredienten WHERE naam = '" + name + "'");
			while(result.next()){
				i = new Ingredient(name , result.getDouble("prijs"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean addIngredient(Ingredient ingredient){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO ingredienten VALUES ('" + ingredient.getName() + "', " + ingredient.getPrijs() + ")");
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}

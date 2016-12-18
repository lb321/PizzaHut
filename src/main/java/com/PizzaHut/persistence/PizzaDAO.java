package com.PizzaHut.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.model.Pizza;
import com.PizzaHut.services.ServiceProvider;

public class PizzaDAO extends BaseDAO{
	
	public List<Pizza> getAllPizzas(){
		return find("Select id from pizzas group by id");
	}
	
	public List<Pizza> find(String query){
		List<Pizza> pizzas = new ArrayList<Pizza>();
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()){
				Pizza pizza = getPizzaByID(result.getInt("id"));
				pizzas.add(pizza);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pizzas;
	}
	
	public boolean deletePizza(int id){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			stmt.executeQuery("DELETE FROM pizzas WHERE id = " + id);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Pizza getPizzaByID(int id){
		Pizza pizza = null;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM Pizzas WHERE id = " + id);
			while(result.next()){
				if (pizza == null){
					pizza = new Pizza(id);
					pizza.setName(result.getString("name"));
				}
				pizza.addIngredient(ServiceProvider.getIngredientService().getIngredientByName(result.getString("ingredientName")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pizza;
	}
	
	public boolean addPizza(Pizza pizza){
		boolean result = false;
		try(Connection conn = super.getConnection()){
			Statement stmt = conn.createStatement();
			for(Ingredient i : pizza.getIngredienten()){
				stmt.execute("INSERT INTO pizzas VALUES (" + pizza.getId() + ", '" + i.getName() + "', '" + pizza.getName()+"')");
			}
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}

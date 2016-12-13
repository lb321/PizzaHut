package com.PizzaHut.services;

import java.util.List;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.persistence.IngredientDAO;

public class IngredientService {
	private IngredientDAO id = new IngredientDAO();
	
	public List<Ingredient>	getAllIngredients(){
		return id.getAllIngredients();
	}
	
	public Ingredient getIngredientByName(String name){
		return id.getIngredientByName(name);
	}
	
	public boolean addIngredient(Ingredient ingredient){
		return id.addIngredient(ingredient);
	}
}

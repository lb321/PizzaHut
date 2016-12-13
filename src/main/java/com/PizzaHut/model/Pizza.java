package com.PizzaHut.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private List<Ingredient> ingredienten;
	private String name;
	private int id;
	
	public Pizza(int id) {
		this(id, new ArrayList<Ingredient>());
	}
	
	public Pizza(int id, List<Ingredient> ingredienten){
		this.id = id;
		this.ingredienten = ingredienten;
	}
	
	public void addIngredient(Ingredient i){
		ingredienten.add(i);
	}
	
	public List<Ingredient> getIngredienten(){
		return ingredienten;
	}

	@Override
	public String toString() {
		String s =  "Pizza " + id + ", " + name +  " [ingredienten={";
		for(Ingredient i : ingredienten){
			s+= i.toString();
		}
		s += "}]";
		return s;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
}

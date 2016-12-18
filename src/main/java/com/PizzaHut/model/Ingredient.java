package com.PizzaHut.model;

import java.util.List;

public class Ingredient {
	private String name;
	private double prijs;
	
	public Ingredient(String name, double prijs) {
		this.name = name;
		this.prijs = prijs;
	}
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public String getName(){
		return name;
	}
	
	public double getPrijs(){
		return prijs;
	}
	
	public void setPrijs(double prijs){
		this.prijs = prijs;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", prijs=" + prijs + "]";
	}
	
	
}

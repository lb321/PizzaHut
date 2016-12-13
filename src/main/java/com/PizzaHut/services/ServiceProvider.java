package com.PizzaHut.services;

public class ServiceProvider {
	private static IngredientService is = new IngredientService();
	private static PizzaService ps = new PizzaService();

	public static IngredientService getIngredientService() {
		return is;
	}
	
	public static PizzaService getPizzaService(){
		return ps;
	}
	
}

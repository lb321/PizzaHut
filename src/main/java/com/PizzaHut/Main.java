package com.PizzaHut;
import com.PizzaHut.model.Ingredient;
import com.PizzaHut.model.Pizza;
import com.PizzaHut.services.ServiceProvider;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ServiceProvider.getIngredientService().addIngredient(new Ingredient("Ananas", 1.00));
		Pizza pizza = new Pizza(3);
		pizza.setName("nieuwePizza");
		for(Ingredient i : ServiceProvider.getIngredientService().getAllIngredients()){
			pizza.addIngredient(i);
		}
		ServiceProvider.getPizzaService().addPizza(pizza);
		for(Pizza p : ServiceProvider.getPizzaService().getAllPizzas()){
			System.out.println(p);
		}
	}

}

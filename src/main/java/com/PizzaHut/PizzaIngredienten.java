package com.PizzaHut;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.model.Pizza;
import com.PizzaHut.services.ServiceProvider;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class PizzaIngredienten extends TestView implements View{
	private Label pname;
	private Pizza pizza;
	private Grid grid;
	public PizzaIngredienten() {
		pname = new Label("Pizza: ");
		grid = new Grid();
   	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		//System.out.println("pizzaID: " + (int)UI.getCurrent().getSession().getAttribute("pizza"));
		
		if(UI.getCurrent().getSession().getAttribute("pizza") != null){
			pizza = ServiceProvider.getPizzaService().getPizzaByID(
					((int)(UI.getCurrent().getSession().getAttribute("pizza"))));
			grid.setContainerDataSource(new BeanItemContainer<>(
			    	Ingredient.class, pizza.getIngredienten()));
			addComponents(pname, grid);
			pname.setValue("Pizza: " + pizza.getName());
			
		}
	}


}

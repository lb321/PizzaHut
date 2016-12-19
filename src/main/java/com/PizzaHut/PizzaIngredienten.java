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
import com.vaadin.ui.VerticalLayout;

public class PizzaIngredienten extends TestView implements View{
	private Label pname;
	private Pizza pizza;
	private Grid grid;
	public PizzaIngredienten() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		pname = new Label("Pizza: ");
		pname.setStyleName("h3");
		grid = new Grid();
		layout.addComponents(pname, grid);
		addComponent(layout);
   	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		//System.out.println("pizzaID: " + (int)UI.getCurrent().getSession().getAttribute("pizza"));
		
		if(UI.getCurrent().getSession().getAttribute("pizza") != null){
			pizza = ServiceProvider.getPizzaService().getPizzaByID(
					((int)(UI.getCurrent().getSession().getAttribute("pizza"))));
			grid.setContainerDataSource(new BeanItemContainer<>(
			    	Ingredient.class, pizza.getIngredienten()));
			pname.setValue("Pizza: " + pizza.getName());
			
		}
	}


}

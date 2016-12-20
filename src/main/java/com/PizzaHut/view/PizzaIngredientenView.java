package com.PizzaHut.view;

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

public class PizzaIngredientenView extends MainView implements View{
	private Label pname;
	private Pizza pizza;
	private Grid grid;
	
	public PizzaIngredientenView() {
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
		if(UI.getCurrent().getSession().getAttribute("pizza") != null){
			pizza = ServiceProvider.getPizzaService().getPizzaByID(
					((int)(UI.getCurrent().getSession().getAttribute("pizza"))));
			grid.setContainerDataSource(new BeanItemContainer<>(
			    	Ingredient.class, pizza.getIngredienten()));
			pname.setValue("Pizza: " + pizza.getName());	
		} else {
			pname.setValue("Selecteer eerst een pizza.");
		}
	}
}

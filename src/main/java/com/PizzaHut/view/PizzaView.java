package com.PizzaHut.view;

import java.util.List;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.model.Pizza;
import com.PizzaHut.services.ServiceProvider;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class PizzaView extends MainView implements View{
    private Grid grid = new Grid();
    private TextField filterText = new TextField();
    
	public PizzaView() {
		HorizontalLayout layout = new HorizontalLayout();
		List<Pizza> pizzas = ServiceProvider.getPizzaService().getAllPizzas();
	    grid.setContainerDataSource(new BeanItemContainer<>(
	    	Pizza.class, pizzas));
	    grid.removeColumn("id");
	    grid.removeColumn("ingredienten");
	    grid.addSelectionListener(event -> {
	    	//System.out.println("hallo! " + ((Pizza)event.getSelected().iterator().next()));
	    	UI.getCurrent().getSession().setAttribute("pizza", ((Pizza)event.getSelected().iterator().next()).getId());
	    	UI.getCurrent().getNavigator().navigateTo("PizzaIngredienten");
	    });
	    layout.addComponent(grid);
	    layout.setMargin(true);
	    addComponent(layout);
	}

}

package com.PizzaHut;

import java.util.List;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.services.ServiceProvider;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class IngredientView extends TestView implements View{
    private Grid grid = new Grid();
    private TextField filterText = new TextField();
    private IngredientForm iForm;
    
	public IngredientView() {
		iForm = new IngredientForm(this);
		final VerticalLayout layout = new VerticalLayout();
    	layout.setSpacing(true);
    	filterText.setInputPrompt("filter by name...");
    	filterText.addTextChangeListener(e -> {
    	    grid.setContainerDataSource(new BeanItemContainer<>(Ingredient.class,
    	            ServiceProvider.getIngredientService().findByName(e.getText())));
    	});
    	grid.addSelectionListener(event -> {
    	    if (event.getSelected().isEmpty()) {
    	    	iForm.setVisible(false);
    	    } else {
    	    	Ingredient ingredient = (Ingredient) event.getSelected().iterator().next();
    	        iForm.setIngredient(ingredient);
    	    }
    	});
    	iForm.setVisible(false);
    	Button addCustomerBtn = new Button("Add new Ingredient");
    	addCustomerBtn.addClickListener(e -> {
    	    grid.select(null);
    	    iForm.setIngredient(new Ingredient());
    	});
    	HorizontalLayout toolbar = new HorizontalLayout(filterText, addCustomerBtn);
    	toolbar.setSpacing(true);
        HorizontalLayout main = new HorizontalLayout(grid,iForm);
        main.setSpacing(true);
        main.setSizeFull();
        main.setMargin(true);
        toolbar.setMargin(true);
        grid.setSizeFull();
        updateList();
        addComponents(toolbar, main);
	}

    public void updateList() {
    	List<Ingredient> ingredients = ServiceProvider.getIngredientService().getAllIngredients();
    	grid.setContainerDataSource(new BeanItemContainer<>(Ingredient.class, ingredients));
    }
	
	@Override
	public void enter(ViewChangeEvent event) {		
        updateList();
	}

}

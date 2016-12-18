package com.PizzaHut;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.services.ServiceProvider;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    private Grid grid = new Grid();
    private TextField filterText = new TextField();
    private IngredientForm iForm = new IngredientForm(this);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
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
        grid.setSizeFull();
        layout.addComponents(toolbar, main);
        // fetch list of Customers from service and assign it to Grid
        updateList();
        layout.setMargin(true);
        setContent(layout);
    }

    public void updateList() {
    	List<Ingredient> ingredients = ServiceProvider.getIngredientService().getAllIngredients();
    	grid.setContainerDataSource(new BeanItemContainer<>(Ingredient.class, ingredients));
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

package com.PizzaHut;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.services.ServiceProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class NewView extends TestView implements View {

	public NewView() {
		VerticalLayout vLayout = new VerticalLayout();
		TextField name = new TextField();
		name.setCaption("Name: ");
		TextField prijs = new TextField();
		prijs.setCaption("Prijs: ");
		Button save = new Button("Save");
		save.addStyleName("friendly");
		Button delete = new Button("Delete");
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponents(save,delete);
		layout.setSpacing(true);
		delete.addStyleName("danger");
		save.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        ServiceProvider.getIngredientService().addIngredient(new Ingredient(name.getValue(), Double.parseDouble(prijs.getValue())));
		        UI.getCurrent().getNavigator().navigateTo("Ingredienten");
		    }
		});
		delete.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        ServiceProvider.getIngredientService().deleteIngredient(new Ingredient(name.getValue(), Double.parseDouble(prijs.getValue())));
		    }
		});
		vLayout.setSpacing(true);
		vLayout.addComponents(name, prijs, layout);
		addComponents(vLayout);
	}
	
	

}

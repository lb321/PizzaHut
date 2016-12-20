package com.PizzaHut;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.services.ServiceProvider;
import com.PizzaHut.view.IngredientView;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class IngredientForm extends FormLayout {
	private IngredientView myUi;
	private Ingredient ingredient;
	private TextField name;
	private TextField prijs;

	public IngredientForm(IngredientView myUi) {
		this.myUi = myUi;
		VerticalLayout vLayout = new VerticalLayout();
		
		name = new TextField();
		name.setCaption("Name: ");
		name.setRequired(true);
		
		prijs = new TextField();
		prijs.setCaption("Prijs: ");
		prijs.setRequired(true);
		
		Button save = new Button("Save");
		save.addStyleName("friendly");
		save.addClickListener(e->this.save());
		
		Button delete = new Button("Delete");
		delete.addStyleName("danger");
		delete.addClickListener(e->this.delete());
		
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponents(save,delete);
		layout.setSpacing(true);		
		vLayout.setSpacing(true);
		vLayout.setMargin(true);
		vLayout.addComponents(name, prijs, layout);
		addComponents(vLayout);
	}
	

	public void setIngredient(Ingredient ingredient){
		this.ingredient = ingredient;
		BeanFieldGroup.bindFieldsUnbuffered(ingredient, this);
		if(ingredient.getName() != null){
			name.setEnabled(false);
		}
	    setVisible(true);
	}
	
	private void delete() {
	    ServiceProvider.getIngredientService().deleteIngredient(ingredient);
	    myUi.updateList();
	    setVisible(false);
	}

	private void save() {
		if(ServiceProvider.getIngredientService().getIngredientByName(ingredient.getName()) == null ){
			ServiceProvider.getIngredientService().addIngredient(ingredient);
		} else {
			ServiceProvider.getIngredientService().updateIngredient(ingredient);
		}
	    myUi.updateList();
	    setVisible(false);
	}
}

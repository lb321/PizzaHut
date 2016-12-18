package com.PizzaHut;

import com.PizzaHut.model.Ingredient;
import com.PizzaHut.services.ServiceProvider;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction.KeyCode;

public class IngredientForm extends IngredientFormDesign {
	private MyUI myUi;
	private Ingredient ingredient;
	
	public IngredientForm(MyUI myUi) {
		super();
		this.myUi = myUi;
		save.setClickShortcut(KeyCode.ENTER);
		save.addClickListener(e->this.save());
		delete.addClickListener(e->this.delete());
	}
	
	
	public void setIngredient(Ingredient ingredient){
		this.ingredient = ingredient;
		BeanFieldGroup.bindFieldsUnbuffered(ingredient, this);
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

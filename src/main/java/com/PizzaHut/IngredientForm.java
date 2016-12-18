package com.PizzaHut;

import com.PizzaHut.model.Ingredient;
import com.vaadin.data.fieldgroup.BeanFieldGroup;

public class IngredientForm extends IngredientFormDesign {
	private MyUI myUi;
	private Ingredient ingredient;
	
	public IngredientForm(MyUI myUi) {
		this.myUi = myUi;
	}
	
	/*public void setIngredient(Ingredient ingredient){
		this.ingredient = ingredient;
		BeanFieldGroup.bindFieldsUnbuffered(ingredient, this);
	    setVisible(true);
	}*/

}

package com.PizzaHut;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

public class TestView extends VerticalLayout implements View{

	public TestView() {
		MenuBar menuBar = new MenuBar();
		MenuBar.Command mycommand = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		    	if(selectedItem.getText().equals("Home"))
		    		UI.getCurrent().getNavigator().navigateTo("");
		    	else
		    		UI.getCurrent().getNavigator().navigateTo(selectedItem.getText());
		    }
		};
		menuBar.addItem("Home", mycommand);
		menuBar.addItem("Ingredienten", mycommand);
		menuBar.addItem("new", mycommand);
		menuBar.addItem("Pizzas", mycommand);
		addComponents(menuBar);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
package com.PizzaHut.view;

import java.io.File;

import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Link;

public class HomeView extends MainView implements View {

	public HomeView() {
		// Find the application directory
		String basepath = VaadinService.getCurrent()
		                  .getBaseDirectory().getAbsolutePath();
		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath +
		                        "/images/pizza.png"));
		HorizontalLayout layout = new HorizontalLayout();
		// Show the image in the application
		Image image = new Image("",resource);
		layout.addComponent(image);
		layout.setMargin(true);
		addComponent(layout);
	}
	
	

}

package com.vaadin.training.dataprovider;


import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.training.dataprovider.ex1.CreateGrid;
import com.vaadin.training.dataprovider.ex2.FilteringDataProvider;
import com.vaadin.training.dataprovider.ex3.BackEndDataProvider;


public class MainLayout extends VerticalLayout implements RouterLayout {

	private Div childWrapper = new Div();

	public MainLayout(){
		setSizeFull();
                setPadding(false);

		final H1 title = new H1("Data provider Exercise");

		HorizontalLayout mainContent = new HorizontalLayout();
		add(title, mainContent);
		expand(mainContent);

		setAlignItems(Alignment.STRETCH);
		setAlignSelf(Alignment.CENTER, title);

		final VerticalLayout menuBar = new VerticalLayout();
		menuBar.add(new RouterLink(CreateGrid.TITLE, CreateGrid.class));
		menuBar.add(new RouterLink(FilteringDataProvider.TITLE, FilteringDataProvider.class));
		menuBar.add(new RouterLink(BackEndDataProvider.TITLE, BackEndDataProvider.class));
		menuBar.setAlignItems(Alignment.CENTER);
		add(menuBar);
		setSizeFull();
		menuBar.setWidth("20%");
		menuBar.getStyle().set("backgroundColor", "#EEE");

		mainContent.add(menuBar, childWrapper);
		mainContent.setAlignItems(Alignment.STRETCH);
		mainContent.expand(childWrapper);
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		childWrapper.getElement().appendChild(content.getElement());
	}

}

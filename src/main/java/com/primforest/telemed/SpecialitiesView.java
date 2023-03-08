package com.primforest.telemed;

import com.primforest.telemed.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value="Specialities",layout = MainLayout.class)
@PageTitle(" Specialities| Telemed")
 public class SpecialitiesView extends VerticalLayout {

    public SpecialitiesView() {
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        MenuBar menuBar = new MenuBar();
        MenuItem item = menuBar.addItem("Share");
        SubMenu subMenu = item.getSubMenu();
        subMenu.addItem("Facebook");
        subMenu.addItem("Twitter");
        subMenu.addItem("Instagram");
        subMenu.add(new Hr());
        subMenu.addItem("By email");
        subMenu.addItem("Get link");
        subMenu.add(new Hr());
        subMenu.addItem("Set permissions");

        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);

        });
        addButton.addClickShortcut(Key.ENTER);


        add(
            new com.vaadin.flow.component.Component[]{new H1(" MEDICAL SPECIALIZATIONS"),

                todosList, new HorizontalLayout(
                taskField,
                addButton,
                menuBar

            )});


    }}
        //RouterLink listLink = new RouterLink("Therapy", Therapy.class);
       // listLink.setHighlightCondition(HighlightConditions.sameLocation());
        //todosList.add(listLink);



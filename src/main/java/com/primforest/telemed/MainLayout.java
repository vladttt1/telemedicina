package com.primforest.telemed;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }
    /*@ParentLayout(MainLayout.class)
    public class MenuBar extends AppLayout
        implements RouterLayout {
        public MenuBar() {
            addMenuElement(SpecialitiesView.class, "SPECIALITIES");
            addMenuElement(IconsView.class, "Icons");
        }
        // name) {
            // implementation omitted
        }
    }

    @Route(value = "tutorial", layout = MenuBar.class)
    public class TutorialView extends Div {
    }

    @Route(value = "icons", layout = MenuBar.class)
    public class IconsView extends Div {
    }
    */

    private void createHeader() {
        H1 logo = new H1("TELEMEDICINE SERVICE");
        logo.addClassNames("text-l", "m-m");


        HorizontalLayout header = new HorizontalLayout(
            new DrawerToggle(),
            logo
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Patients", ListViewPatient.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());


        addToDrawer(new VerticalLayout(
            listLink,new RouterLink("doctors",DoctorsList.class),new RouterLink("Specialities",SpecialitiesView.class),new
            RouterLink( "Appointment",Therapy.class)));

    }
}

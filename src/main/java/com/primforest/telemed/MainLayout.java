package com.primforest.telemed;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;


public class MainLayout extends AppLayout {
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;

        createDrawer();
        createHeader();
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
        logo.addClassNames("text-l", "m-m",
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM);



    String u = securityService.getAuthenticatedUser().getUsername();
    Button logout = new Button("Log out " + u, e -> securityService.logout());

    var header = new HorizontalLayout(new DrawerToggle(), logo,logout);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        header.addClassNames("py-0","px-m");
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames(
    LumoUtility.Padding.Vertical.NONE,
    LumoUtility.Padding.Horizontal.MEDIUM);

    addToNavbar(header);
}


    private void createDrawer() {
        RouterLink listLink = new RouterLink("Patients", ListViewPatient.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());


        addToDrawer(new VerticalLayout(
            listLink,new RouterLink("doctors",DoctorsList.class),new RouterLink("Specialities",SpecialitiesView.class),new
            RouterLink( "Appointment", AppointmentView.class),new RouterLink("application-images-class",ImageClassResource.class),
        new RouterLink("ChatOpenAI",ChatView.class)));
    }
}

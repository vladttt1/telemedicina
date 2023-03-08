package Jitsi;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
@Route("/jitsi")
public class CallJitsi {


    public class PathComponent extends Div {
        public PathComponent() {
            setText("Hello @Route!");
        }
    }

    public class Menu extends Div {
        public Menu() {
            String route = RouteConfiguration.forSessionScope()
                .getUrl(PathComponent.class);
            Anchor link = new Anchor(route, "/meet.jit.si/test123");
            add(link);
        }
    }
}

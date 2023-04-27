package com.primforest.telemed;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import javax.annotation.security.PermitAll;

@Route("application-images-class")
@PermitAll

public class ImageClassResource extends Div {
    private static final long serialVersionUID = 1L;

    public ImageClassResource() {
        // tag::snippet[]
        StreamResource imageResource = new StreamResource("doctor1.png",
                () -> getClass().getResourceAsStream("/resources/static/doctor1.png"));

        Image image = new Image(imageResource, "My Streamed Image");
        add(image);
        // end::snippet[]

        Grid<Doctor> grid = new Grid<>();


        grid.addComponentColumn(doctor -> new Image(doctor.getImageUrl(), "OUR DOCTORS PHOTOS")).setHeader("Preview");
        Image image1 = new Image("frontend/images/doctor.jpg", "OUR DOCTORS");
        add(image1);

    }

}
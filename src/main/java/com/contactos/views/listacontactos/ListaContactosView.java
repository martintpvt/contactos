package com.contactos.views.listacontactos;

import com.contactos.models.Contacto;
import com.contactos.views.MainLayout;
import com.contactos.views.nuevocontacto.NuevoContactoView;
import com.contactos.views.utils.Utils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Lista Contactos")
@Route(value = "lista-contactos", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class ListaContactosView extends VerticalLayout {

    public ListaContactosView() {
        Grid<Contacto> grid = new Grid<>(Contacto.class, false);
        grid.addColumn(Contacto::getNombre).setHeader("First name");
        grid.addColumn(Contacto::getApellido).setHeader("Last name");
        grid.addColumn(Contacto::getCorreo).setHeader("Email");
        grid.addColumn(Contacto::getDireccion).setHeader("Direccion");
        grid.addColumn(Contacto::getCedula).setHeader("Cedula");
        grid.addColumn(Contacto::getTelefono).setHeader("Telefono");
        grid.addColumn(
          new ComponentRenderer<>(contacto -> {
              Button botonBorrar = new Button();
              botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
              botonBorrar.addClickListener(e -> {
                 Utils.contactos.remove(contacto);
                 grid.getDataProvider().refreshAll();
              });
              botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));

              Button botonEditar = new Button();
              botonEditar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
              botonEditar.addClickListener(e -> {
                  botonEditar.getUI().ifPresent(ui ->
                          ui.navigate(NuevoContactoView.class, contacto.getCedula()));
              });
              botonEditar.setIcon(new Icon(VaadinIcon.EDIT));

              HorizontalLayout buttons = new HorizontalLayout(botonBorrar, botonEditar);
              return buttons;
          })
        );

        grid.setItems(Utils.contactos);

        add(
                grid
        );
    }
}

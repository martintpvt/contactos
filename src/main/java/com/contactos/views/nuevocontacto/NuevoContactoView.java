package com.contactos.views.nuevocontacto;

import com.contactos.models.Contacto;
import com.contactos.views.utils.Utils;
import com.contactos.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Nuevo Contacto")
@Route(value = "nuevo-contacto", layout = MainLayout.class)
@Uses(Icon.class)
public class NuevoContactoView extends Composite<VerticalLayout> implements HasUrlParameter<String> {

    HorizontalLayout layoutRow = new HorizontalLayout();
    TextField textFieldNombre = new TextField();
    TextField textFieldApellido = new TextField();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    TextField textFieldTelefono = new TextField();
    TextField textFieldDireccion = new TextField();
    HorizontalLayout layoutRow3 = new HorizontalLayout();
    TextField textFieldCorreo = new TextField();
    TextField textFieldCedula = new TextField();
    HorizontalLayout layoutRow4 = new HorizontalLayout();
    Button buttonGuardar = new Button();
    Button buttonCancelar = new Button();

    public NuevoContactoView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setWidth("min-content");
        textFieldApellido.setLabel("Apellido");
        textFieldApellido.setWidth("min-content");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("min-content");
        textFieldTelefono.setLabel("Telefono");
        textFieldTelefono.setWidth("min-content");
        textFieldDireccion.setLabel("Direccion");
        textFieldDireccion.setWidth("min-content");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.setHeight("min-content");
        textFieldCorreo.setLabel("Correo");
        textFieldCorreo.setWidth("min-content");
        textFieldCedula.setLabel("Cedula");
        textFieldCedula.setWidth("min-content");
        layoutRow4.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        buttonGuardar.setText("Guardar");
        buttonGuardar.setWidth("min-content");
        buttonGuardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonGuardar.addClickListener(buttonClickEvent -> {
            String nombre = textFieldNombre.getValue();
            String apellido = textFieldApellido.getValue();
            String telefono = textFieldTelefono.getValue();
            String direccion = textFieldDireccion.getValue();
            String correo = textFieldCorreo.getValue();
            String cedula = textFieldCedula.getValue();

            Contacto contacto = new Contacto(nombre, apellido, telefono, direccion, correo, cedula);
            Utils.contactos.add(contacto);

            buttonGuardar.getUI().ifPresent(ui ->
                    ui.navigate("lista-contactos"));
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.setWidth("min-content");

        buttonCancelar.addClickListener(buttonClickEvent -> {
            buttonCancelar.getUI().ifPresent(ui ->
                    ui.navigate("lista-contactos"));
        });

        getContent().add(layoutRow);
        layoutRow.add(textFieldNombre);
        layoutRow.add(textFieldApellido);
        getContent().add(layoutRow2);
        layoutRow2.add(textFieldTelefono);
        layoutRow2.add(textFieldDireccion);
        getContent().add(layoutRow3);
        layoutRow3.add(textFieldCorreo);
        layoutRow3.add(textFieldCedula);
        getContent().add(layoutRow4);
        layoutRow4.add(buttonGuardar);
        layoutRow4.add(buttonCancelar);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String cedulaContacto) {
        if(cedulaContacto != null) {

        }
    }
}

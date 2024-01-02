package com.contactos.views.utils;

import com.contactos.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Contacto> contactos = new ArrayList<>(
            List.of(
                    new Contacto("Martin", "Almeida", "1234", "Angamarca",
                            "martin.almeida.gachet", "asdasd"),
                    new Contacto("asdf", "hgfd", "435534", "sdfs",
                            "asdf.adfsdsafas.asdf", "asdfsdf")
            )
    );
}

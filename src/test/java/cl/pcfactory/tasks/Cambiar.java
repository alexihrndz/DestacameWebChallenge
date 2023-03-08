package cl.pcfactory.tasks;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Cambiar {

    private Cambiar() {
    }

    public static Performable tiendaRetiro() {
        return instrumented(CambiarTiendaRetiro.class);
    }
}

package cl.pcfactory.tasks;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Seleccionar {

    private Seleccionar() {
    }

    public static Performable pagarComoInvitado() {
        return instrumented(SeleccionarPagarComoInvitado.class);
    }

    public static Performable tipoEntrega(String tipoEntrega, String direccionRetiro) {
        return instrumented(SeleccionarTipoEntrega.class, tipoEntrega, direccionRetiro);
    }
}

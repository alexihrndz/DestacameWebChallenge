package cl.pcfactory.tasks;

import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Eliminar {

    private Eliminar() {
    }

    public static Performable productoDeCarrito(List<Map<String, String>> datos) {
        return instrumented(EliminarProductoDeCarrito.class, datos.get(0));
    }
}

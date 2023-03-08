package cl.pcfactory.tasks;

import cl.pcfactory.interactions.AgregarProducto;
import cl.pcfactory.interactions.BuscarProducto;
import cl.pcfactory.userinterfaces.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarYAgregar implements Task {

  private final List<Map<String, String>> productos;

  public BuscarYAgregar(List<Map<String, String>> productos) {
    this.productos = productos;
  }

  public static Performable alCarrito(List<Map<String, String>> dataTable) {
    return instrumented(BuscarYAgregar.class, dataTable);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    for (Map<String, String> producto : productos) {
      actor.attemptsTo(
          BuscarProducto.enBuscarAqui(producto), AgregarProducto.alCarrito(producto), Click.on(BusquedaPage.BTN_SEGUIR_COPRANDO));
    }
  }
}

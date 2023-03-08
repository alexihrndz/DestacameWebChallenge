package cl.pcfactory.tasks;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Continuar {

  private Continuar() {}

  public static Performable conLaCompra() {
    return instrumented(ContinuarCompra.class);
  }
}

package cl.pcfactory.tasks;

import cl.pcfactory.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;


import java.util.Map;

public class EliminarProductoDeCarrito implements Task {

  private final Map<String, String> datos;

  public EliminarProductoDeCarrito(Map<String, String> datos) {
    this.datos = datos;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Click.on(
            By.cssSelector(
                "#bton_deleteprod_"
                    .concat(
                        actor.recallAll().get("ID".concat(datos.get("descripcion"))).toString()))),
            Ensure.that(CarritoPage.MSG_ITEM_ELIMINADO).isDisplayed());
  }
}

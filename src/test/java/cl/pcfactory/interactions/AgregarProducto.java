package cl.pcfactory.interactions;

import cl.pcfactory.userinterfaces.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Map;

import static cl.pcfactory.userinterfaces.BusquedaPage.LBL_AGREGASTE_AL_CARRITO;
import static cl.pcfactory.utils.constants.TextosConstantes.A_TU_CARRO;
import static cl.pcfactory.utils.constants.TextosConstantes.FELICIDADES_AGREGASTE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class AgregarProducto implements Interaction {

  private final Map<String, String> producto;

  public AgregarProducto(Map<String, String> producto) {
    this.producto = producto;
  }

  public static Performable alCarrito(Map<String, String> producto) {
    return instrumented(AgregarProducto.class, producto);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(Wait.until(the(By.cssSelector("[class*='product-ab-link copy-id ']")), isVisible()).forNoMoreThan(Duration.ofSeconds(30)));
    actor.remember(
        "ID".concat(producto.get("descripcion")),
        Attribute.of(By.cssSelector("[class*='product-ab-link copy-id ']"))
            .named("data-clipboard-text")
            .answeredBy(actor));

    actor.attemptsTo(
        Click.on(BusquedaPage.BTN_AGREGAR_AL_CARRITO.waitingForNoMoreThan(Duration.ofSeconds(10))),
        Ensure.that(LBL_AGREGASTE_AL_CARRITO.waitingForNoMoreThan(Duration.ofSeconds(15)))
            .text()
            .contains(FELICIDADES_AGREGASTE.getText()),
        Ensure.that(LBL_AGREGASTE_AL_CARRITO).text().contains(producto.get("descripcion")),
        Ensure.that(LBL_AGREGASTE_AL_CARRITO).text().contains(A_TU_CARRO.getText()));
  }
}

package cl.pcfactory.tasks;

import cl.pcfactory.interactions.Esperar;
import cl.pcfactory.userinterfaces.CheckoutPage;
import cl.pcfactory.userinterfaces.PrepagoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;

import static cl.pcfactory.utils.constants.TextosConstantes.RETIRO_EN_TIENDA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SeleccionarTipoEntrega implements Task {

  private final String tipoEntrega;
  private String nombreTienda;

  public SeleccionarTipoEntrega(String tipoEntrega) {
    this.tipoEntrega = tipoEntrega;
  }

  public SeleccionarTipoEntrega(String tipoEntrega, String nombreTienda) {
    this.tipoEntrega = tipoEntrega;
    this.nombreTienda = nombreTienda;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    if (tipoEntrega.equalsIgnoreCase(RETIRO_EN_TIENDA.getText())) {
      actor.attemptsTo(
          Esperar.loaderDesaparezca(),
          Scroll.to(PrepagoPage.OPT_RETIRO_EN_TIENDA.waitingForNoMoreThan(Duration.ofSeconds(20))),
          Click.on(PrepagoPage.OPT_RETIRO_EN_TIENDA),
          Esperar.loaderDesaparezca(),
          Wait.until(the(CheckoutPage.LST_TIENDAS), isClickable())
              .forNoMoreThan(Duration.ofSeconds(15)),
          Click.on(CheckoutPage.LST_TIENDAS),
          Click.on(CheckoutPage.OPC_TIENDA.of(nombreTienda)));
    }
  }
}

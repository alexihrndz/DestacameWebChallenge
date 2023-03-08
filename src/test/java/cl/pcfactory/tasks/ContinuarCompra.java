package cl.pcfactory.tasks;

import cl.pcfactory.interactions.Esperar;
import cl.pcfactory.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static cl.pcfactory.userinterfaces.CheckoutPage.LBL_SIN_STOCK;

public class ContinuarCompra implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    Logger logger = LoggerFactory.getLogger("Finalizando compra: ");
    if (Visibility.of(LBL_SIN_STOCK).answeredBy(actor)) {
      actor.attemptsTo(Cambiar.tiendaRetiro());
    }
    actor.attemptsTo(
        Esperar.loaderDesaparezca(),
        Click.on(CheckoutPage.BTN_CONTINUAR_COMPRA),
        Ensure.that(CheckoutPage.LBL_DOCUMENTO.waitingForNoMoreThan(Duration.ofSeconds(10)))
            .isDisplayed());

    logger.info("se realiza la compra");
  }
}

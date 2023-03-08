package cl.pcfactory.questions;

import cl.pcfactory.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MontoTotalCompra implements Question<Boolean> {

  private final Integer monto;

  public MontoTotalCompra(Integer monto) {
    this.monto = monto;
  }

  public static MontoTotalCompra esMayorA(Integer monto) {
    return new MontoTotalCompra(monto);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    Logger logger = LoggerFactory.getLogger("Vaidacion monto total: ");
    actor.attemptsTo(
        JavaScriptClick.on(HomePage.BTN_IR_AL_CARRITO),
        Click.on(HomePage.BTN_IR_AL_CARRITO_RESUMEN));

    double montoTotal =
        Double.parseDouble(
            Text.of(By.cssSelector("p[class='card-title card-title--normal color-dark-2']"))
                .answeredBy(actor)
                .replaceAll("[^0-9]", ""));

    if ((montoTotal - monto) > 0) {
      logger.info("Monto mayor al presupuesto");
      return true;
    } else {
      return false;
    }
  }
}

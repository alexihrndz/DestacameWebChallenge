package cl.pcfactory.tasks;

import cl.pcfactory.userinterfaces.CarritoPage;
import cl.pcfactory.userinterfaces.HomePage;
import cl.pcfactory.userinterfaces.ResumenCompraPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import java.time.Duration;

import static cl.pcfactory.userinterfaces.HomePage.BTN_IR_AL_CARRITO_RESUMEN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SeleccionarPagarComoInvitado implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Check.whether(the(CarritoPage.BTN_PAGAR), isNotCurrentlyVisible())
            .andIfSo(
                Scroll.to(HomePage.BTN_IR_AL_CARRITO),
                Click.on(HomePage.BTN_IR_AL_CARRITO),
                Click.on(BTN_IR_AL_CARRITO_RESUMEN)),
        Scroll.to(CarritoPage.BTN_PAGAR),
        JavaScriptClick.on(CarritoPage.BTN_PAGAR),
        Click.on(
            ResumenCompraPage.BTN_SEGUIR_COMO_INVITADO.waitingForNoMoreThan(
                Duration.ofSeconds(5))));
  }
}

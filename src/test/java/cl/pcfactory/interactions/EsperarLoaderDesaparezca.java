package cl.pcfactory.interactions;

import cl.pcfactory.userinterfaces.CheckoutPage;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.waits.Wait;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class EsperarLoaderDesaparezca implements Interaction, IsSilent {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.until(the(CheckoutPage.LOADER), isNotPresent())
        );
    }
}

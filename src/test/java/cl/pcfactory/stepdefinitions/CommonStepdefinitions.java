package cl.pcfactory.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CommonStepdefinitions {


    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Dado("^que (.*) ingreso a la pagina (.*)$")
    public void ingresoAPaginaEcommerce(String actor, String nombreSitio) {
        theActorCalled(actor).wasAbleTo(Open.url(nombreSitio));
    }
}

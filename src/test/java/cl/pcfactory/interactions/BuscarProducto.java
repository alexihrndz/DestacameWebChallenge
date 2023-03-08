package cl.pcfactory.interactions;

import cl.pcfactory.userinterfaces.BusquedaPage;
import cl.pcfactory.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.Keys;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class BuscarProducto implements Task {

    private final Map<String, String> dataTable;

    public BuscarProducto(Map<String, String> dataTable) {
        this.dataTable = dataTable;
    }

    public static Performable enBuscarAqui(Map<String, String> dataTable) {
        return instrumented(BuscarProducto.class, dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(dataTable.get("descripcion"))
                        .into(HomePage.TXT_BUSCAR_AQUI)
                        .thenHit(Keys.ENTER),
                Wait.until(the(BusquedaPage.FRAME_PRODUCTOS), isVisible()));
    }
}

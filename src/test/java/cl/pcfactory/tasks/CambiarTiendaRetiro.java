package cl.pcfactory.tasks;

import cl.pcfactory.userinterfaces.CheckoutPage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CambiarTiendaRetiro implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {

    Object label;
    Object customProperties;
    JsonObject jsonObject;

    JsonArray jsonArray =
        JsonParser.parseString(
                Attribute.of(By.xpath("(//*[@class='select-group'])[1]/div"))
                    .named("data-choices-array")
                    .answeredBy(actor))
            .getAsJsonArray();

    for (int i = 1; i < jsonArray.size(); i++) {
      jsonObject = jsonArray.get(i).getAsJsonObject();

      label = jsonObject.get("label").toString().replaceAll("\"", "");
      customProperties = jsonObject.get("customProperties").toString().replaceAll("\"", "");
      if (customProperties.toString().contains("true")
          & !label.toString().contains("Selecciona una sucursal")) {
        actor.attemptsTo(
                Wait.until(the(CheckoutPage.LST_TIENDAS), isClickable())
                        .forNoMoreThan(Duration.ofSeconds(15)),
                Click.on(CheckoutPage.LST_TIENDAS),
                Click.on(CheckoutPage.OPC_TIENDA.of(String.valueOf(label))));
        break;
      }
    }
  }
}

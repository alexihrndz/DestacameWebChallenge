package cl.pcfactory.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PrepagoPage {

  public static final Target OPT_RETIRO_EN_TIENDA =
      Target.the("Opcion retiro en tienda").located(By.cssSelector("[name='rb_tipo_despacho'][id='accordion1']"));

    private PrepagoPage() {
    }
}

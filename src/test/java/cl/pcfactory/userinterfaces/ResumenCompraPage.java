package cl.pcfactory.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResumenCompraPage {

  public static final Target BTN_SEGUIR_COMO_INVITADO =
      Target.the("Boton seguir como invitado").located(By.id("btn_invitado"));

    private ResumenCompraPage() {
    }
}

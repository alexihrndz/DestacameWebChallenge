package cl.pcfactory.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

  public static final Target BTN_PAGAR = Target.the("Boton ir a pagar").located(By.id("btn_ir_pantalla"));
  public static final Target MSG_ITEM_ELIMINADO = Target.the("Mensaje item eliminado")
          .located(By.xpath("//*[contains(.,'Se ha eliminado del carro')]"));

    private CarritoPage() {
    }
}

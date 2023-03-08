package cl.pcfactory.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

  public static final Target TXT_BUSCAR_AQUI =
      Target.the("Input buscar aqui").locatedBy("#searchalgolia div input");
  public static final Target BTN_IR_AL_CARRITO = Target.the("Boton ir al carrito")
          .locatedBy("[class='button-icon cart-modal__button-open']");
  public static final Target BTN_IR_AL_CARRITO_RESUMEN = Target.the("Btn ir al carrito en resumen")
          .located(By.id("ir_a_mi_carro"));

  private HomePage() {}
}

package cl.pcfactory.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage {
  public static final Target FRAME_PRODUCTOS =
      Target.the("Frame de productos").located(By.id("productsalgolia"));
  public static final Target BTN_AGREGAR_AL_CARRITO =
      Target.the("Boton agregar al carrito en el producto")
          .locatedBy("(//*[@class='button-no-decoration button-pointer-e-none'])[1]");
  public static final Target LBL_AGREGASTE_AL_CARRITO =
      Target.the("Titulo de agregado al carrito")
          .located(By.xpath("//*[@id='addtocartpopuptitle']/.."));
  public static final Target BTN_SEGUIR_COPRANDO =
      Target.the("Boton seguir comprando").located(By.id("seguir_comprando"));

  private BusquedaPage() {}
}

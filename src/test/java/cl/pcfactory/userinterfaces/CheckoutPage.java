package cl.pcfactory.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

  public static final Target OPC_TIENDA =
      Target.the("Opc tienda {0}").locatedBy("//*[.='{0}' and contains(@id,'choices')]");
  public static final Target LST_TIENDAS = Target.the("Lista tiendas").locatedBy(".choices");
  public static final Target LBL_DIRECION_TIENDA =
      Target.the("Direccion de la tienda").located(By.cssSelector("#direccion_entrega"));
  public static final Target LOADER =
      Target.the("Loader")
          .locatedBy(
              "[class='loader-container loader-container--bg-light loader-container--active]'");
  public static final Target BTN_CONTINUAR_COMPRA =
      Target.the("Boton continuar compra").located(By.id("btn_continuar_pago"));
  public static final Target LBL_DOCUMENTO =
      Target.the("Titulo documento").locatedBy("//div[text()='Selecciona tipo de documento']");
  public static final Target LBL_SIN_STOCK =
      Target.the("Titulo Sin stock")
          .locatedBy("//div[@class='no-stock no-stock--active']/div[contains(.,'Sin Stock en')]");

  private CheckoutPage() {}
}

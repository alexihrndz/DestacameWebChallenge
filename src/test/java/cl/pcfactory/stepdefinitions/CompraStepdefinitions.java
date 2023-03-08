package cl.pcfactory.stepdefinitions;

import cl.pcfactory.questions.MontoTotalCompra;
import cl.pcfactory.tasks.BuscarYAgregar;
import cl.pcfactory.tasks.Continuar;
import cl.pcfactory.tasks.Eliminar;
import cl.pcfactory.tasks.Seleccionar;
import cl.pcfactory.userinterfaces.CheckoutPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Pero;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static cl.pcfactory.utils.constants.TextosConstantes.RETIRO_EN_TIENDA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraStepdefinitions {

  @Cuando("el busca el producto por descripcion y lo agrega al carrito")
  public void buscaAgregaAlCarrito(List<Map<String, String>> dataTable) {
    theActorInTheSpotlight().attemptsTo(BuscarYAgregar.alCarrito(dataTable));
  }

  @Pero("verifica si el monto total de la compra es mayor a {int} y elimina:")
  public void verificaMontoTotalCarrito(Integer monto, List<Map<String, String>> datos) {
    theActorInTheSpotlight()
        .attemptsTo(
            Check.whether(MontoTotalCompra.esMayorA(monto))
                .andIfSo(Eliminar.productoDeCarrito(datos)));
  }

  @Cuando("^el continua la compra con la opcion de recoger en la tienda: (.*)$")
  public void opcionRecogerEnTienda(String nombreTienda) {
    theActorInTheSpotlight()
        .attemptsTo(
            Seleccionar.pagarComoInvitado(),
            Seleccionar.tipoEntrega(RETIRO_EN_TIENDA.getText(), nombreTienda));
  }

  @Entonces("^verifica que la direccion de la tienda es: (.*)$")
  public void verificaDireccionTienda(String direccion) {
    theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that(
                    CheckoutPage.LBL_DIRECION_TIENDA.waitingForNoMoreThan(Duration.ofSeconds(15)))
                .text()
                .containsIgnoringCase(direccion));
  }

  @Entonces("termina la compra")
  public void terminaLaCompra() {
    theActorInTheSpotlight().attemptsTo(Continuar.conLaCompra());
  }
}

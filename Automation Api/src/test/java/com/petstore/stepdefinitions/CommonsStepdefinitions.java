package com.petstore.stepdefinitions;

import com.petstore.models.DatosRequest;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.petstore.utils.RandomsUtils.getRandomIdNumber;
import static com.petstore.utils.constants.CONST.JSON_FILES_DIR;
import static net.serenitybdd.rest.SerenityRest.given;

public class CommonsStepdefinitions {

  DatosRequest datosRequest = new DatosRequest();
  RequestSpecification requestSpecification;
  Response response;
  JSONObject jsonBodyRequest;

  @Before
  public void prepareStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("^que (.*) define la url (.*) y path (.*)$")
  public void setActorYUrl(String actor, String url, String path) {
    OnStage.theActorCalled(actor);
    datosRequest.setUrl(url);
    datosRequest.setPath(path);
  }

  @Dado("^body request: (.*)$")
  public void cargaBodyRequestDesdeArchivo(String pathFile) throws IOException {
    jsonBodyRequest =
        new JSONObject(
            new String(Files.readAllBytes(Paths.get(JSON_FILES_DIR.getText().concat(pathFile)))));
    jsonBodyRequest.put("id", getRandomIdNumber());
    datosRequest.setPayLoad(jsonBodyRequest.toString());
  }

  @Dado("^body request update: (.*)$")
  public void cargaBodyRequestDesdeArchivoUpdate(String pathFile) throws IOException {
    jsonBodyRequest =
        new JSONObject(
            new String(Files.readAllBytes(Paths.get(JSON_FILES_DIR.getText().concat(pathFile)))));
  }

  @Y("agrega el id anterior al request")
  public void agregaElIdAnteriorAlRequest() throws IOException {
    jsonBodyRequest.put("id", getIdAnterior().get("id").toString());
    jsonBodyRequest.put("name", "test update");
    jsonBodyRequest.put("status", "cancelled");
    datosRequest.setPayLoad(jsonBodyRequest.toString());
  }

  @Cuando("^ejecuta el metodo (.*)$")
  public void ejecutaRequestMetodo(String metodo) {
    if (metodo.equalsIgnoreCase("post")) {
      requestSpecification =
          given()
              .baseUri(datosRequest.getUrl())
              .basePath(datosRequest.getPath())
              .body(datosRequest.getPayLoad())
              .contentType(ContentType.JSON);
      response = requestSpecification.log().all().post();
    }
    if (metodo.equalsIgnoreCase("get")) {
      requestSpecification =
          given()
              .baseUri(datosRequest.getUrl())
              .basePath(datosRequest.getPath())
              .contentType(ContentType.JSON);
      response = requestSpecification.log().all().get();
    }
    if (metodo.equalsIgnoreCase("put")) {
      requestSpecification =
          given()
              .baseUri(datosRequest.getUrl())
              .basePath(datosRequest.getPath())
              .body(datosRequest.getPayLoad())
              .contentType(ContentType.JSON);
      response = requestSpecification.log().all().put();
    }
  }

  @Entonces("el puede ver status {int}")
  public void elPuedeVerStatus(Integer status) throws IOException {
    FileWriter file = new FileWriter(JSON_FILES_DIR.getText().concat("temp/output.json"));
    file.write(response.jsonPath().prettify());
    file.close();
    OnStage.theActorInTheSpotlight()
        .attemptsTo(Ensure.that(response.statusCode()).isEqualTo(status));
  }

  @Entonces("^valida el schema segun el archivo: (.*)$")
  public void validaSchemaResponse(String pathFile) {
    response
        .then()
        .assertThat()
        .body(
            JsonSchemaValidator.matchesJsonSchema(
                new File(JSON_FILES_DIR.getText().concat(pathFile))));
  }

  @Y("en los queryParams agrega id creado en el create anterior")
  public void losQueryParams() throws IOException {
    datosRequest.setPath(
        datosRequest.getPath().concat("/").concat(getIdAnterior().get("id").toString()));
  }

  private JsonPath getIdAnterior() throws IOException {
    return new JsonPath(
        new String(
            Files.readAllBytes(Paths.get(JSON_FILES_DIR.getText().concat("temp/output.json")))));
  }
}

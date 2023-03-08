package cl.pcfactory.interactions;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Esperar {


    private Esperar() {
    }

    public static Performable loaderDesaparezca() {
        return instrumented(EsperarLoaderDesaparezca.class);
    }
}

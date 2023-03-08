package cl.pcfactory.utils.constants;

public enum TextosConstantes {
    A_TU_CARRO("a tu carro"),
    RETIRO_EN_TIENDA("Retiro en tienda"),
    FELICIDADES_AGREGASTE("¡Felicidades! Agregaste");

    private String text;

    TextosConstantes(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

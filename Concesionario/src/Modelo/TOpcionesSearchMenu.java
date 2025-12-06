package Modelo;

public enum TOpcionesSearchMenu {
    BY_BRAND(3.1, "Buscar por marca"), BY_PRICE (3.2, "Buscar por precio"), BY_YEAR(3.3, "Buscar por año"), EXIT(3.4, "Volver al menú principal");

    private double opDouble;
    private String opString;

    TOpcionesSearchMenu(double opDouble, String opString) {
        this.opDouble = opDouble;
        this.opString = opString;
    }

    public double getOpDouble() {
        return opDouble;
    }

    public String getOpString() {
        return opString;
    }
}

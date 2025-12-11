package Modelo;

public enum TOpcionesSearchMenu {
    BY_BRAND(1, "Buscar por marca"), BY_PRICE (2, "Buscar por precio"), BY_YEAR(3, "Buscar por año"), EXIT(4, "Volver al menú principal");

    private int opInt;
    private String opString;

    TOpcionesSearchMenu(int opInt, String opString) {
        this.opInt = opInt;
        this.opString = opString;
    }

    public int getOpInt() {
        return opInt;
    }

    public String getOpString() {
        return opString;
    }
}

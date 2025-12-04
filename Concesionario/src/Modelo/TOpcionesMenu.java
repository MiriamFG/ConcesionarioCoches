package Modelo;

public enum TOpcionesMenu {
    ADD(1), SHOW, SEARCH, REGISTERGUEST, REGISTERSALE, SALELIST, EXIT

    private String opText;
    private int opInt;



    TOpcionesMenu(int opInt){
        this.opInt = opInt;
    }

    TOpcionesMenu(String opText){
        this.opText = opText;
    }




}

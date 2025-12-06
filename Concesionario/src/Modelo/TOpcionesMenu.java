    package Modelo;

    public enum TOpcionesMenu {
        ADD(1, "Añadir coche"), SHOW (2, "Mostrar Coches Disponibles"), SEARCH (3, "Buscar Coche"), REGISTERGUEST(4, "Registrar Cliente Nuevo"), REGISTERSALE(5, "Registrar Ventas"), SALELIST(6, "Mostrar Listado de Ventas"), EXIT(7, "Salir");


        private int opInt;
        private String opText;

        TOpcionesMenu(int opInt, String opText){
            this.opInt = opInt;
            this.opText = opText;
        }

        public int getOpInt() {
            return opInt;
        }


        public String getOpText() {
            return opText;
        }
    }

package Controlador;

import Modelo.*;

import View.SimpleViewContr;

import java.util.ArrayList;
import java.util.List;

public class ConcessContr {

    private SimpleViewContr vista;

    private List<CocheDTO> coches = new ArrayList<>();
    private List<ClientesDTO> clientes = new ArrayList<>();
    private List<VentasDTO> ventas = new ArrayList<>();
    private ArrayList<CocheDTO> cochesNoVendidos = new ArrayList<>();

    /**
     * Determina las acciones que debe hacer el menú cuando el usuario selecciona una opción.
     */
    public void run(){
        while(true){
            TOpcionesMenu op = vista.mostrarMenu();

            if(op == TOpcionesMenu.ADD){
                anadirCoche();
            }

            if(op == TOpcionesMenu.SHOW){
                mostrarCoches();
            }

            if(op == TOpcionesMenu.SEARCH){
                TOpcionesSearchMenu opc = vista.mostrarMenuBusqueda();
                if(opc == TOpcionesSearchMenu.BY_BRAND){
                    buscarPorMarca(vista.pedirBuscarMarca());
                }

                if(opc == TOpcionesSearchMenu.BY_PRICE){
                    buscarPorPrecio(vista.pedirbuscarMinPrecio(), vista.pedirbuscarMaxPrecio());

                }

                if(opc == TOpcionesSearchMenu.BY_YEAR){
                    buscarPorAnho(vista.pedirBuscarAnho());

                }

                if(opc == TOpcionesSearchMenu.EXIT){
                    continue;
                }
            }

            if(op == TOpcionesMenu.REGISTERGUEST){
                registarCliente();
            }

            if(op == TOpcionesMenu.REGISTERSALE){
                registrarVenta();
            }

            if(op == TOpcionesMenu.SALELIST){
                listarVentas();

            }

            if(op == TOpcionesMenu.EXIT){
                vista.exit();
                return;
            }
        }
    }

    /**
     * Añade un coche y verifica que los datos obligatorios sean cubiertos por el usuario
     */
    public void anadirCoche(){
        String matricula = null;
        String marca = null;
        double precio;
        int anho;

        while(true){
            marca = vista.pedirMarca();
            if(marca.equals("")){
                vista.errorMensaje("Introduce una marca por favor");
            }else{
                break;
            }
        }

        while (true){
            matricula = vista.pedirMatricula();
            if(matricula.equals("")){
                vista.errorMensaje("Introduce una matrícula por favor");
            }else{
                break;
            }
        }

        while (true){
            anho = vista.pedirAnho();
            if(anho >= 2026){
                vista.errorMensaje("Introduce una año lógico");
            }else{
                break;
            }
        }

        while (true){
            precio = vista.pedirPrecio();
            if(precio <= 0){
                vista.errorMensaje("Ambos sabemos que no me lo vas a vender gratis");
            }else{
                break;
            }
        }

        CocheDTO coche = new CocheDTO(marca, vista.pedirModelo(), matricula, precio, anho, vista.pedirKilometros(), false);
        coches.add(coche);
        vista.mostrarMensaje(coche + "añadido" );
    }

    /**
     * Muestra los coches NO vendidos
     * @return coches no vendidos
     */
    public ArrayList<CocheDTO> mostrarCoches(){

        for(CocheDTO c : coches){
            if(!c.isVendido()){
                cochesNoVendidos.add(c);
            }
        }
        vista.mostrarCoches(cochesNoVendidos);
        return cochesNoVendidos;
    }

    /**
     * Busca los coches por marca
     * @param marca
     */
    public void buscarPorMarca(String marca){

        boolean encontrado = false;

        List<CocheDTO> cochesMarca = new ArrayList<>();
        for(CocheDTO c : coches){
            if(c.getMarca().toLowerCase().contains(marca)){
                cochesMarca.add(c);
                encontrado = true;
            }
        }
        if(encontrado){
            vista.mostrarCoches((ArrayList<CocheDTO>) cochesMarca);

        }else{
            vista.mostrarMensaje("marca no encontrada");
        }
    }

    /**
     * Busca los coches por año
     * @param anho
     */
    public void buscarPorAnho(int anho) {

        boolean encontrado = false;

        List<CocheDTO> cochesAnho = new ArrayList<>();
        for (CocheDTO c : coches) {
            if (c.getAnho() == anho) {
                cochesAnho.add(c);
                encontrado = true;

            }
        }
        if (encontrado) {
            vista.mostrarCoches((ArrayList<CocheDTO>) cochesAnho);

        } else {
            vista.mostrarMensaje("año no encontrada");
        }
    }

    /**
     * Busca los coches por precio por parámetros minimo y máximo
     * @param min
     * @param max
     */
    public void buscarPorPrecio(double min, double max) {

        boolean encontrado = false;


        List<CocheDTO> cochesPrecio = new ArrayList<>();
        for (CocheDTO c : coches) {
            if (c.getPrecio() >= min && c.getPrecio() <= max) {
                cochesPrecio.add(c);
                encontrado = true;

            }
        }
        if (encontrado) {
            vista.mostrarCoches((ArrayList<CocheDTO>) cochesPrecio);

        } else {
            vista.mostrarMensaje("rango de precio no encontrado");
        }
    }

    /**
     * Registra un cliente
     */
    public void registarCliente(){
        String dni = vista.pedirDni();
        boolean clienteRepetido = false;

        for (ClientesDTO c : clientes) {
            if(c.getDni().equals(dni)){
                vista.errorMensaje("cliente repetido"); //no funciona
                clienteRepetido = true;
            }
        }
        if(!clienteRepetido){
            ClientesDTO cliente = new ClientesDTO(dni, vista.pedirNombre(), vista.pedirTelefono());
            clientes.add(cliente);
            vista.mostrarMensaje(cliente +  " " );
        }
    }

    /**
     * Busca un cliente por DNI
     */
    private ClientesDTO buscarCliente(String dni){
        for(ClientesDTO c : clientes){
            if(c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }

    /**
     * Crea una venta, primero busca si el cliente está o no, muestra coches para que el usuario seleccione
     * luego, crea la venta
     */
    public void registrarVenta() {
        String dni = vista.pedirDni();
        ClientesDTO cliente = buscarCliente(dni);
        int numSelect;
        CocheDTO cocheSelect = null;
        int idVenta;

        if (cliente == null) {
            vista.errorMensaje("El cliente no existe, necesitamos crearlo");
            vista.mostrarMensaje("");
            cliente = new ClientesDTO(dni, vista.pedirNombre(), vista.pedirTelefono());
            clientes.add(cliente);
        }

        cochesNoVendidos = mostrarCoches();

        while(true){
            numSelect = vista.selecCoche();

            if(numSelect < 1 || numSelect > coches.size()){
                vista.errorMensaje("Opción incorrecta");
            }else{
                break;
            }
        }
         idVenta = ventas.size() + 1;

        cocheSelect = coches.get(numSelect - 1);
        coches.get(numSelect -1).setVendido(true);
        ventas.add(new VentasDTO(cocheSelect,cliente,idVenta));


        vista.mostrarMensaje("Muchas gracias!");

    }

    /**
     * Muestra las ventas
     */
    public void listarVentas() {

        if (ventas.isEmpty()){
            vista.errorMensaje("No se registraron ventas aún");
        }else{
            vista.mostrarVentas(ventas);
        }
    }

    /**
     * Listado de coches iniciales
     */
    public void generarCoches(){
        coches.add(new CocheDTO("Ford", "Focus", "1111AAA", 10000, 2015, 12187, false));
        coches.add(new CocheDTO("Audi", "A3", "2222BBB", 30000, 2010, 10000, false));
        coches.add(new CocheDTO("Toyota", "Celica", "3333CCC", 40000, 1990, 200899, false));
        coches.add(new CocheDTO("Seat", "Ibiza", "4444DDD", 20000, 2025, 1000, false));
        coches.add(new CocheDTO("Volkswagen", "Golf", "5555EEEE", 60000, 2015, 12187, false));
        coches.add(new CocheDTO("Renault", "Clio", "6666FFF", 2000, 2005, 280900, false));
    }

    /**
     * Listado de clientes inciales
     */
    public void generarClientes(){
        clientes.add(new ClientesDTO("11111111A", "Pepe", "+34 986 337 777"));
        clientes.add(new ClientesDTO("22222222B", "Juana", "+34 986 333 333"));

    }

    public ConcessContr(SimpleViewContr vista) {
        this.vista = vista;
    }

}

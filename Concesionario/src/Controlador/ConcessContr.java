package Controlador;

import Modelo.*;

import View.SimpleViewContr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ConcessContr {

    private SimpleViewContr vista;

    private List<CocheDTO> coches = new ArrayList<>();
    private List<ClientesDTO> clientes = new ArrayList<>();
    private List<VentasDTO> ventas = new ArrayList<>();


    public void run(){
        while(true){
            TOpcionesMenu op = vista.mostrarMenu();
            //try catch
            if(op == TOpcionesMenu.ADD){
                anadirCoche();
            }

            if(op == TOpcionesMenu.SHOW){
                mostrarCoches();
            }

            if(op == TOpcionesMenu.SEARCH){
                //submenu SEARCH
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
    public void anadirCoche(){
        CocheDTO coche = new CocheDTO(vista.pedirMarca(), vista.pedirModelo(), vista.pedirMatricula(), vista.pedirPrecio(), vista.pedirAnho(), vista.pedirKilometros(), false);
        coches.add(coche);
        vista.mostrarMensaje(coche + "añadido" ); //muestra un codigo raro
    }

    public void mostrarCoches(){
        ArrayList<CocheDTO> cochesNoVendidos = new ArrayList<>();
        for(CocheDTO c : coches){
            if(!c.isVendido()){
                cochesNoVendidos.add(c);
            }
        }
        vista.mostrarCoches(cochesNoVendidos);
    }

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

    public void registarCliente(){
        String dni = vista.pedirDni();
        boolean clienteRepetido = false;

        for (ClientesDTO c : clientes) {
            if(c.getDni().equals(dni)){
                vista.clienteRepetido("cliente repetido"); //no funciona
                clienteRepetido = true;
            }
        }
        if(!clienteRepetido){
            ClientesDTO cliente = new ClientesDTO(dni, vista.pedirNombre(), vista.pedirTelefono());
            clientes.add(cliente);
            vista.mostrarMensaje(cliente +  "añadido" );
        }
    }

    private ClientesDTO buscarCliente(String dni){
        for(ClientesDTO c : clientes){
            if(c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }

    public void registrarVenta() {
        String dni = vista.pedirDni();
        ClientesDTO cliente = buscarCliente(dni);

        if (cliente == null) {
            vista.mostrarMensaje("El cliente no existe, necesitamos crearlo");
            cliente = new ClientesDTO(dni, vista.pedirNombre(), vista.pedirTelefono());
            clientes.add(cliente);
        }

        mostrarCoches();
        String matricula = vista.mostrarCoches();

        CocheDTO coche = null;
        for (CocheDTO c : coches) {
            if (c.getMatricula().equals(matricula) && !coche.isVendido()) {
                coche = c;
                break;
            }
        }
        if(coche == null){
            vista.mostrarMensaje("Lo sentimos, coche no encontrado y/o vendido");
        }

        int idVenta = ventas.size() + 1;

        VentasDTO venta = new VentasDTO(coche, cliente, idVenta);
        coche.setVendido(true);
        ventas.add(venta);

        vista.mostrarMensaje("Venta registrada con éxito!" + cliente.getNombre() + coche.getMatricula());

    }

    public void listarVentas() {

        if (ventas.isEmpty()){
            vista.mostrarMensaje("No se registraron ventas aún");
        return;
    }
        vista.mostrarVentas(ventas);

    }

    //coches iniciales
    public void generarCoches(){
        coches.add(new CocheDTO("Ford", "Focus", "1111AAA", 10000, 2015, 12187, false));
        coches.add(new CocheDTO("Audi", "A3", "2222BBB", 30000, 2010, 10000, false));
        coches.add(new CocheDTO("Toyota", "Celica", "3333CCC", 40000, 1990, 200899, false));
        coches.add(new CocheDTO("Seat", "Ibiza", "4444DDD", 20000, 2025, 1000, false));
        coches.add(new CocheDTO("Volkswagen", "Golf", "5555EEEE", 60000, 2015, 12187, false));
        coches.add(new CocheDTO("Renault", "Clio", "6666FFF", 2000, 2005, 280900, false));
    }

    //clientes iniciales
    public void generarClientes(){
        clientes.add(new ClientesDTO("11111111A", "Pepe", "+34 986 337 777"));
        clientes.add(new ClientesDTO("22222222B", "Juana", "+34 986 333 333"));

    }


    public ConcessContr(SimpleViewContr vista) {
        this.vista = vista;
    }

}

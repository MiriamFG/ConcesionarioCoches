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
                //submenu SEARCH
                TOpcionesSearchMenu opc = vista.mostrarMenuBusqueda();
                if(opc == TOpcionesSearchMenu.BY_BRAND){

                }

                if(opc == TOpcionesSearchMenu.BY_PRICE){

                }

                if(opc == TOpcionesSearchMenu.BY_YEAR){

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
        vista.mostrarMensaje(coche +  "añadido" );
    }

    public void mostrarCoches(){
        List<CocheDTO> cochesNoVendidos = new ArrayList<>();
        for(CocheDTO c : coches){
            if(!c.isVendido()){
                cochesNoVendidos.add(c);
            }
        }
        vista.mostrarCoches((ArrayList<CocheDTO>) cochesNoVendidos);
    }

    public void registarCliente(){
        String dni = vista.pedirDni();
        boolean clienteRepetido = false;

        for (ClientesDTO c : clientes) {
            if(c.equals(dni)){
                vista.clienteRepetido("cliente repetido");
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
        String matricula = vista.pedirMatricula();

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

        VentasDTO venta = new VentasDTO(cliente, coche);//por qué sale cliente en rojo?
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

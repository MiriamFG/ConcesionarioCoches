package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import View.SimpleViewContr;

import java.util.ArrayList;
import java.util.List;

public class ConcessContr {

    private SimpleViewContr vista;

    private List<CocheDTO> coches = new ArrayList<>();
    private List<ClientesDTO> clientes = new ArrayList<>();


    public void run(){

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

    public void registrarVenta(){
        registarCliente();
        mostrarCoches();


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

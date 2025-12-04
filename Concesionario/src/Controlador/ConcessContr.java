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




    public void run(){

        int userImput = vista.menu;
    }

    public void anadirCoche(String marca, String modelo, String matricula, double precio, int anho, int kilometros){
        CocheDTO coche = new CocheDTO(vista.pedirMarca(), vista.pedirModelo(), vista.pedirMatricula(), vista.pedirPrecio(), vista.pedirAnho(), vista.pedirKilometros());
        coches.add(coche);
        vista.mostrarMensaje("Coche añadido");
    }

    public void mostrarCoches(){

        vista.mostrarCoches(this.coches);
    }


    //coches iniciales
    public void generarCoches(){
        coches.add(new CocheDTO("Ford", "Focus", "1111AAA", 10000, 2015, 12187));
        coches.add(new CocheDTO("Audi", "A3", "2222BBB", 30000, 2010, 10000));
        coches.add(new CocheDTO("Toyota", "Celica", "3333CCC", 40000, 1990, 200899));
        coches.add(new CocheDTO("Seat", "Ibiza", "4444DDD", 20000, 2025, 1000));
        coches.add(new CocheDTO("Volkswagen", "Golf", "5555EEEE", 60000, 2015, 12187));
        coches.add(new CocheDTO("Renault", "Clio", "6666FFF", 2000, 2005, 280900));
    }


    public ConcessContr(SimpleViewContr vista) {
        this.vista = vista;
    }


}

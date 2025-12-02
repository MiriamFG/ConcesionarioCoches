package Controlador;

import Modelo.ClientesDTO;
import Modelo.CocheDTO;
import Modelo.VentasDTO;

import View.SimpleViewContr;

import java.util.ArrayList;
import java.util.List;

public class ConcessContr {

    private List<CocheDTO> coches = new ArrayList<>();

    public void anadirCoche(String marca, String modelo, String matricula, double precio, int anho, int kilometros){
        CocheDTO coche = new CocheDTO(kilometros, anho, precio, matricula, modelo, marca);
        coches.add(coche);
    }

    SimpleViewContr.mostrarMensaje("Coche añadido");

    public List<CocheDTO> getCoches(){
        return coches;
    }

    //coches iniciales
    coches.add(newCocheDTO("Ford", "Focus", "1111AAA", 10000, 2015, 12187));
    coches.add(newCocheDTO("Audi", "A3", "2222BBB", 30000, 2010, 10000));
    coches.add(newCocheDTO("Toyota", "Celica", "3333CCC", 40000, 1990, 200899));
    coches.add(newCocheDTO("Seat", "Ibiza", "4444DDD", 20000, 2025, 1000));
    coches.add(newCocheDTO("Volkswagen", "Golf", "5555EEEE", 60000, 2015, 12187));
    coches.add(newCocheDTO("Renault", "Clio", "6666FFF", 2000, 2005, 280900));

}

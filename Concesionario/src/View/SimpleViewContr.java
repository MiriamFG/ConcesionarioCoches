package View;

import Controlador.ConcessContr;
import Modelo.VentasDTO;
import Modelo.ClientesDTO;
import Modelo.CocheDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleViewContr {

    static Scanner sc = new Scanner(System.in);




    public void mostrarMensaje (String msg){
        System.out.println(msg);
    }



    //añadir Coche
    public String pedirMarca(){
        System.out.println("Qué marca quieres añadir");
        String marca = sc.nextLine();
        return marca;
    }

    public String pedirModelo() {
        System.out.println("Qué modelo quieres añadir");
        String modelo = sc.nextLine();
        return modelo;
    }

    public String pedirMatricula() {
        System.out.println("Qué matricula quieres añadir");
        String matricula = sc.nextLine();
        return matricula;
    }

    public double pedirPrecio() {
        System.out.println("Qué precio tiene");
        double precio = sc.nextDouble();
        sc.nextLine();
        return precio;
    }


    public int pedirAnho() {
        System.out.println("De qué año es el coche");
        int anho = sc.nextInt();
        return anho;
    }

    public int pedirKilometros() {
        System.out.println("Cuantos kilómetros tiene");
        int km = sc.nextInt();
        return km;
    }
    
    
    public void mostrarCoches(ArrayList<CocheDTO> coches){
        for (CocheDTO car : coches) {
            System.out.println(coches);
            
        }
    }
    
}

package View;

import Modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleViewContr {

    static Scanner sc = new Scanner(System.in);

    //Mostrar menú

    public TOpcionesMenu mostrarMenu(){

        TOpcionesMenu[] opciones =TOpcionesMenu.values();

        for (TOpcionesMenu opcion : opciones) {
            System.out.println(opcion.getOpInt() + ". " + opcion.getOpText());
        }

        int opUsuario;
        while (true){
        opUsuario = sc.nextInt();
        sc.nextLine();
            for (TOpcionesMenu opcion : opciones) {
                if (opcion.getOpInt() == opUsuario)
                    return opcion;
            }
                System.err.println("Opcion Incorrecta");
        }
    }

    public TOpcionesSearchMenu mostrarMenuBusqueda(){
        TOpcionesSearchMenu[] opcionesSearch = TOpcionesSearchMenu.values();

        for(TOpcionesSearchMenu op : opcionesSearch){
            System.out.println(op.getOpInt() + "." + op.getOpString());
        }

        int opUsuario;
        while (true){
            opUsuario = sc.nextInt();
            sc.nextLine();
            if(opUsuario >= 1 && opUsuario <= opcionesSearch.length){
                return opcionesSearch[opUsuario - 1];
            }
            System.err.println("Opcion Incorrecta");
        }

    }


    //Registar Cliente
    public String pedirDni(){
        System.out.println("Cuál es el dni del cliente?");
        String dni = sc.nextLine();
        return dni;
    }

    public String pedirNombre(){
        System.out.println("Cómo se llama el cliente?");
        String nombre = sc.nextLine();
        return nombre;
    }

    public String pedirTelefono(){
        System.out.println("Como es el teléfono del cliente");
        String telf = sc.nextLine();
        return telf;
    }



    //Mensajes añadir
    public void mostrarMensaje (String msg){
        System.out.println(msg);
    }

    //Mensaje error
    public void clienteRepetido(String msg) {
        System.err.println(msg);    }



    //añadir Coche
    public String pedirMarca(){
        System.out.println("Qué marca quieres añadir?");
        String marca = sc.nextLine();
        return marca;
    }

    public String pedirModelo() {
        System.out.println("Qué modelo quieres añadir?");
        String modelo = sc.nextLine();
        return modelo;
    }

    public String pedirMatricula() {
        System.out.println("Qué matricula quieres añadir?");
        String matricula = sc.nextLine();
        return matricula;
    }

    public double pedirPrecio() {
        System.out.println("Qué precio tiene?");
        double precio = sc.nextDouble();
        sc.nextLine();
        return precio;
    }


    public int pedirAnho() {
        System.out.println("De qué año es el coche?");
        int anho = sc.nextInt();
        return anho;
    }

    public int pedirKilometros() {
        System.out.println("Cuantos kilómetros tiene?");
        int km = sc.nextInt();
        return km;
    }
    
    
    public void mostrarCoches(ArrayList<CocheDTO> coches){
        for (int i = 0; i < coches.size(); i++) {
            System.out.println((i + 1) + coches.get(i).toString());
        }


    }

    public void exit() {
        mostrarMensaje("Muchas gracias por tu visita, hasta la próxima");
    }

    public int pedirBuscarAnho(){
        System.out.println("Por qué año quieres buscar?");
        int year = sc.nextInt();
        return year;
    }

    public String pedirBuscarMarca(){
        System.out.println("Por qué marca quieres buscar?");
        String marca = sc.nextLine();
        return marca;
    }

    public double pedirbuscarMinPrecio() {
        System.out.println("Introduce el precio mínimo");
        double min = sc.nextDouble();
        return min;
    }

    public double pedirbuscarMaxPrecio(){
        System.out.println("Introduce el precio máximo");
        double max = sc.nextDouble();
        return max;
    }

    public void mostrarVentas(List<VentasDTO> ventas) {
        System.out.println("========= VENTAS =======");
        for(VentasDTO v : ventas){
            System.out.println(
                    "Cliente" + v.getCliente().getNombre() + "(" + v.getCliente().getDni() + "(" +
                    "Coche" + v.getCoche().getMatricula() + "(" + v.getCoche().getModelo() + "(" + v.getCoche().getMarca() + "("
            );
        }
    }
}

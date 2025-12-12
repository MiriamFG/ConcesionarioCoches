package View;

import Modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleViewContr {

    static Scanner sc = new Scanner(System.in);

    //Mostrar menú

    /**
     * Muestra las opciones principales del menú
     * @return opciones de Búsqueda
     */
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

    /**
     * Muestra las opciones del submenú del apartado 3 del menú principal
     * @return opciones busqueda
     */
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


    /**
     * Pide el DNI al cliente
     * @return dni
     */
    public String pedirDni(){
        System.out.println("Cuál es el dni del cliente?");
        String dni = sc.nextLine();
        return dni;
    }

    /**
     * Pide el nombre al usuario
     * @return nombre
     */
    public String pedirNombre(){
        System.out.println("Cómo se llama el cliente?");
        String nombre = sc.nextLine();
        return nombre;
    }

    /**
     * Pide el teléfono al usuario
     * @return telefono
     */
    public String pedirTelefono(){
        System.out.println("Como es el teléfono del cliente");
        String telf = sc.nextLine();
        return telf;
    }

    /**
     * Muestra mensajes al usuario
     * @param msg
     */
    public void mostrarMensaje (String msg){
        System.out.println(msg);
    }

    /**
     * Muestra mensajes de error al usuario
     * @param msg
     */
    public void errorMensaje(String msg) {
        System.err.println(msg);    }


    /**
     * Pide una marca al usuario
     * @return marca
     */
    public String pedirMarca(){
        System.out.println("Qué marca quieres añadir?");
        String marca = sc.nextLine();
        return marca;
    }

    /**
     * pide un modelo al usuario
     * @return modelo
     */
    public String pedirModelo() {
        System.out.println("Qué modelo quieres añadir?");
        String modelo = sc.nextLine();
        return modelo;
    }

    /**
     * pide una matricula al usuario
     * @return matricula
     */
    public String pedirMatricula() {
        System.out.println("Qué matricula quieres añadir?");
        String matricula = sc.nextLine();
        return matricula;
    }

    /**
     * pide un precio al usuario
     * @return precio
     */
    public double pedirPrecio() {
        System.out.println("Qué precio tiene?");
        double precio = sc.nextDouble();
        sc.nextLine();
        return precio;
    }

    /**
     * pide un año al usuario
     * @return precio
     */
    public int pedirAnho() {
        System.out.println("De qué año es el coche?");
        int anho = sc.nextInt();
        return anho;
    }

    /**
     * pide kilómetros al usuario
     * @return kilómetros
     */
    public int pedirKilometros() {
        System.out.println("Cuantos kilómetros tiene?");
        int km = sc.nextInt();
        return km;
    }

    /**
     * muestra los coches no vendidos
     * @param coches
     */
    public void mostrarCoches(ArrayList<CocheDTO> coches){
        for (int i = 0; i < coches.size(); i++) {
            System.out.println((i + 1) + coches.get(i).toString());
        }

    }

    /**
     * muestra un mensaje de despedida
     */
    public void exit() {
        System.out.println("================================================================================================");
        mostrarMensaje("Muchas gracias por tu visita, hasta la próxima");
        System.out.println("================================================================================================");

    }

    /**
     * pide un año al usuario
     * @return año
     */
    public int pedirBuscarAnho(){
        System.out.println("Por qué año quieres buscar?");
        int year = sc.nextInt();
        return year;
    }

    /**
     * pide una marca al usuario
     * @return marca
     */
    public String pedirBuscarMarca(){
        System.out.println("Por qué marca quieres buscar?");
        String marca = sc.nextLine();
        return marca;
    }

    /**
     * pide un precio minimo al usuario
     * @return precio minimo
     */
    public double pedirbuscarMinPrecio() {
        System.out.println("Introduce el precio mínimo");
        double min = sc.nextDouble();
        return min;
    }

    /**
     * pide un precio máximo al usuario
     * @return precio máximo
     */
    public double pedirbuscarMaxPrecio(){
        System.out.println("Introduce el precio máximo");
        double max = sc.nextDouble();
        return max;
    }

    /**
     * muestra las ventas
     * @param ventas
     */
    public void mostrarVentas(List<VentasDTO> ventas) {
        System.out.println("================================================ VENTAS =====================================================");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        for(VentasDTO v : ventas){
            System.out.println(v);
            System.out.println("=============================================================================================================");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
    }
    /**
     * pide al usuario seleccionar un coche
     */
    public int selecCoche() {
        System.out.println("Selecciona un coche");
        int c = sc.nextInt();
        sc.nextLine();
        return c;
    }
}

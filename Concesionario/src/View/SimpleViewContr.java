package View;

import Controlador.ConcessContr;
import Modelo.VentasDTO;
import Modelo.ClientesDTO;
import Modelo.CocheDTO;

public class SimpleViewContr {

    public void mostrarMensaje (String msg){
        System.out.println(msg);
    }

    public void pedirDatosCoche(ConcessContr controlador{
        Scanner sc = new Scanner(System.in);

        System.out.println("Qué marca quieres añadir");
        String marca = sc.nextLine();



    }

}

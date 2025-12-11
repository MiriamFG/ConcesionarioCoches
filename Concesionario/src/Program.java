import Controlador.ConcessContr;
import View.SimpleViewContr;

public class Program {

    public static void main(String[] args) {

        SimpleViewContr vista = new SimpleViewContr();
        ConcessContr concessContr = new ConcessContr(vista);

        concessContr.generarCoches();
        concessContr.generarClientes();

        concessContr.run();





    }
}

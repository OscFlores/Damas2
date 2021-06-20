package R2.Principal;
import java.util.*;
public class IngresarDatos {
    Scanner C = new Scanner(System.in);
    public IngresarDatos(){

    }
    public int ingresarEnteros(String mensajeDesplegar){
        System.out.print(mensajeDesplegar + " ");
        int number =  C.nextInt();
        return number;
    }
    public String ingresarString(String mensajeDesplegar){
        System.out.print(mensajeDesplegar + " ");
        String dato = C.next();
        return dato;
    }
}

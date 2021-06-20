package R2.Principal;
import java.util.*;
public class Principal{
    Scanner sn = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Principal e = new Principal();
        e.Menu();
    }
    ////////
    public void Menu(){
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        //Se presenta un menu grafico con opciones para el usuario
         while (!salir) {
             System.out.println("\n Bienvenido a las Damas \n");
             System.out.println("1) Jugar");
             System.out.println("2) Ingresar Jugadores");
             System.out.println("3) Informacion de Jugadores");
             System.out.println("4) Tablero");
             System.out.println("5) Salir");
             try {
                 System.out.println("Escribe una de las opciones");
                 opcion = sn.nextInt();
                 switch (opcion) {
                     case 1:
                        
                         break;
                     case 2:
                          
                         break;
                     case 3:
                         
                         break;
                     case 4:
                       
                         break;
                     case 5:
                         salir = true;
                         break;
                     default:
                         System.out.println("Esa opcion no existe");
                 }
             } catch (InputMismatchException e) {
                 System.out.println("Debes insertar un número");
                 sn.next();
                 sn.close();
             }
         }
    }
}
package R2.Manejadores;
import R2.Jugador.*;
import java.util.*;
public class ManejadorInicio {
    private int idP1,idP2;
    Scanner sn = new Scanner(System.in);
    private ManejadorJugadores sJugadores; 
    private ManejadorTablero sTablero;
    Random rand = new Random();
    public ManejadorInicio(Jugador[] Jugador) {
        this.sJugadores = new ManejadorJugadores(Jugador);
    }
    ///////////////////////////////
    public void Juego(){
            IniciarJuego();
    }
    //////////////////////////////
    public void IniciarJuego(){
        boolean tmp =sJugadores.Verificar(); 
        if(tmp) {
            for(int i=0; i<2;i++){
                if(i==0){
                    idP1=sJugadores.SeleccionasJugadoresid(i);
                    System.out.println("Jugador: "+idP1);

                }else{
                    idP2=sJugadores.SeleccionasJugadoresid(i); 
                    System.out.println("Jugador "+idP2);
                }
            }
        }else{
            System.out.println("Añade mas Jugadores\n\n");
        }
        if(tmp) {
            sTablero = new ManejadorTablero();
            int id = PPT(idP1,idP2);
            enJuego(id);
        } 
    }
    //////////////////////////////////
    public int Cambio(int Jugador){
        if(Jugador == idP1){
            return idP2;
        }else{
            return idP1;
        }
    }
    ///////////////////////////////////
    public void ImprimirPosicion(int id){ 
        boolean tmp = true;
        boolean sJugador1= true;
        do{
            if(id == idP1){
                System.out.println("Turno Jugador : 1 (Amarillo)");
                sJugador1 = true;
            }else if(id == idP2){
                System.out.println("Turno Jugador : 2 (Verde)");
                sJugador1 = false;
            }
            tmp= sTablero.Posicion(sJugador1);
            id=Cambio(id);
        }while(tmp);
        if(sTablero.FichaJ2()==0){ 
            sJugadores.RestarPunteo(idP2-1);
            sJugadores.AnadirPunteo(idP1-1);
        }else{
            sJugadores.RestarPunteo(idP1-1);
            sJugadores.AnadirPunteo(idP2-1);
        }
        System.out.println("Juego Terminado");
    }
     /////////////////////////////////////
    public void enJuego(int id){
        ImprimirPosicion(id);
    }
    ////////////////////////////////////////
    public int PPT(int idP1, int idP2){
        int id=idP1;
        System.out.println("Iniciando Aleatorio");
        System.out.println("Piedra vs Papel vs Tijeras");
        String []game = {"Piedra","Papel","Tijeras"}; 
        String p1="";
        String p2="";
        boolean exit = false;
        while(!exit){
            for(int i = 0; i <2;i++){
                int option =rand.nextInt(3);
                if(i==0){
                    p1=game[option];
                }else{
                    p2=game[option];
                }
            }
            System.out.println("Jugador 1: "+p1);
            System.out.println("Jugador 2: "+p2);
            if(p1.equals("Piedra")&&p2.equals("Tijeras")  ||  p1.equals("Tijeras")&&p2.equals("Piedra") ){
                if(p1.equals("Piedra")){
                    id= idP1;
                }else if(p1.equals("Tijeras")){
                    id= idP2;
                }
                System.out.println("l1"+id);
                exit = true;
            }
            else if(p1.equals("Papel")&&p2.equals("Tijeras")  ||  p1.equals("Tijeras")&&p2.equals("Papel")){
                if(p1.equals("Tijeras")){
                    id= idP1;
                }else if(p1.equals("Papel")){
                    id= idP2;
                exit = true;
                System.out.println("l2"+id);

                }
            }
            else if(p1.equals("Piedra")&&p2.equals("Papel")  ||  p1.equals("Papel")&&p2.equals("Piedra")){
                if(p1.equals("Papel")){
                    id= idP1;
                }else if (p1.equals("Piedra")){
                    id= idP2;
                }
                exit = true;
                System.out.println("l2"+id);

            }
        }
        if(id==idP1){
            System.out.println("Gana Jugador 1");

        }else{
            System.out.println("Gana Jugador 2");

        }
        return id;
    }
    ///////////////////////////////////////////////////////
}

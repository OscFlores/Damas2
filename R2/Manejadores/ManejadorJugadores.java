package R2.Manejadores;
import R2.Jugador.Jugador;
import java.util.*;
public class ManejadorJugadores {
    private Jugador[] p;
    Scanner sn = new Scanner(System.in);

    public ManejadorJugadores(Jugador[] Jugadores){
        this.p = Jugadores;
    }
    //////////////////////////////
    public boolean MasJugadores() {
        int count = MostrarJugadores();
        if(count>=2){    
            return true;
        }else{
            System.out.println("Ingresa mas Jugadores");
            return false;
        }   
    }
    ////////////////////////////////////
    public int MostrarJugadores(){
        int count = 0;
        for(int i = 0; i <p.length; i++){
            if(p[i]!=null){

                p[i].datosJugador();
                count++;
            }else{
                break;
            }
        }return count;
    }
    ////////////////////////////////////
    private int getEntero(String message){
        System.out.println(message);
        int tmp = sn.nextInt();
        sn.nextLine();
        return tmp;
    }
    ////////////////////////////////
    public boolean Verificar(){
        int count = 0;
        for(int i = 0; i <p.length; i++){
            if(p[i]!=null){
                count++;
            }
        }
        if(count>=2){
            return true;
        }else{
            return false;
        }
    }
    ///////////////////////////////////-
    private int VerificarId(int id){
        do{
            if(p[id-1].getid()!=0){ 
                break;
            }
        }while(id==0);
        
        return id;
        
    }
    ////////////////////////////////////////
    public int SeleccionasJugadoresid(int i){
        return  VerificarId(getEntero("Ingrese # Jugador"+(1+i)+" (id): ")); 
    }
    ///////////////////////////////////////////////////////
    public void AnadirPunteo(int id){
        p[id].setPartidasGanadas((p[id].getPartidasGanadas()+1));
        System.out.println("Gano "+p[id].getNombreJugador()+" id:" +p[id].getid());
    }
    ////////////////////////////////////////////
    public void RestarPunteo(int id){
        p[id].setPartidasPerdidas((p[id].getPartidasPerdidas()+1));
        System.out.println("Perdio "+p[id].getNombreJugador()+" id:"  +p[id].getid());
    }   
}

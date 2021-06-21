package R2.Manejadores;
import R2.Tablero.*;
import java.util.*;
public class ManejadorTablero {
    Scanner sn = new Scanner(System.in);
    Tablero p = new Tablero();
    public ManejadorTablero(){
        p.ImprimirTablero();
    }
    /////////////////////////////////////////
    private int getEntero(String message){
        System.out.println(message);
        int tmp = sn.nextInt();
        sn.nextLine();
        return tmp;
    }
    /////////////////////////////////////////
    public boolean Posicion(boolean elJugador1) {
        boolean contin = true; 
        boolean tmp = true;
        do{
            System.out.println("\n\n");
            int x = getEntero("Selecciona #Fila: ");
            int y = getEntero("Selecciona #Columnna: "); 
            boolean op1 = verificarCelda(x,y);
            System.out.println(op1);
            int x1 = getEntero("Mover a #Fila: ");
            int y1 = getEntero("Mover a #Columna: "); 
            boolean op2 = verificarNuevaCelda(x1,y1);
            System.out.println(op1);
            if(op1==true && op2==true){
                if(Mover(x,y,x1,y1,elJugador1)){
                    if(FichaJ2()==0 || FichaJ1()==0){
                        contin = false;
                    }
                    p.ImprimirTablero(x,y,x1,y1);
                    System.out.println("Correcto");
                    tmp = false;
                }
            }else{
                p.ImprimirTablero();
                if(elJugador1){
                    System.out.println("Turno del Jugador : 1 (Fichas Amarillas)");
    
                }else{
                    System.out.println("Turno del Jugador : 2 (Fichas Verdes)");
                }
                System.out.println("Try again...");
            }
        }while(tmp);
        return contin;
    }
    ////////////////////////////////////////
    public boolean verificarCelda(int x,int y) {
        Celdas[][] tmp = p.getTablero();
        if(tmp[x][y].getBlanco()==false && tmp[x][y].getOcupado()==true){
            return true; 
        }else{
            return false; 
        }
    }
    /////////////////////////////////////////
    public boolean verificarNuevaCelda(int x1,int y1){
        Celdas[][] tmp = p.getTablero();
        if(tmp[x1][y1].getBlanco()==false && tmp[x1][y1].getOcupado()==false){
            return true; 
        }else{
            return false;
        }
    }
    /////////////////////////////////////////
    public boolean Mover(int x, int y, int x1,int y1,boolean sJugador1){ 
        Celdas[][] tmp = p.getTablero();
        int l1 = Math.abs(x-x1);
        int l2 = Math.abs(y-y1);
        System.out.println("l1: "+l1);
        System.out.println("l2: "+l2);
        if(l1==1 && l2==1 && sJugador1==tmp[x][y].getJugador1()){ 
            return true;
        }else if(l1==2 && l2==2 && sJugador1==tmp[x][y].getJugador1()){
            int posx = (x+x1)/2;
            int posy = (y+y1)/2;
            if(ComerFicha(posx,posy)){
                return true;
            }else{
                System.out.println("No puedes Mover la Ficha");
                System.out.println("Intenta de Nuevo");
                return false;
            }
        
        }else{
            System.out.println("No puedes Mover la Ficha");
            System.out.println("Intenta de Nuvo");
            return false;
        }
    }
    //////////////////////////////////////////////////////
    public boolean ComerFicha(int posx, int posy){
        Celdas[][] tmp = p.getTablero();
        if(tmp[posx][posy].getOcupado() && tmp[posx][posy].getBlanco()==false){
            tmp[posx][posy].setOcupado(false);
            return true;

        }else{
            return false;
        }
    }
    ///////////////////////////////////////////////////////
    public int FichaJ2(){
        int countG =0;
        Celdas[][] tmp = p.getTablero();
        for(int i = 0; i < tmp.length;i++){
            for(int j = 0; j<tmp.length;j++){
                if(tmp[i][j].getOcupado() && tmp[i][j].getJugador1()==false){ 
                    countG++;
                }
            }

        }
        System.out.println("Fichas Verdes: " + countG);
        return countG;
    }
    ///////////////////////////////////////////////////////////
    public int FichaJ1(){
        int countG =0;
        Celdas[][] tmp = p.getTablero();
        for(int i = 0; i < tmp.length;i++){
            for(int j = 0; j<tmp.length;j++){
                if(tmp[i][j].getOcupado() && tmp[i][j].getJugador1()==true){ 
                    countG++;
                }
            }
        }
        System.out.println("Fichas Amarillas: " + countG);
        return countG;
    }
}

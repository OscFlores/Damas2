package R2.Jugador;
import R2.Principal.*;
public class Jugador {
    private int id;
    private int partidasGanadas = 0;
    private int partidasPerdidas = 0;
    private String nombreJugador;
    private IngresarDatos leerDatos = new IngresarDatos();
    private int contadorJugadores = 0;

    public Jugador(int id, int partidasGanadas, String nombreJugador, int partidasPerdidas){
        this.id = id;
        this.partidasGanadas = partidasGanadas;
        this.nombreJugador = nombreJugador;
        this.partidasPerdidas = partidasPerdidas;
    }
    public Jugador(){

    }
    
    /////////////////////////////////
    public String datosJugador(){
        String tmp = ("Jugador: " + nombreJugador + " Partidas Ganadas: " + partidasGanadas + " Partidas Perdidas: " + partidasPerdidas);
        return tmp;  
    }
    public void listadoJugadores(Jugador[] listadoJugadores){
        for (int i = 0; i < listadoJugadores.length; i++) {
            if (listadoJugadores[i]!=null) {
                System.out.println(listadoJugadores[i].datosJugador());
            }else{
                System.out.println("Espacio Disponible");
            }
        }
    }
    public void agregarJugador(Jugador[] listado){
        String nombreJugador = "";
        nombreJugador = leerDatos.ingresarString("Ingrese el nombre del Jugador");
        listado[contadorJugadores] =  new Jugador(0,0, nombreJugador, 0);
        contadorJugadores++;
    }
    ////////////////////////////////
    public int getid(){
        return id;
    }
    public void setid(int id){
         this.id = id;
    }
    public int getPartidasGanadas(){
        return partidasGanadas;
    }
    public int getPartidasPerdidas(){
        return partidasPerdidas;
    }
    public String getNombreJugador(){
        return nombreJugador;
    }
    public void setPartidasGanadas( int partidasGanadas){
        this.partidasGanadas = partidasGanadas;
    }
    public void setNombreJugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
    }
    public void setPartidasPerdidas(int partidasPerdidas){
        this.partidasPerdidas = partidasPerdidas;
    }
    /////////////////////////////////
}


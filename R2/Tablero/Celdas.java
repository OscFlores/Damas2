package R2.Tablero;

public class Celdas {
    private String Celda;
    private int idColor;
    private String[] Color = new String[9];
    private boolean EstaOcupado,esBlanco,Jugador1;
    private String r = Character.toString((char)177);
    public Celdas(int color, boolean EstaOcupado) {
        Color[0]="\u001B[0m";
        Color[1]="\u001B[30m"; //Negro
        Color[2]="\u001B[31m"; //Rojo
        Color[3]="\u001B[32m"; //Verde 
        Color[4]="\u001B[33m"; //Amarillo
        Color[5]="\u001B[34m"; //Azul
        Color[6]="\u001B[35m"; //Morado
        Color[7]="\u001B[36m"; //Cyan
        Color[8]="\u001B[37m";//Blanco
        this.idColor = color;
        this.Celda = r+r+r+r+r+r+r+r+r+r+r; 
        this.EstaOcupado = EstaOcupado;
        this.esBlanco = false;
        this.Jugador1 = true; 
    }
    public String getCelda() {
        return Color[idColor]+Celda+Color[0];
    }
    public void setCelda(String celda) {
        this.Celda = celda;
    }
    public String Color(int op) {   
        return Color[op]+Celda+Color[0];
    }
    public boolean getOcupado(){
        return EstaOcupado;
    }
    public void setOcupado(boolean Ocupado){
        this.EstaOcupado = Ocupado;
    }
    public boolean getBlanco(){
        return esBlanco;
    }
    public void setEsBlanco(boolean Blanco){
        this.esBlanco = Blanco;
    }
    public void ResetearCeldas(){
        this.Celda = r+r+r+r+r+r+r+r+r+r+r;
    }
    public void setJugador1(boolean status){
        this.Jugador1 = status;
    }
    public boolean getJugador1(){
        return this.Jugador1;
    }
    public void ImprimirCeldas(){
        for(int i=0; i<4;i++) {
            for(int j=0; j<10; j++){
                System.out.print(getCelda());
            }
            System.out.println("");
        }
    }
}

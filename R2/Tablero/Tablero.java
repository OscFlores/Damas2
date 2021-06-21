package R2.Tablero;

public class Tablero {
    private final int Filas=8;
    private final int Columnas=8;
    private Celdas[][] Tablero = new Celdas[Filas][Columnas];
    private final String c = Character.toString((char)178);
    private final String a = Character.toString((char)177);
    public Tablero() {
        CrearTablero();
    }
    public void CrearTablero() {
        System.out.println("\n\n");
        for (int i=0; i<Filas; i++) {  
            for (int j=0; j<Columnas; j++){ 
                if(i%2==0 && j%2==0){ 
                    if(i==0 || i==6 || i==2){ 
                        Tablero[i][j] = new Celdas(2,true); 
                        if(i == 0 || i== 2){ 
                            Tablero[i][j].setJugador1(false); 
                        }
                    }else{
                        Tablero[i][j] = new Celdas(2,false); 
                    }
                }else if(i%2!=0 && j%2!=0){ 
                    if(i==5 || i==1 || i==7){
                        Tablero[i][j] = new Celdas(2,true); 
                        if(i==1){
                            Tablero[i][j].setJugador1(false); 
                        }
                    }else{
                        Tablero[i][j] = new Celdas(2,false); 
                    }
                }else{ 
                    Tablero[i][j] = new Celdas(8,false); 
                    Tablero[i][j].setIsWhite(true);
                }
            }

        }
        
    }
    public void ImprimirTablero1(){
        for (int i=0; i<this.Filas; i++){
            for (int j=0; j<this.Columnas; j++){
                System.out.print(Tablero[i][j].getCelda());
            }
            System.out.println("");
        }
    }
    public void ImprimirTablero(){
        NumerodeColumnas();
        System.out.println("\n");
        for (int i=0; i<Filas; i++){ 
            for (int k=0; k<5; k++){  
                for (int j=0; j<Columnas; j++){ 
                        if(Tablero[i][j].getOcupado()){
                            CambiarFicha(i,j,k);
                        }
                        System.out.print(Tablero[i][j].getCelda());
                    }
                    if(k==2){
                        System.out.print("  "+i); 
                    }        
                    System.out.println("");
                }
            }
        NumerodeColumnas();
        System.out.println("\n\n");
    }
    public void printBoard(int x, int y, int x1,int y1){
        boolean tmp = true;
        if(!Tablero[x][y].getJugador1()){ //
            tmp = false;   
        }
        resetCell(x,y,false,tmp);  
        resetCell(x1,y1,true,tmp);
        NumerodeColumnas();
        System.out.println("\n");
        for (int i=0; i<Filas; i++){ 
            for (int k=0; k<5; k++){  
                for (int j=0; j<Columnas; j++){ 
                            CambiarFicha(x1,y1,k); 
                        if(Tablero[i][j].getOcupado()){ 
                            CambiarFicha(i,j,k);
                        }
                        System.out.print(Tablero[i][j].getCelda()); 
                    }
                    if(k==2){
                        System.out.print("  "+i); 
                    }        
                    System.out.println("");
                }
            }
        NumerodeColumnas();
        System.out.println("\n\n");
    }
    public void CambiarFicha(int x, int y, int k){
        String g ="\u001B[32m"; //green 
        String ye ="\u001B[33m"; //yellow
        String r ="\u001B[31m";//reset

        if(k==2){
            if(Tablero[x][y].getJugador1()){
                Tablero[x][y].setCelda(a+a+a+a+ye+c+c+c+r+a+a+a+a); 
            }else{
                Tablero[x][y].setCelda(a+a+a+a+g+c+c+c+r+a+a+a+a); 
            }
        }else{
            Tablero[x][y].resetCell();

        }
    }
    public Celdas[][] getTablero(){
        return Tablero;
    }
    public void setTablero(int x, int y, Celdas[][] Table){
        this.Tablero[x][y] = Table[x][y];
    }
    public void resetCell(int x, int y,boolean Ocupado,boolean option){
        Tablero[x][y].setOcupado(Ocupado);   
        Tablero[x][y].resetCell();
        Tablero[x][y].setJugador1(option);
    }
    public void NumerodeColumnas(){
        for (int i=0; i<Columnas; i++){
            System.out.print("     "+i+"     ");
        }
    } 
}

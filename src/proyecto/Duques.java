package proyecto;

public class Duques extends Piezas {

    String tipo1;

    public Duques() {
        super();
    }

    public Duques(String tipo, String tipo1) {
        super(tipo);
        this.tipo1 = tipo;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = "Duques";
    }

    
        

    

    public String[][] movimiento(String[][] matriz, int x, int y, int x2, int y2) {
        boolean direccion = true;
        int centinela = 0;
        if (x == x2 && y != y2) {
            //vertical
            direccion = false;
            for (int i = 0; i < y2; i++) {
                if (!matriz[x][i].contains(" ")||matriz[x][i].contains("x")) {
                    
                } else {
                    centinela = 1;
                }
            }
            if (centinela == 0) {
                matriz[x2][y2] = matriz[x][y];
                matriz[x][y] = " ";
                return matriz;
            } else {
                System.out.println("Hay algo obstruyendo el camino o camina diagonalmente");
            }
        } else if (y == y2 && x != x2) {
            //hori
            for (int i = 0; i < x2; i++) {
                if (!matriz[i][y].contains(" ")||matriz[i][y].contains("x")) {

                } else {
                    centinela = 1;
                }
            }
            if (centinela == 0) {
                matriz[x2][y2] = matriz[x][y];
                matriz[x][y] = " ";
                return matriz;
            } else {
                System.out.println("Hay algo obstruyendo el camino o no puede ir diagonalmente");
            }
        }
        return matriz;

    }

    @Override
    public String[][] comer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

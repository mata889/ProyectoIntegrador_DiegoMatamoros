
package proyecto;

public class Rebeldes extends Piezas {
    String tipo3;

    public Rebeldes() {
        super();
    }

    public Rebeldes(String tipo3, String tipo) {
        super(tipo);
        this.tipo3 = tipo3;
    }

    public String getTipo3() {
        return tipo3;
    }

    public void setTipo3(String tipo3) {
        this.tipo3 = tipo3;
    }

    @Override
    public String toString() {
        return "Rebeldes{" + "tipo3=" + tipo3 + '}';
    }

    @Override
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

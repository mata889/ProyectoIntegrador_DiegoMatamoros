package proyecto;

public class Rey extends Piezas {

    String tipo2;

    public Rey() {
        super();
    }

    public Rey(String tipo2, String tipo) {
        super(tipo);
        this.tipo2 = tipo2;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = "Rey";
    }

    @Override
    public String toString() {
        return "Rey{" + "tipo2=" + tipo2 + '}';
    }

    public String[][] movimiento(String[][] matriz, int x, int y, int x2, int y2) {
        boolean direccion = true;
        int centinela = 0;
        if (x == x2 && y != y2) {
            //vertical
            direccion = false;
            for (int i = y + 1; i < y2; i++) {
                if (matriz[x][i].contains("•") || matriz[x][i].contains("o") || matriz[x][i].contains("▫")) {
                    centinela = 1;
                } else {

                }
            }
            if (centinela == 0) {
                if (matriz[x2][y2].contains("x")) {
                    System.out.println("No se puede poner en las x");
                } else {
                    matriz[x2][y2] = matriz[x][y];
                    matriz[x][y] = " ";
                    return matriz;
                }
            } else {
                System.out.println("Hay algo obstruyendo el camino x");
            }
        } else if (y == y2 && x != x2) {
            //hori
            for (int i = x + 1; i < x2; i++) {
                if (matriz[i][y].contains("•") || matriz[i][y].contains("x") || matriz[i][y].contains("o") || matriz[i][y].contains("▫")) {
                    centinela = 1;
                } else {

                }
            }
            if (centinela == 0) {
               if (matriz[x2][y2].contains("x")) {
                    System.out.println("No se puede poner en las x");
                } else {
                    matriz[x2][y2] = matriz[x][y];
                    matriz[x][y] = " ";
                    return matriz;
                }
            } else {
                System.out.println("Hay algo obstruyendo el camino y");
            }
        }
        return matriz;
    }

    @Override
    public String[][] comer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

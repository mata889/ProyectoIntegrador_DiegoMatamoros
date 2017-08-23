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
            for (int i = 0; i < y2; i++) {
                if (!matriz[x][i].contains(" ")) {

                } else {
                    centinela = 1;
                }
            }
            if (centinela == 0) {
                matriz[x2][y2] = matriz[x][y];
                matriz[x][y] = " ";
                return matriz;
            } else {
                System.out.println("Hay algo obstruyendo el camino x");
            }
        } else if (y == y2 && x != x2) {
            //hori
            for (int i = 0; i < x2; i++) {
                if (!matriz[i][y].contains(" ")) {

                } else {
                    centinela = 1;
                }
            }
            if (centinela == 0) {
                matriz[x2][y2] = matriz[x][y];
                matriz[x][y] = " ";
                return matriz;
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

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
        if ((x >= 0 && x <= 18 && y >= 0 && y <= 18) && (x2 >= 0 && x2 <= 18 && y2 >= 0 && y2 <= 18)) {
            boolean direccion = true;
            int centinela = 0;
            if (x == x2 && y != y2) {
                //vertical
                direccion = false;
                for (int i = y + 1; i < y2; i++) {
                    if (matriz[x][i].contains("•") || matriz[x][i].contains("o")) {
                        centinela = 1;
                    } else {

                    }
                }
                if (centinela == 0) {

                    if (x2 >= 2 && x2 <= 16 && y2 >= 2 && y2 <= 16) {

                        matriz[x2][y2] = matriz[x][y];
                        matriz[x][y] = " ";
                        if (matriz[x2 + 1][y2].contains("•") && matriz[x2 + 2][y2].contains("o") || matriz[x2 + 2][y2].contains("▫")) {
                            matriz[x2 + 1][y2] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        }
                        if (matriz[x2 - 1][y2].contains("•") && matriz[x2 - 2][y2].contains("o") || matriz[x2 - 2][y2].contains("▫")) {
                            matriz[x2 - 1][y2] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        } else if (matriz[x2][y2 + 1].contains("•") && matriz[x2][y2 + 2].contains("o") || matriz[x2][y2 + 2].contains("▫")) {
                            matriz[x2][y2 + 1] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        } else if (matriz[x2][y2 - 1].contains("•") && matriz[x2][y2 - 2].contains("o") || matriz[x2][y2 - 2].contains("▫")) {
                            matriz[x2][y2 - 1] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        } else {
                            return matriz;
                        }
                    } else {
                        matriz[x2][y2] = matriz[x][y];
                        matriz[x][y] = " ";
                        return matriz;
                    }

                } else {
                    System.out.println("Hay algo obstruyendo el camino o camina diagonalmente");
                    return matriz;
                }
            } else if (y == y2 && x != x2) {
                //hori
                for (int i = x + 1; i < x2; i++) {
                    if (matriz[i][y].contains("•") || matriz[i][y].contains("o")||matriz[i][y].contains("X")) {
                        centinela = 1;
                    } else {

                    }
                }
                if (centinela == 0) {
                    if (x2 >= 2 && x2 <= 16 && y2 >= 2 && y2 <= 16) {
                        matriz[x2][y2] = matriz[x][y];
                        matriz[x][y] = " ";
                        if (matriz[x2 + 1][y2].contains("•") && matriz[x2 + 2][y2].contains("o") || matriz[x2 + 2][y2].contains("▫")) {
                            matriz[x2 + 1][y2] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        }
                        if (matriz[x2 - 1][y2].contains("•") && matriz[x2 - 2][y2].contains("o") || matriz[x2 - 2][y2].contains("▫")) {
                            matriz[x2 - 1][y2] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        } else if (matriz[x2][y2 + 1].contains("•") && matriz[x2][y2 + 2].contains("o") || matriz[x2][y2 + 2].contains("▫")) {
                            matriz[x2][y2 + 1] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        } else if (matriz[x2][y2 - 1].contains("•") && matriz[x2][y2 - 2].contains("o") || matriz[x2][y2 - 2].contains("▫")) {
                            matriz[x2][y2 - 1] = " ";
                            System.out.println("Ha capturado un rebelde!");
                            return matriz;
                        } else {
                            return matriz;
                        }
                    } else {
                        matriz[x2][y2] = matriz[x][y];
                        matriz[x][y] = " ";
                        return matriz;
                    }
                } else {
                    System.out.println("Hay algo obstruyendo el camino o no puede ir diagonalmente");
                    return matriz;
                }
            } else {
                System.out.println("Intento diagonalmente o intento moverse a una x");
                return matriz;
            }
        } else {
            System.out.println("\033[31mSE HA SALIDO DEL RANGO");
            return matriz;
        }

    }

    public boolean ganar(String[][] matriz, int x, int y, int x2, int y2) {
        try {
            
            if (matriz[x2][y2].contains(matriz[0][0]) || matriz[x2][y2].contains(matriz[0][1]) || matriz[x2][y2].contains(matriz[1][0]) ||
                    matriz[x2][y2].contains(matriz[1][1]) || matriz[x2][y2].contains(matriz[0][18]) || matriz[x2][y2].contains(matriz[0][17]) || 
                    matriz[x2][y2].contains(matriz[1][18]) || matriz[x2][y2].contains(matriz[1][17]) || matriz[x2][y2].contains(matriz[18][0]) || 
                    matriz[x2][y2].contains(matriz[18][1]) || matriz[x2][y2].contains(matriz[17][0]) || matriz[x2][y2].contains(matriz[17][2]) || 
                    matriz[x2][y2].contains(matriz[18][18]) || matriz[x2][y2].contains(matriz[18][17]) || matriz[x2][y2].contains(matriz[17][18]) ||
                    matriz[x2][y2].contains(matriz[17][17])) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Se ha salido del rango");
        } finally {
            return false;
        }

    }

}

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
        if ((x >= 0 && x <= 18 && y >= 0 && y <= 18) && (x2 >= 0 && x2 <= 18 && y2 >= 0 && y2 <= 18)) {
            boolean direccion = true;
            int centinela = 0;
            if (x == x2 && y != y2) {
                //vertical
                direccion = false;
                for (int i = y + 1; i <= y2; i++) {
                    if (matriz[x][i].contains("•") || matriz[x][i].contains("x") || matriz[x][i].contains("o") || matriz[x][i].contains("▫")||matriz[x][i].contains("X")) {
                        centinela = 1;
                    } else {

                    }
                }
                for (int i = y2 + 1; i <= y; i++) {
                    if (matriz[x][i].contains("•") || matriz[x][i].contains("x") || matriz[x][i].contains("o") || matriz[x][i].contains("▫")||matriz[x][i].contains("X")) {
                        centinela = 1;
                    } else {

                    }
                }
                if (centinela == 0) {
                    if (matriz[x2][y2].contains("x")) {
                        System.out.println("No se puede poner en las x");
                        return matriz;
                    } else {

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
                    }
                } else {
                    System.out.println("Hay algo obstruyendo el camino o camina horizontal");
                    return matriz;
                }
            } else if (y == y2 && x != x2) {
                //hori
                for (int i = x + 1; i <= x; i++) {
                    if (matriz[i][y].contains("•") || matriz[i][y].contains("x") || matriz[i][y].contains("o") || matriz[i][y].contains("▫")||matriz[i][y].contains("X")) {
                        centinela = 1;
                    } else {

                    }
                }
                for (int i = x + 1; i <= x2; i++) {
                    if (matriz[i][y].contains("•") || matriz[i][y].contains("x") || matriz[i][y].contains("o") || matriz[i][y].contains("▫")||matriz[i][y].contains("X")) {
                        centinela = 1;
                    } else {

                    }
                }
                if (centinela == 0) {
                    if (matriz[x2][y2].contains("x")) {
                        System.out.println("No se puede poner en las x");
                        return matriz;
                    } else {
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

                    }
                } else {
                    matriz[x2][y2] = matriz[x][y];
                    matriz[x][y] = " ";
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

}

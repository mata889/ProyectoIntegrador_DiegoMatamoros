package proyecto;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Proyecto {

    static Scanner sc = new Scanner(System.in);
    static String jugador1, jugador2;
    static String tablero[][] = new String[19][19];
    static String tableroFinal[][] = (ImprimeMatriz(Recursiva(tablero, 0, 0)));
    static Rey R = new Rey();
    static Duques D = new Duques();
    static Rebeldes ISoyRebelde = new Rebeldes();

    public static void main(String[] args) {
        int menu;
        boolean gano = false;
        char resp = 's';
        do {
            System.out.println("--------------Alea Evangelii---------");
            System.out.println("1.Jugar\n0.Salir");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Introduzca su nombre, jugador 1(Duques):");
                    jugador1 = sc.next();
                    System.out.println("Introduzca su nombre jugador 2(Rebeldes):");
                    jugador2 = sc.next();
                    JOptionPane.showMessageDialog(null, "Se ha añadido los jugadores");
                    //ImprimeMatriz2(tableroFinal);
                    do {
                        int x, y, x1, y1;

                        ImprimeMatriz2(tableroFinal);
                        System.out.println("Es su turno jugador 2(Rebeldes):" + jugador2 + "\nescoja una posicion X y Y");
                        System.out.println("su x:");
                        x = sc.nextInt();
                        System.out.println("su y:");
                        y = sc.nextInt();
                        System.out.println("Adonde la va a mover\nx:");
                        x1 = sc.nextInt();
                        System.out.println("y:");
                        y1 = sc.nextInt();
                        if (tablero[x][y].contains("•")) {

                            tableroFinal = ISoyRebelde.movimiento(tablero, x, y, x1, y1);
                            gano=ISoyRebelde.ganar(tableroFinal, x, y, x1, y1);
                            if (ISoyRebelde.ganar(tableroFinal, x, y, x1, y1) == true) {
                            JOptionPane.showMessageDialog(null, "GANO LOS DUQUES");
                            break;
                        }
                            

                        } else {
                            System.out.println("La pieza que intento mover no es de su equipo!\n");
                        }

                        ImprimeMatriz2(tableroFinal);
                        System.out.println("Es su turno jugador 1(Duques):" + jugador1 + "\nescoja una posicion X y Y");
                        System.out.println("su x:");
                        x = sc.nextInt();
                        System.out.println("su y:");
                        y = sc.nextInt();
                        System.out.println("Adonde la va a mover\nx:");
                        x1 = sc.nextInt();
                        System.out.println("y:");
                        y1 = sc.nextInt();
                        if (tablero[x][y].contains("o")) {

                            tableroFinal = D.movimiento(tablero, x, y, x1, y1);
                            resp = 's';
                        } else if (tablero[x][y].contains("▫")) {

                            tableroFinal = R.movimiento(tablero, x, y, x1, y1);
                            gano = R.ganar(tableroFinal, x, y, x1, y1);
                            if (R.ganar(tableroFinal, x, y, x1, y1)==true) {
                            JOptionPane.showMessageDialog(null,"Ganaron los dueques");
                            break;
                        }
                            
                            for (int i = 0; i < tableroFinal.length; i++) {
                                for (int j = 0; j < tableroFinal.length; j++) {
                                    if (i==9 && j==9) {
                                        if ( tableroFinal[i][j].contains(" ")) {
                                        tableroFinal[i][j]="X";
                                    }
                                    }
                                    
                                }
                            }

                            resp = 's';
                        } else {
                            System.out.println("La pieza que intento mover no es de su equipo!\n");
                        }
                        
                        
                        
                        
                    } while (gano != true);

                    break;
            }
        } while (menu != 0);
        System.out.println("ADIOS");

    }

    public static String[][] Recursiva(String y[][], int filas, int cola) {

        if (filas == y.length - 1 && cola == y.length - 1) {
            return y;
        } else {
            if (cola == y.length - 1) {
                return Recursiva(y, filas + 1, 0);
            } else {
                return Recursiva(y, filas, cola + 1);
            }
        }
    }

    public static void ImprimeMatriz2(String[][] x) {
        System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
        for (int i = 0; i < x.length; i++) {
            
            for (int j = 0; j < x[0].length; j++) {
                
                if (j == 0) {

                    if (i <= 9) {
                        System.out.print(" " + i);
                    } else {
                        System.out.print(i);
                    }
                }

                System.out.print("[" + x[i][j] + "]");

            }

            System.out.println(" ");

        }
    }

    public static String[][] ImprimeMatriz(String[][] x) {

        System.out.println(" ");
        for (int i = 0; i < x.length; i++) {

            for (int j = 0; j < x[0].length; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 0) || (i == 1 && j == 1) || (i == 0 && j == 17)
                        || (i == 0 && j == 18) || (i == 1 && j == 17) || (i == 1 && j == 18) || (i == 17 && j == 0) || (i == 17 && j == 1)
                        || (i == 18 && j == 0) || (i == 18 && j == 1) || (i == 17 && j == 17) || (i == 17 && j == 18) || (i == 18 && j == 18)
                        || (i == 18 && j == 17)) {
                    x[i][j] = "x";

                } else if ((i == 18 / 2 && j == 18 / 2)) {
                    x[i][j] = "▫";

                } else if ((i == 0 && j == 2) || (i == 0 && j == 5) || (i == 0 && j == 16) || (i == 0 && j == 13) || (i == 2 && j == 0) || (i == 2 && j == 5) || (i == 2 && j == 18) || (i == 2 && j == 13) || (i == 5 && j == 0)
                        || (i == 16 && j == 0) || (i == 13 && j == 0) || (i == 2 && j == 18) || (i == 5 && j == 18) || (i == 16 && j == 18) || (i == 13 && j == 18) || (i == 16 && j == 5) || (i == 16 && j == 13) || (i == 18 && j == 13)
                        || (i == 18 && j == 5) || (i == 18 && j == 16) || (i == 18 && j == 2) || (i == 13 && j == 16) || (i == 13 && j == 2) || (i == 5 && j == 16) || (i == 5 && j == 2) || (i == 3 && j == 9) || (i == 3 && j == 11)
                        || (i == 4 && j == 12) || (i == 5 && j == 13) || (i == 6 && j == 14) || (i == 7 && j == 15) || (i == 3 && j == 7) || (i == 4 && j == 6) || (i == 5 && j == 5) || (i == 6 && j == 4) || (i == 7 && j == 3)
                        || (i == 9 && j == 3) || (i == 11 && j == 3) || (i == 12 && j == 4) || (i == 13 && j == 5)
                        || (i == 14 && j == 6) || (i == 15 && j == 7) || (i == 15 && j == 9) || (i == 15 && j == 11)
                        || (i == 14 && j == 12) || (i == 13 && j == 13) || (i == 12 && j == 14) || (i == 11 && j == 15) || (i == 9 && j == 15)) {
                    x[i][j] = "•";

                    //•
                } else if ((i == 4 && j == 8) || (i == 4 && j == 10) || (i == 6 && j == 9) || (i == 7 && j == 8) || (i == 7 && j == 10) || (i == 8 && j == 7)
                        || (i == 8 && j == 11) || (i == 9 && j == 6) || (i == 9 && j == 12) || (i == 10 && j == 11) || (i == 10 && j == 7)
                        || (i == 11 && j == 8) || (i == 11 && j == 10) || (i == 12 && j == 9) || (i == 14 && j == 10) || (i == 14 && j == 8)
                        || (i == 8 && j == 4) || (i == 10 && j == 4) || (i == 8 && j == 14) || (i == 10 && j == 14) || (i == 8 && j == 4)
                        || (i == 9 && j == 8) || (i == 9 && j == 10) || (i == 10 && j == 9) || (i == 8 && j == 9)) {
                    x[i][j] = "o";

                } else {
                    x[i][j] = " ";

                }
            }

        }
        return x;
    }
}

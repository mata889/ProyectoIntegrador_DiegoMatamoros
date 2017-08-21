package proyecto;

public class Proyecto {

    public static void main(String[] args) {
        String tablero[][] = new String[19][19];
        ImprimeMatriz(Recursiva(tablero, 0, 0));

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

    public static void ImprimeMatriz(String[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 0) || (i == 1 && j == 1) || (i == 0 && j == 17)
                        || (i == 0 && j == 18) || (i == 1 && j == 17) || (i == 1 && j == 18) || (i == 17 && j == 0) || (i == 17 && j == 1)
                        || (i == 18 && j == 0) || (i == 18 && j == 1) || (i == 17 && j == 17) || (i == 17 && j == 18) || (i == 18 && j == 18)
                        || (i == 18 && j == 17) || (i == 18 / 2 && j == 18 / 2)) {
                    System.out.print("[x]");
                }else if ((i==0 && j==2)||(i==0 && j==5)||(i==0 && j==16)||(i==0 && j==13)||(i==2 && j==0)||(i==2 && j==5)||(i==2 && j==18)||(i==2 && j==13)||(i==5 && j==0)
                        ||(i==16 && j==0)||(i==13 && j==0)||(i==2 && j==18)||(i==5 && j==18)||(i==16 && j==18)||(i==13 && j==18)||(i==16 && j==5)||(i==16 && j==13)||(i==18 && j==13)
                        ||(i==18 && j==5)||(i==18 && j==16)||(i==18 && j==2)||(i==13 && j==16)||(i==13 && j==2)||(i==5 && j==16)||(i==5 && j==2)||(i==3 && j==9)||(i==3 && j==11)
                        ||(i==4 && j==12)||(i==5 && j==13)||(i==6 && j==14)||(i==7 && j==15)||(i==3 && j==7)||(i==4 && j==6)||(i==5 && j==5)||(i==6 && j==4)||(i==7 && j==3)
                        ||(i==9 && j==3)||(i==11 && j==3)||(i==12 && j==4)||(i==13 && j==5)
                        ||(i==14 && j==6)||(i==15 && j==7) ||(i==15 && j==9)||(i==15 && j==11)||(i==14 && j==12)||(i==13 && j==13)||(i==12 && j==14)||(i==11 && j==15)||(i==9 && j==15)) {
                    System.out.print("[•]");
                    //•
                }  else {
                    x[i][j] =" ";
                    System.out.print("[" + x[i][j] + "]");
                }
            }
            System.out.println(" ");
        }
    }
}

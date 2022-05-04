
import java.util.Scanner;

public class Cine {
    private boolean[][] cine = new boolean[8][9];
    //true representa que esta libre
    public Cine(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                cine[i][j]=true;
            }
        }
    }

    @Override
    public String toString() {
        String salida="";
        String caracter;
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 9; j++) {

                caracter = switch (j) {
                    case 0 -> "A";
                    case 1 -> "B";
                    case 2 -> "C";
                    case 3 -> "D";
                    case 4 -> "E";
                    case 5 -> "F";
                    case 6 -> "G";
                    case 7 -> "H";
                    case 8 -> "I";
                    default -> "error";
                };
                if (cine[i][j]){
                    salida = salida +(8-i)+""+caracter+" " ;
                }else{
                    salida = salida +"\u001B[31m" +(8-i)+""+caracter+" " + "\u001B[0m";
                }


            }
            salida =salida+"\n";
        }


        return salida;
    }

    public void ocupaVeinticinco() {
        for (int k = 0; k < 25; k++) {
            int i= (int) (Math.random()*8),j= (int) (Math.random()*9);
            while(!cine[i][j]){
                i= (int) (Math.random()*8);
                j= (int) (Math.random()*9);
            }
            cine[i][j]=false;
        }


    }

    public void ocupaParaUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ponga la butaca que desea");
        String butaca = sc.nextLine();
        int i =Integer.parseInt(String.valueOf(butaca.charAt(0))) , j;

        j = switch (butaca.charAt(1)) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F' -> 5;
            case 'G' -> 6;
            case 'H' -> 7;
            case 'I' -> 8;
            default -> 10;
        };
        if(j==10){
            System.out.println("Lo has puesto mal");
        }
        if(!cine[8-i][j]){
            System.out.println("Tio has cogido una que esta ocupada");
        }
        cine[8-i][j]=false;
        System.out.println(imprimeSeleccion(8-i,j));

    }

    private String imprimeSeleccion(int k, int p) {
        String salida="";
        String caracter;
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 9; j++) {

                caracter = switch (j) {
                    case 0 -> "A";
                    case 1 -> "B";
                    case 2 -> "C";
                    case 3 -> "D";
                    case 4 -> "E";
                    case 5 -> "F";
                    case 6 -> "G";
                    case 7 -> "H";
                    case 8 -> "I";
                    default -> "error";
                };
                if (cine[i][j]){
                    salida = salida +(8-i)+""+caracter+" " ;
                }else if (i==k&&j==p){
                    salida = salida +"\u001B[34m" +(8-i)+""+caracter+" " + "\u001B[0m";
                }else{
                    salida = salida +"\u001B[31m" +(8-i)+""+caracter+" " + "\u001B[0m";
                }


            }
            salida =salida+"\n";
        }
        return salida;
    }
}

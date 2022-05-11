package perceptron;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Perceptron {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rnd = new Random();
        
        //PESOS Y ENTRADAS
        double w[] = new double[3];
        w[0] = 0.6473185;
        w[1] = 0.37817776;
        w[2] = 0.33160055;
        System.out.println("PESOS: w0="+w[0]+", w1="+w[1]+", w2="+w[2]);
        double aprendizaje = 0.4;
        
        int filas = 4;
        int columnas = 3;
        int x[][] = new int[filas][columnas];
        
        //ENTRADAS
        x[0][0]=1;
        x[1][0]=1;
        x[2][0]=1;
        x[3][0]=1;
        
        x[0][1]=1;
        x[1][1]=1;
        x[2][1]=0;
        x[3][1]=0;
        
        x[0][2]=1;
        x[1][2]=0;
        x[2][2]=1;
        x[3][2]=0;
        
        int yd[] = new int[filas]; 
        
        //MOSTRANDO MATRIZ (TABLA)
        for (int i = 0; i < columnas; i++) {
                System.out.print("x["+i+"] |||  ");
            for (int j = 0; j < filas; j++) {
                System.out.print(x[j][i] + ", ");
            }
            System.out.println("");
        }
        
        //CALCULANDO RESULTADOS (YD)
        int filrev = 0;
        int uoc = 0; //Uno o cero
        int ydres = 0; //YD RESULTS
        do {
            for (int j = 0; j < columnas; j++) {
                if (x[filrev][j] == 0) {
                    uoc = 0;
                    j=columnas;
                }else{
                    uoc = 1;
                }
            }
            yd[filrev] = uoc;
            filrev++;
        } while (filrev < filas);
        
        // MOSTRANDO RESULTADOS YD
        System.out.print("yd   |||  ");
        for (int i = 0; i < yd.length; i++) {
            System.out.print(yd[i] + ", ");
        }
        System.out.println("");
        
        
        // 2DA MODIFICACIÓN (-1) EN X
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                if (x[j][i] == 0) {
                    x[j][i] = -1;
                }
            }
        }
        
        // 2DA MODIFICACIÓN (-1) EN YD
        for (int i = 0; i < yd.length; i++) {
            if (yd[i] == 0) {
                    yd[i] = -1;
                }
        }

        // MOSTRANDO RESULTADOS DESPUÉS DE SEGUNDA MODIFICACIÓN
        System.out.println("2DA MODIFICACIÓN (-1)");
        for (int i = 0; i < columnas; i++) {
                System.out.print("x["+i+"] |||  ");
            for (int j = 0; j < filas; j++) {
                System.out.print(x[j][i] + ", ");
            }
            System.out.println("");
        }
        System.out.print("yd   |||  ");
        for (int i = 0; i < yd.length; i++) {
            System.out.print(yd[i] + ", ");
        }
        System.out.println("");
        
        
        
        System.out.println("");System.out.println("");
        
        //ITERACIONES
        double y = 0;
        double aux = 0;
        double error = 0;
        do {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    aux = (w[j]*x[i][j]);
                    y = y + aux;

                }
                System.out.println("Iteración " + i + " = " + y);
                if (y >= 0) {
                    y = 1;
                    System.out.println("YD  " + yd[i]);
                    System.out.println("Y  " + y);
                    error = yd[i] - y;
                    if (error != 0) {
                        System.out.println("NUEVOS PESOS");
                        for (int k = 0; k < columnas; k++) {
                            System.out.println("W"+k+"PREVIO:  " + w[k]+" Y ERROR: "+error+" Y X: "+x[i][k]);
                            w[k] = w[k] + (aprendizaje * error * x[i][k]);
                            System.out.println("W"+k+":  " + w[k]);
                        }
                        i = filas;
                    }
                }else{
                    y=-1;
                    System.out.println("YD  " + yd[i]);
                    System.out.println("Y  " + y);
                    error = yd[i] - y;
                    if (error != 0) {
                        System.out.println("NUEVOS PESOS");
                        for (int k = 0; k < columnas; k++) {
                            System.out.println("W"+k+"PREVIO:  " + w[k]+" Y ERROR: "+error+" Y X: "+x[i][k]);
                            w[k] = w[k] + (aprendizaje * error * x[i][k]);
                            System.out.println("W"+k+":  " + w[k]);
                        }
                        i = filas;
                    }
                }
                y=0;
            }
        } while (error != 0);
        
    }
}

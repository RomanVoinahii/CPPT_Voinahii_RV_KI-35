import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        int nRows; //розмір квадоатної матриці
        char[][] arr; //матриця
        String filler; //символ заповнювач

        // команди для виводу та зчитування тексту з консолі та вивід у файл
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();

        arr = new char[nRows][];
        for (int i = 0; i < nRows; ++i) {
            arr[i] = new char[i + 1];
        }


        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        int counter;
        boolean run = true;
        // ініціалізація массиву заданого за моїм варіантом
        exit:
        for (int i = 0; i < nRows; i++) {
            counter = nRows - i;
            while (run) {
                System.out.print("  ");
                --counter;
                if (counter <= 0) {
                    run = false;
                }
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (filler.length() == 1) {
                    arr[i][j] = (char) filler.codePointBefore(1);
                    System.out.print(arr[i][j] + " ");
                } else if (filler.length() == 0) {
                    System.out.print("\nНе введенно символ заповнювач");
                    break exit;
                } else {
                    System.out.print("\nЗавеликий символ заповнювач");
                    break exit;
                }
            }
            System.out.print("\n");
            fout.print("\n");
            run = true;
        }

        fout.flush();
        fout.close();
    }
}

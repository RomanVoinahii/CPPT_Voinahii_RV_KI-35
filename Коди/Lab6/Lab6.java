import java.io.*;
import java.util.Scanner;

public class CalculateTheEquation implements CalculateTheEquationInterface, ReadWriteData {
    private double variable = 0;

    @Override
    public double doCalculation() {
        try {
            variable = Math.cos(variable) / ((variable) + 2*(Math.cos(variable)/Math.sin(variable)));


            return variable;
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception: illegal value.");
        }
        return 0;
    }

    @Override
    public void writeResultToTxt(String fileName) throws IOException {
        PrintWriter f = new PrintWriter(fileName);
        f.printf("%f ", variable);
        f.close();
    }

    @Override
    public void writeResultToBin(String fileName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fileName));
        f.writeDouble(variable);
        f.close();
    }

    @Override
    public void readResultFromTxt(String fileName) throws IOException {
        File f = new File (fileName);
        if (f.exists())
        {
            Scanner scanner = new Scanner(f);
            variable = scanner.nextDouble();
            scanner.close();
        }
        else
            throw new IOException("File " + fileName + "not found");
    }

    @Override
    public void readResultFromBin(String fileName) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fileName));
        variable = f.readDouble();
        f.close();
    }
}





import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadWriteData {
    void writeResultToTxt(String fileName) throws IOException;
    void writeResultToBin(String fileName) throws IOException;

    void readResultFromTxt(String fileName) throws IOException;
    void readResultFromBin(String fileName) throws IOException;
}



public interface CalculateTheEquationInterface {
    double doCalculation();
}



import java.io.IOException;

public class EquationsApp {
    public static void main(String[] args) {
        CalculateTheEquation calc = new CalculateTheEquation();
        try {
            calc.readResultFromBin("src/bin.bin");
            System.out.println("Result of calculation: " + calc.doCalculation());
            calc.writeResultToBin("src/bin.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            calc.readResultFromTxt("src/txt.txt");
            System.out.println("Result of calculation: " + calc.doCalculation());
            calc.writeResultToTxt("src/txt.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

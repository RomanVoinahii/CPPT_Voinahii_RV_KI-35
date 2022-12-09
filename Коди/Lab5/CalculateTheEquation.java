import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateTheEquation implements CalculateTheEquationInterface {
    @Override
    public double doCalculation(double variable) {
        try {
            return Math.cos(variable) / ((variable) + 2*(Math.cos(variable)/Math.sin(variable)));




        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception: illegal value.");
        }
        return 0;
    }

    @Override
    public double doCalculationWithInputInside() {
        try {
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Enter value: ");
            double value = inputScanner.nextDouble();
            inputScanner.nextLine();
            return Math.cos(value) / ((value) + 2*(Math.cos(value)/Math.sin(value)));
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception: illegal value.");
        }
        catch (InputMismatchException e){
            System.out.println("Input exception: illegal value.");
        }
        return 0;
    }
}

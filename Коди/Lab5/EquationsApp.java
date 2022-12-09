public class EquationsApp {
    public static void main(String[] args) {
        CalculateTheEquationInterface calc = new CalculateTheEquation();
        System.out.println("  y=cos(x)/(x+2ctg(x))  = " + calc.doCalculation(300));
        System.out.println("  y=cos(x)/(x+2ctg(x))   = " + calc.doCalculation(70));
        System.out.println("  y=cos(x)/(x+2ctg(x))   = " + calc.doCalculation(-4444));

        System.out.println("  y=cos(x)/(x+2ctg(x))  +   = " + calc.doCalculationWithInputInside());
    }
}

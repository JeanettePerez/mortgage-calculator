public class Main {

    public static void main(String[] args){
    int principal = (int) Console.readUserInputNumber("What is the amount of your Principal balance? ", 1_000, 1_000_000);
    float annualInterest = (float) Console.readUserInputNumber("What is your Annual Interest rate? ", 1, 30);
    byte years = (byte) Console.readUserInputNumber("What is your loan type in years? ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}

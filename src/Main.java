import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args){
    int principal = (int) readUserInputNumber("What is the amount of your Principal balance? ", 1_000, 1_000_000);
    float annualInterest = (float) readUserInputNumber("What is your Annual Interest rate? ", 1, 30);
    byte years = (byte) readUserInputNumber("What is your loan type in years? ", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);


    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("================");
        System.out.println("This is your payment schedule for a " + years + "-year " + "fixed loan ");
        for(short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = paymentScheduleCalculator(principal, annualInterest, years, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = mortgageCalculator(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE RESULTS");
        System.out.println("================");
        System.out.println("Your monthly payment will be: " + mortgageFormatted);
        System.out.println();
    }

    public static double readUserInputNumber(String prompt, double min, double max){
        Scanner sc = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = sc.nextDouble();
            if(value >= min && value <= max)
               break;
            System.out.println("Please enter value between " + min + " and " + max );
        }
            return value;
    }

    public static double mortgageCalculator(
            int principal,
            float annualInterest,
            byte years){

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);


    }

    public static double paymentScheduleCalculator(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade){

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }
}

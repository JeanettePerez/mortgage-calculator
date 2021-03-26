public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(int principle, float annualInterest, byte years) {
        this.principal = principle;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double mortgageCalculator(){
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = years * MONTHS_IN_YEAR;
        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }


    public double paymentScheduleCalculator(short numberOfPaymentsMade){
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for(short month = 1; month <= balances.length; month++)
            balances[month - 1] = paymentScheduleCalculator(month);

            return balances;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}

import java.util.Scanner;

public class Console {
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
}

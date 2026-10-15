import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    Scanner scan = new Scanner(System.in);

    public int promptNumeric(String msg){
        System.out.println(msg);
        int input = 0;
        try {
            input = scan.nextInt();
        }catch (InputMismatchException e){
            scan.nextLine();
            System.out.println("Skriv et tal");
            input = promptNumeric(msg);
        }
        return input;
    }
}
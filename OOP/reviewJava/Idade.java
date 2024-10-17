package revisaoJava;
import java.util.Scanner; 

public class Idade {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Entre com o seu nome: ");
        String name = keyboard.nextLine();

        System.out.print("Entre com o ano que nasceu: ");
        int bornYear = keyboard.nextInt();

        System.out.print("Entre com o ano atual: ");
        int actualYear = keyboard.nextInt();

        int actualAge = actualYear - bornYear;

        System.out.println(name + ", possui " + actualAge + " anos.");


        
        keyboard.close();
    }
}

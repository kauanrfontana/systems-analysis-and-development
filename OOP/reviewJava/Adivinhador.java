package revisaoJava;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner; 

public class Adivinhador {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Chute um número entre 1 a 100: ");
        int numberInserted = keyboard.nextInt();
        int drawn = random.nextInt(100) + 1;
        ArrayList<Integer> tried = new ArrayList<>();

        while (numberInserted != drawn){
            tried.add(numberInserted);

            if(tried.contains(numberInserted) && Collections.frequency(tried, numberInserted) > 1 ){
                int frequency = Collections.frequency(tried, numberInserted);
                System.out.println("Você já escolheu "+ frequency + " vezes o número " + numberInserted + ", tente outro número");
            }else{
                System.out.println("Tente outra vez!");
            }
            System.out.print("Chute um número novamente: ");
            numberInserted = keyboard.nextInt();
        };
        System.out.print("Parabéns!!! Você acertou, o número sorteado era " + drawn);




        






        
        keyboard.close();
    }
}

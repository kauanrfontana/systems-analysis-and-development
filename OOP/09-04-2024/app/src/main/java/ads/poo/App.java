package ads.poo;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> list = new Stack<>();
        int num;
        do{
            System.out.print("Digite outro número: ");
            num = scanner.nextInt();
            if(num != 999)list.add(num);
        } while(num != 999);

        while(!list.empty()) System.out.println(list.pop());
    }
}

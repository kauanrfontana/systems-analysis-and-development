package revisaoJava;

public class Media {
    public static void main(String[] args){
        if(args.length < 3){
            System.out.println("Por favor, passe todos os argumentos necessários!");
            return;
        }
        Float firstProject = Float.parseFloat(args[0]);

        Float secondProject = Float.parseFloat(args[1]);

        Float participation = Float.parseFloat(args[2]);

        Float average = (firstProject + secondProject + participation) / 3;

        String state = "";
        if(average >= 6) {
            state = " Aprovado";
        }else {
            state = " Reprovado";
        }
        


        System.out.println("Seu conceito final é: " + Math.round(average) + state);


        
    }
}

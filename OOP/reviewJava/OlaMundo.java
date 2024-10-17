package revisaoJava;
// OlaMundo.java
public class OlaMundo{

    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Syntax Incorreta!");
            return;
        }

        String outputString = switch (args[0]) {
            case "en" -> "Hello World!";
            case "br" -> "Olá Mundo!";
            default -> "Language not implemented!";
        };

        System.out.println(outputString);
        
        

    }

    
}
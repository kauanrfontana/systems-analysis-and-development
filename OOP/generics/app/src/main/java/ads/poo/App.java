/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ads.poo;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Caixa<Pessoa> caixa = new Caixa<>();
        Pessoa p = new Pessoa("Nome");
        String s = "S";

        caixa.setConteudo(p);
    }
}

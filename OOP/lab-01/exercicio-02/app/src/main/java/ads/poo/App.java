/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ads.poo;

public class App {

    public static void main(String[] args) {
        Horario hora1 = new Horario(1, 0, 0);
        Horario hora2 = new Horario(2, 0, 0);
        System.out.println(hora1);
        System.out.println(hora2);
        System.out.println(hora1.tempoPorExtenso());
        System.out.println(hora1.diferencaHorarios(hora2));

    }
}

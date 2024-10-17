package ads.poo;

public class Circulo extends ObjetoDeDesenho implements formaGeometrica{
    private double raio;
    private Ponto centro;


    public Circulo(String corDaLinha, double raio, Ponto centro) {
        super(corDaLinha);
        this.raio = raio;
        this.centro = centro;
    }


    @Override
    public String desenhar() {
        return "O";
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimetro() {
        return 0;
    }
}

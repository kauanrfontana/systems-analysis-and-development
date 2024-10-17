package ads.poo;

public class Triangulo extends ObjetoDeDesenho implements formaGeometrica{
    private Ponto v1, v2, v3;

    public Triangulo(String corDaLinha, Ponto v1, Ponto v2, Ponto v3) {
        super(corDaLinha);
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String desenhar() {
        return "";
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

package ads.poo;

public class Retangulo extends ObjetoDeDesenho implements formaGeometrica{
    private Ponto verticeI;
    private Ponto verticeF;

    public Retangulo(String corDaLinha, Ponto verticeI, Ponto verticeF) {
        super(corDaLinha);
        this.verticeI = verticeI;
        this.verticeF = verticeF;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimetro() {
        return 0;
    }

    public Ponto getVerticeI() {
        return verticeI;
    }

    @Override
    public String desenhar() {
        return "";
    }
}

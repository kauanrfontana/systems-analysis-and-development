package ads.poo;

public class Ponto extends ObjetoDeDesenho {
    private double x;
    private double y;

    public Ponto(String corDaLinha, double x, double y) {
        super(corDaLinha);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String desenhar() {
        return String.format(".(%.1f, %.1f)", x, y);
    }
}


package ads.poo;

public class Ponto {
    private int coordenadaX;
    private int coordenadaY;

    public Ponto(int coordenadaX, int coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public double distancia(Ponto ponto){
        double result = Math.sqrt(Math.pow((ponto.getCoordenadaX() - this.coordenadaX), 2) + Math.pow((ponto.getCoordenadaY() - this.coordenadaY), 2));
        return result;
    }

    @Override
    public String toString() {
        return "(" + this.coordenadaX + ", " + this.coordenadaY + ");";
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

}

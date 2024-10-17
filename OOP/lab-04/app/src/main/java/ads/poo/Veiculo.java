package ads.poo;

public abstract class Veiculo {
    protected int id;
    protected int velocidade;

    public int acelerar(int i){
        velocidade += i;
        return velocidade;
    }

    public int frear(int i){
        velocidade -= i;
        return velocidade;
    }
}

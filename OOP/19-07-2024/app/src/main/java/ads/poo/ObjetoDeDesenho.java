package ads.poo;

public abstract class ObjetoDeDesenho {
    protected String corDaLinha;

    public ObjetoDeDesenho(String corDaLinha) {
        this.corDaLinha = corDaLinha;
    }

    public abstract String desenhar();
}

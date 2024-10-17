package ads.poo;

public class Linha extends ObjetoDeDesenho {
    private Ponto inicio;
    private Ponto fim;


    public Linha(String corDaLinha, Ponto inicio, Ponto fim) {
        super(corDaLinha);
        this.inicio = inicio;
        this.fim = fim;
    }


    @Override
    public String desenhar() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("(%.1f; %.1f).", inicio.getX(), inicio.getY()));
        for (int i = (int) inicio.getX(); i < fim.getX(); i++) {
            sb.append("-");
            if(i == fim.getX() - 1){
                sb.append(String.format(".(%.1f; %.1f)", fim.getX(), fim.getY()));
            }
        }
        return sb.toString();
    }
}

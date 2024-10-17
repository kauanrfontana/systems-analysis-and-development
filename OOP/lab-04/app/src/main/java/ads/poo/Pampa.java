package ads.poo;

public class Pampa extends Veiculo implements TracaoIntegral {
    private boolean cacamba;
    private boolean tracao;

    public boolean abrirFecharCacamba(){
        cacamba = !cacamba;
        return cacamba;
    }

    public boolean ativarDesativarTracao(){
        tracao = !tracao;
        return tracao;
    }
}

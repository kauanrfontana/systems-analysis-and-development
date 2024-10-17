package ads.poo;

public class Ferrari extends Veiculo implements Conversivel {
    private boolean farol;
    private boolean capota;

    public boolean ligarDesligarFarol(){
        farol = !farol;
        return farol;
    }

    public boolean abrirFecharCapota(){
        capota = !capota;
        return capota;
    }
}

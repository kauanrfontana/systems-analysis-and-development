package ads.poo.produtos;

public class Celular extends SemFio {
    private String SO;


    public Celular(int codigo, String numSerie, String modelo, double peso, Dimensao dim, double frequencia, int canais, double distancia, String so) {
        super(codigo, numSerie, modelo, peso, dim, frequencia, canais, distancia);
        this.SO = so;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }
}
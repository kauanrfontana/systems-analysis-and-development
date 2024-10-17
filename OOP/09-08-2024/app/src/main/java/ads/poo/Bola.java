package ads.poo;

import java.util.Objects;

public class Bola {
    private String tipo;
    private int tamanho;
    private int peso;
    private String cor;

    public Bola(String tipo, int tamanho, int peso, String cor) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.peso = peso;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Bola{" +
                "tipo='" + tipo + '\'' +
                ", tamanho=" + tamanho +
                ", peso=" + peso +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bola bola = (Bola) o;
        return tamanho == bola.tamanho && peso == bola.peso && Objects.equals(tipo, bola.tipo) && Objects.equals(cor, bola.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, tamanho, peso, cor);
    }
}

package ads.poo.produtos;

public class Dimensao {
    private float altura;
    private float largura;
    private float profundidae;

    public Dimensao(float altura, float largura, float profundidae) {
        this.altura = altura;
        this.largura = largura;
        this.profundidae = profundidae;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getProfundidae() {
        return profundidae;
    }

    public void setProfundidae(float profundidae) {
        this.profundidae = profundidae;
    }

    @Override
    public String toString() {
        return "Dimensao{" +
                "altura=" + altura +
                ", largura=" + largura +
                ", profundidae=" + profundidae +
                '}';
    }
}

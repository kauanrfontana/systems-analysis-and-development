package ads.poo;

public class Retangulo {
    private int altura;
    private int largura;
    private String codificacao;

    public Retangulo(int largura, int altura, String codificacao)
    {
        if(altura <= 0 || largura <= 0 ){
            this.largura = 4;
            this.altura = 3;
            return;
        }
        this.largura = largura;
        this.altura = altura;
        if(this.codificacaoInvalida(codificacao)){
            this.codificacao = "ASCII";
        }
        this.codificacao = codificacao;
    }

    public Retangulo()
    {
        this(4, 3, "ASCII");
    }

    public int getAltura()
    {
        return altura;
    }

    public boolean setAltura(int altura)
    {
        if(this.altura <= 0) return false;
        this.altura = altura;
        return true;
    }

    public int getLargura()
    {
        return largura;
    }

    public boolean setLargura(int largura)
    {
        if(this.largura <= 0) return false;
        this.largura = largura;
        return true;
    }

    public String getCodificacao()
    {
        return codificacao;
    }

    public boolean setCodificacao(String codificacao)
    {
        if(this.codificacaoInvalida(codificacao)) return false;
        this.codificacao = codificacao;
        return true;
    }

    private boolean codificacaoInvalida(String codificacao)
    {
        return !codificacao.equals("ASCII") && !codificacao.equals("UTF8");
    }

    public float getArea()
    {
        return largura * altura;
    }

    public float gePerimetro()
    {
        return 2 * (altura + largura);
    }

    @Override
    public String toString() {
        if(this.codificacao.equals("UTF8")){
            return this.desenhaRetanguloUT8();
        }
        return this.desenhaRetanguloASCII();
    }

    private String desenhaRetanguloASCII()
    {
        StringBuilder sb = new StringBuilder();
        String caractere;
        //TODO
        for(int i = 0; i <= altura; i++){
            caractere = "";
            for(int j = 0; j <= largura; j++){
                caractere = "-";
                if(((j == 0 && i == 0) || (j == largura && i == 0)) || j == 0 && i == largura){
                    caractere = "+";
                }
                sb.append(caractere);
            }
        }
        return "";
    }

    private String desenhaRetanguloUT8()
    {
        //TODO
        return "";
    }
}

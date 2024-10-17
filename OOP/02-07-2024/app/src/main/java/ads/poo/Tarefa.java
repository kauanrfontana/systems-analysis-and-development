package ads.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tarefa {
    private String titulo;
    private LocalDate prazo;
    private LocalDate dataConclusao;
    private Categoria categoria;
    private ArrayList<Pessoa> responsaveis = new ArrayList<Pessoa>();

    public Tarefa(String titulo, LocalDate prazo, Categoria categoria){
        this.titulo =  titulo;
        this.prazo = prazo;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Pessoa> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsaveis.add(responsavel);
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Tarefa: \n");
        sb.append("\tTítulo: " + titulo + "\n");
        sb.append("\tPrazo: " + prazo.format(formato) + "\n");
        if(dataConclusao != null){
            sb.append("\tData de Conclusão: " + dataConclusao.format(formato) + "\n");
        }
        sb.append("\tCategoria: " + categoria + "\n");
        sb.append("\tResponsáveis: ");
        for(Pessoa p : responsaveis){
            sb.append(p);
        }
        return sb.toString();
    }
}

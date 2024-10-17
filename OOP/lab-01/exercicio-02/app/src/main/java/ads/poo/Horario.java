package ads.poo;

public class Horario {

    private int horas;
    private int minutos;
    private int segundos;

    public Horario(int horas, int minutos, int segundos){
        if(horasInvalidas(horas) || minutosInvalidos(minutos) || segundosInvalidos(segundos)) {
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
            return;
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Horario(int horas, int minutos){
        this(horas, minutos, 0);
    }

    public Horario(int horas){
        this(horas, 0, 0);
    }


    @Override
    public String toString() {
        String horas = Integer.toString(this.horas);
        String minutos = Integer.toString(this.minutos);
        String segundos = Integer.toString(this.segundos);
        if(this.horas < 10){
            horas = "0" + this.horas;
        }
        if(this.minutos < 10){
            minutos = "0" + this.minutos;
        }
        if(this.segundos < 10){
            segundos = "0" + this.segundos;
        }

        return horas + ":" + minutos + ":" + segundos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if(horasInvalidas(horas)) return;
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if(minutosInvalidos(minutos)) return;
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        if(segundosInvalidos(segundos)) return;
        this.segundos = segundos;
    }

    public boolean horasInvalidas(int horas){
        if(horas < 0 || horas > 23) return true;
        return false;
    }

    public boolean minutosInvalidos(int minutos){
        if(minutos < 0 || minutos > 60) return true;
        return false;
    }

    public boolean segundosInvalidos(int segundos){
        if(segundos < 0 || segundos > 60) return true;
        return false;
    }

    public String tempoPorExtenso(){
        return unidadeDeTempoParaExtenso(this.horas, true) + " hora(s), " + unidadeDeTempoParaExtenso(this.minutos, false) + " minuto(s) e " + unidadeDeTempoParaExtenso(this.segundos, false) + " segundo(s).";
    }

    public String unidadeDeTempoParaExtenso(int unidade, boolean isHora){
        String unidadeExtenso = "";
        if(unidade % 10 == 0 || unidade < 20){
            unidadeExtenso = this.numeroParaExtenso(unidade, isHora);
        }else{
            int dezena = (int)Math.floor(unidade / 10) * 10;
            unidadeExtenso = this.numeroParaExtenso(dezena, isHora) + " e " + this.numeroParaExtenso(unidade - dezena, isHora);
        }
        return unidadeExtenso;
    }

    public String numeroParaExtenso(int numero, boolean isHora){
        switch (numero){
            case 1:
                return isHora ? "uma" : "um";
            case 2:
                return isHora ? "duas" : "dois";
            case 3:
                return "três";
            case 4:
                return "quatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "sete";
            case 8:
                return "oito";
            case 9:
                return "nove";
            case 10:
                return "dez";
            case 11:
                return "onze";
            case 12:
                return "doze";
            case 13:
                return "treze";
            case 14:
                return "quatorze";
            case 15:
                return "quinze";
            case 16:
                return "dezeseis";
            case 17:
                return "dezesete";
            case 18:
                return "dezoito";
            case 19:
                return "dezenove";
            case 20:
                return "vinte";
            case 30:
                return "trinta";
            case 40:
                return "quarenta";
            case 50:
                return "cinquenta";

        }
        return "zero";
    }

    public long tempoEmSegundos(){
        return (((this.horas * 60) * 60) + (this.minutos * 60) + this.segundos);
    }

    public long diferencaHorarios(Horario horario){
        return Math.abs(this.tempoEmSegundos() - horario.tempoEmSegundos());
    }
}

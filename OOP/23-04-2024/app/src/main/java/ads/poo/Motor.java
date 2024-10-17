package ads.poo;

public class Motor {
    private int hp;
    private int cilindradas;

    public Motor(int hp, int cilindradas) {
        this.hp = hp;
        this.cilindradas = cilindradas;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}

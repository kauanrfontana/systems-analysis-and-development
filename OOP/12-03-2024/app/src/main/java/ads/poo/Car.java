package ads.poo;
public class Car {
    private int currentSpeed;
    private final int UNDER_LIMIT = 0;
    private final  int ABOVE_LIMIT = 200;

    public int getUnderLimit() {
        return UNDER_LIMIT;
    }


    public int getAboveLimit() {
        return ABOVE_LIMIT;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Car(int currentSpeed) {
        if(this.isAboveLimit(currentSpeed) || this.isUnderLimit(currentSpeed)){
            this.currentSpeed = 0;
            return;
        }
        this.currentSpeed = currentSpeed;
    }
    public Car() {
        this(0);
    }

    public void speedUp(int plusSpeed){
        if(plusSpeed < 0) return;
        if(this.isAboveLimit(this.currentSpeed + plusSpeed)){
            this.currentSpeed = 200;
            return;
        }
        this.currentSpeed += plusSpeed;
    }

    public void speedDown(int menusSpeed){
        if(menusSpeed < 0) return;
        if(this.isUnderLimit(this.currentSpeed - menusSpeed)){
            this.currentSpeed = 0;
            return;
        }
        this.currentSpeed -= menusSpeed;
    }

    public boolean isAboveLimit(int number){
        return number > this.ABOVE_LIMIT;
    }

    public boolean isUnderLimit(int number){
        return number < this.UNDER_LIMIT;
    }

}

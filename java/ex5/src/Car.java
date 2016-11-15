public class Car {

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCcs() {
        return ccs;
    }

    public void setCcs(int ccs) {
        this.ccs = ccs;
    }

    public int getKmOdometer() {
        return kmOdometer;
    }

    public void setKmOdometer(int kmOdometer) {
        this.kmOdometer = kmOdometer;
    }
    private String typeCar;
    private String color;
    private int ccs;
    private int kmOdometer;

    public Car() {
        this("Mazda", "red", 1600, 12312);
    }
    public Car(String typeCar, String color) {
        this(typeCar, color, 1600, 10);
    }
    public Car(int ccs, int kmOdometer) {
        this("Mazda", "red", ccs, kmOdometer);
    }

    public Car(String typeCar, String color, int ccs, int kmOdometer) {
        this.typeCar = typeCar;
        this.color = color;
        this.ccs = ccs;
        this.kmOdometer = kmOdometer;
    }
    public String toString() {
        String out = String.format("This %s is %s, has %d cc engine and clocked %d km's", getTypeCar(), getColor(), getCcs(), getKmOdometer());
        return out;
    }

    public void drive (int distance) {
        System.out.printf("The %s %s odometer now shows %d", getColor(), getTypeCar(), getKmOdometer());
        setKmOdometer(getKmOdometer() + distance);
        if (distance < 20) {
            System.out.printf("\nBrrm, the %s %s just drove around town %d clicks.\n", getColor(), getTypeCar(), distance);
        } else if (distance >= 20 && distance < 50) {
            System.out.printf("\nBrrm, screech, brrm, screech; the %s %s commuted %d clicks.\n", getColor(), getTypeCar(), distance);
        } else {
            System.out.printf("\nWhee, the %s %s cruised %d clicks.\n", getColor(), getTypeCar(), distance);

        }


    }
}
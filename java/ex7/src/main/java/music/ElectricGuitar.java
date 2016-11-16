package main.java.music;

public class ElectricGuitar extends StringedInstrument {
    private static final String name = "Electric Guitar";
    private static final String sound = "twangs";
    public ElectricGuitar() {
        super(name, sound);
    numberOfStrings = 6;
    }

    public ElectricGuitar(int nstrings) {
        super(nstrings, name, sound);
    }
}

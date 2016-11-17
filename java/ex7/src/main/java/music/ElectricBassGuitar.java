package main.java.music;

public class ElectricBassGuitar extends StringedInstrument {
    private static final String name = "Bass Guitar";
    private static final String sound = "goes dumm-dumm-dumm";
    public ElectricBassGuitar() {
        super(name, sound);
    numberOfStrings = 4;
    }

    public ElectricBassGuitar(int nstrings) {
        super(nstrings, name, sound);

    }

}

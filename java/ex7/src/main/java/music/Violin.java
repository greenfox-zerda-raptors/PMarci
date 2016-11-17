package main.java.music;

public class Violin extends  StringedInstrument {
    private static final String name = "Violin";
    private static final String sound = "goes screech";

    public Violin() {
        super(name, sound);
    numberOfStrings = 6;
    }

    public Violin(int nstrings) {
        super(nstrings, name, sound);
    }

}

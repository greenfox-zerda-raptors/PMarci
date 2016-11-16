package main.java.music;

public abstract class StringedInstrument extends Instrument {


    final String formatForPlay = "%s, a %d-stringed instrument that %s\n";
    public void play () {
        System.out.printf( formatForPlay, name, numberOfStrings, sound);
    }
    public StringedInstrument(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }
    public StringedInstrument(int nstrings, String name, String sound) {
            this.numberOfStrings = nstrings;
            this.name = name;
            this.sound = sound;
    }

}

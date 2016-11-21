import static org.junit.Assert.*;

/**
 * Created by posam on 2016-11-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class TestMarci {
    @org.junit.Test
    public void countHowMany() throws Exception {
        WordToolbox word = new WordToolbox("Tarzan's toenails");
        assertEquals(3, word.countHowMany('a'));
        assertEquals(0, word.countHowMany('x'));
        assertEquals(1, word.countHowMany(' '));
        assertEquals(0, word.countHowMany('\u0000'));
    }
    @org.junit.Test
    public void countHowManyJane() throws Exception {
        WordToolbox word = new WordToolbox("Me Tarzan, You Jane");
        assertEquals(3, word.countHowMany('a'));
        assertEquals(0, word.countHowMany('x'));
        assertEquals(3, word.countHowMany(' '));
        assertEquals(0, word.countHowMany('\u0000'));

    }
}
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by posam on 2017-01-17.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */


public class Tests {

    @Test
    public void first() throws Exception {
        Generation result = new Generation(new int[][]{{1, 1, 1},
                {1, 1, 1},
                {0, 1, 1}});
        Generation origin = new Generation(new int[][]{{0, 1, 0},
                {0, 1, 1},
                {0, 0, 0}});
        assertEquals(result, origin.createNextGeneration());
    }

    @Test
    public void second() throws Exception {
        Generation result1 = new Generation(new int[][]{{0, 1, 1},
                {0, 1, 1},
                {0, 0, 0}});
        Generation result2 = new Generation(new int[][]{{0, 1, 1},
                {0, 1, 1},
                {0, 0, 0}});

        assertTrue(result1.equals(result2));
    }

}

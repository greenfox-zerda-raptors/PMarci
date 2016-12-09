package com.java.rpg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by posam on 2016-12-09.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class AreaTest {
    @Test
    public void getNumberOfZerosTest() throws Exception {
        HardCodedMaps maps = new HardCodedMaps();
        Area area = new Area();
        assertEquals(74, area.getNumberOfZeros(maps.get(0)));
    }

}
package org.ncmao;

import org.junit.Test;

public class StringTest {

    public static String BASEINFO = "Mr.Y";
    public static final int COUNT = 2000000;

    @Test
    public void doStringTest() {

        String str = new String(BASEINFO);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < COUNT / 100; i++) {
            str = str + "miss";
        }
        long endtime = System.currentTimeMillis();
        System.out.println((endtime - starttime)
                + " millis has costed when used String.");
    }

    @Test
    public void doStringBufferTest() {

        StringBuffer stringBuffer = new StringBuffer(BASEINFO);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < COUNT / 100; i++) {
            stringBuffer.append("miss");
        }
        long endtime = System.currentTimeMillis();
        System.out.println((endtime - starttime)
                + " millis has costed when used stringbuffer.");
    }

    @Test
    public void doStringBuilderTest() {
        StringBuilder stringBuilder = new StringBuilder(BASEINFO);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < COUNT / 100; i++) {
            stringBuilder.append("miss");
        }
        long endtime = System.currentTimeMillis();
        System.out.println((endtime - starttime)
                + " millis has costed when used stringbuffer.");
    }

}

package com.example.orahis.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void BuilderPhrase_Test() throws Exception {
        BuilderPhrase builderPhrase = new BuilderPhrase(new IGetStrings() {
            @Override
            public String getMorning() {
                return "Morning";
            }

            @Override
            public String getHello() {
                return "Hello";
            }

            @Override
            public String getAfternoon() {
                return "Afternoon";
            }
        });
        assertEquals("Good night", builderPhrase.get());
    }

}
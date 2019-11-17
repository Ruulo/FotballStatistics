package com.example.lazar.fotballstatistics;

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
        assertEquals(1, db.getPartido(1).idPartido);
    }

    @Test
    public void getEquipoPartido() throws Exception{
        assertEquals(1, db.getPartido(1).idPartido);
        assertEquals("RealMadrid", db.equipos.get(1).nombre);
    }
}
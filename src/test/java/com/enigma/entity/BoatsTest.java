package com.enigma.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoatsTest {

    @Test
    public void getNumberBoat() {
        String exceptedNumberBoat = "KA-01-1234-HA";
        Boats boats = new Boats();
        boats.setNumberBoat(exceptedNumberBoat);
        String actual =  boats.getNumberBoat();
        assertEquals(exceptedNumberBoat,actual);
    }

    @Test
    public void setNumberBoat() {
        String exceptedNumberBoat = "KA-01-1234-HA";
        Boats boats = new Boats();
        boats.setNumberBoat(exceptedNumberBoat);
        assertEquals(exceptedNumberBoat,boats.getNumberBoat());
    }

    @Test
    public void setColour() {
        String exceptedColour = "white";
        Boats boats = new Boats();
        boats.setColour(exceptedColour);
        assertEquals(exceptedColour,boats.getColour());
    }

    @Test
    public void getColour() {
        String exceptedColour = "red";
        Boats boats = new Boats();
        boats.setColour(exceptedColour);
        String actual =  boats.getColour();
        assertEquals(exceptedColour,actual);
    }
}
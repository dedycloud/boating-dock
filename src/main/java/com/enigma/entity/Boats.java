package com.enigma.entity;

public class Boats {
  public   String numberBoat;
  public    String colour;

    public Boats() {
    }

    public Boats(String numberBoat, String colour) {
        this.numberBoat = numberBoat;
        this.colour = colour;
    }

    public String getNumberBoat() {
        return numberBoat;
    }

    public void setNumberBoat(String numberBoat) {
        this.numberBoat = numberBoat;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return  numberBoat +" "+ colour ;
    }
}

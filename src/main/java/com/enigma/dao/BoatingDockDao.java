package com.enigma.dao;

import com.enigma.entity.Boats;

public interface BoatingDockDao {
    String createPiers(Integer capacity);
    String docked(Boats boats);
    String boatOut(Integer pier);
    String statusPiers();
    String statusNumberBoatsWithColour(String givenColour);
    String statusNumberPiersWithColour(String givenColour);
    String chekNumberPiersWithNumberBoats(String givenNumberBoat);
}

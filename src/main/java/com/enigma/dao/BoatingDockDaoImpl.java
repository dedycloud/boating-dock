package com.enigma.dao;

import com.enigma.constant.ServiceConstant;
import com.enigma.entity.Boats;

import java.util.HashMap;
import java.util.Map;

public class BoatingDockDaoImpl implements BoatingDockDao {
    private Integer capacity;
    private Map<Integer, Boats> piers = new HashMap<Integer, Boats>();

    public BoatingDockDaoImpl() {
    }

    public BoatingDockDaoImpl(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String createPiers(Integer capacity) {
        this.capacity = capacity;
        for (int i = 1; i <= capacity; i++) {
            piers.put(i, null);
        }
        return String.format(ServiceConstant.CREATE_PIERS, capacity);
    }

    @Override
    public String docked(Boats boats) {
//        for (Map.Entry<Integer,Boats> boatInPiers:piers.entrySet()){
//            if (boatInPiers.getValue()==null){
//                boatInPiers.setValue()
//            }
//        }
        for (int i = 1; i <= piers.size(); i++) {
            if (piers.get(i) == null) {
                piers.put(i, boats);
                return String.format(ServiceConstant.ALLOCATED_PIER, i);
            }
        }
        return String.format(ServiceConstant.PIERS_IS_FULL);
    }

    @Override
    public String boatOut(Integer pier) {

        for (Map.Entry<Integer, Boats> boatInPiers : piers.entrySet()) {
            if (pier != null) {
                if (boatInPiers.getKey() == pier) {
                    piers.put(boatInPiers.getKey(), null);
                    return String.format(ServiceConstant.LEAVE_BOAT, boatInPiers.getKey());
                }
            }
        }
        return String.format(ServiceConstant.BOAT_NOT_FOUND);
    }

    @Override
    public String statusPiers() {
        StringBuilder stringBuilder = new StringBuilder(ServiceConstant.STATUS_HEADER);
        for (Map.Entry<Integer, Boats> boatInPiers : piers.entrySet()) {
            if (boatInPiers.getValue() != null) {
                stringBuilder.append(String.format(ServiceConstant.STATUS_BODY, boatInPiers.getKey(), boatInPiers.getValue().getNumberBoat(), boatInPiers.getValue().getColour()));
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String statusNumberBoatsWithColour(String givenColour) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Boats> boatInPiers : piers.entrySet()) {
            if (boatInPiers.getValue() != null) {
                if (boatInPiers.getValue().getColour().equals(givenColour)) {
                    String selectedNumberBoat = boatInPiers.getValue().getNumberBoat();
                    stringBuilder.append(String.format(ServiceConstant.STATUS_BODY_NUMBER_BOAT, selectedNumberBoat));
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String statusNumberPiersWithColour(String givenColour) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Boats> boatInPiers : piers.entrySet()) {
            if (boatInPiers.getValue() != null) {
                if (boatInPiers.getValue().getColour().equals(givenColour)) {
                    stringBuilder.append(String.format(ServiceConstant.STATUS_BODY_NUMBER_PIERS, boatInPiers.getKey()));
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String chekNumberPiersWithNumberBoats(String givenNumberBoat) {
        for (Map.Entry<Integer, Boats> boatInPiers : piers.entrySet()) {
            if (boatInPiers.getValue()!=null) {
                if (boatInPiers.getValue().getNumberBoat().equals(givenNumberBoat)) {
                    return String.format(ServiceConstant.STATUS_NUMBER_PIERS_WITH_NUMBER_BOAT, boatInPiers.getKey());
                }
            }
        }
        return String.format(ServiceConstant.BOAT_NOT_FOUND);
    }
}

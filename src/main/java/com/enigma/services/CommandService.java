package com.enigma.services;

import com.enigma.constant.CommandConstant;
import com.enigma.dao.BoatingDockDao;
import com.enigma.dao.BoatingDockDaoImpl;
import com.enigma.entity.Boats;

import java.util.ArrayList;
import java.util.List;

public class CommandService {
    BoatingDockDao boatingDockDao = new BoatingDockDaoImpl();

    public void commandParse(List<String> givenCommand){
        for (String commandLine: givenCommand ) {
            switch (commandLine.split(" ")[0]){
                case CommandConstant.CREATE_BOATING_DOCK:
                    Integer capacity = Integer.parseInt(commandLine.substring(20));
                    System.out.println(boatingDockDao.createPiers(capacity));
                    break;
                case CommandConstant.DOCK:
                    String numberBoats = commandLine.substring(5,18);
                    String colourBoats = commandLine.substring(19);
                    Boats boats = new Boats();
                    boats.setNumberBoat(numberBoats);
                    boats.setColour(colourBoats);
                    System.out.println(boatingDockDao.docked(boats));
                    break;
                case  CommandConstant.LEAVE:
                    Integer pier = Integer.parseInt(commandLine.substring(6));
                    System.out.println(boatingDockDao.boatOut(pier));
                    break;
                case CommandConstant.STATUS:
                    System.out.println(boatingDockDao.statusPiers());
                    break;
                case CommandConstant.REGISTRATION_NUMBERS_FOR_BOATS_WITH_COLOURS:
                    String color = commandLine.substring(43);
                    System.out.println(boatingDockDao.statusNumberBoatsWithColour(color));
                    break;
                case CommandConstant.SLOT_NUMBERS_FOR_BOATS_WITH_COLOUR:
                    String colors = commandLine.substring(35);
                    System.out.println(boatingDockDao.statusNumberPiersWithColour(colors));
                    break;
                case CommandConstant.SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                    String numberBoat = commandLine.substring(36);
                    System.out.println(boatingDockDao.chekNumberPiersWithNumberBoats(numberBoat));
                    break;
                default: System.out.println(CommandConstant.COMMAND_NOT_FOUND);
            }
        }
    }
}

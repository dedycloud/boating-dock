package com.enigma.dao;

import com.enigma.constant.ServiceConstant;
import com.enigma.entity.Boats;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoatingDockDaoTest {

    @Test
    public void createDock_should_create_piers1_when_create_piers_1() {
        Integer setCapacity= 1;
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        Integer actualResult = boatingDockDao.getCapacity();
        Integer exceptedResult = 1;
        assertEquals(actualResult,exceptedResult);
    }
    @Test
    public void createDock_should_success_when_createPiers(){
        Integer setCapacity= 1;
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        String expectedResult = String.format(ServiceConstant.CREATE_PIERS,setCapacity);
        String actual  =  boatingDockDao.createPiers(setCapacity);
        assertEquals(expectedResult,actual);
    }
    @Test
    public void boat_should_dock_when_run_docked_method(){
        Integer setCapacity = 2;
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        String expectedResult = String.format(ServiceConstant.ALLOCATED_PIER,1);
        String actual = boatingDockDao.docked(ferry);
        assertEquals(expectedResult,actual);
    }
    @Test
    public void piers_can_empty_when_boat_Out(){
        Integer setCapacity =  1;
        Integer setPiers = 1;
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        String expectedResult = String.format(ServiceConstant.LEAVE_BOAT,1);
        boatingDockDao.createPiers(setCapacity);
        boatingDockDao.docked(ferry);
        String actual = boatingDockDao.boatOut(setPiers);
        assertEquals(expectedResult,actual);
    }
    @Test
    public void the_boat_was_not_found_when_removing_the_ship_that_never_existed(){
        Integer setCapacity =  1;
        Integer setPiers = 1;
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(setCapacity);
        String expectedResult = String.format(ServiceConstant.BOAT_NOT_FOUND);
        String actual = boatingDockDao.boatOut(setPiers);
        assertEquals(expectedResult,actual);
    }
    @Test
    public void chek_status_should_success_when_run_method_statusPiers(){
        Integer setCapacity =  1;
        Integer setPiers = 1;
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        boatingDockDao.docked(ferry);
        StringBuilder stringBuilder = new StringBuilder(ServiceConstant.STATUS_HEADER);
        stringBuilder.append(String.format(ServiceConstant.STATUS_BODY,setPiers,ferry.getNumberBoat(),ferry.getColour()));
        String excpected = stringBuilder.toString();
        String actual = boatingDockDao.statusPiers();
        assertEquals(excpected,actual);
    }
    @Test
    public void check_status_numberBoat_with_colours_white_should_success(){
        Integer setCapacity =  1;
        String expectedColour = "white";
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        boatingDockDao.docked(ferry);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ServiceConstant.STATUS_BODY_NUMBER_BOAT,ferry.getNumberBoat()));
        String expected = stringBuilder.toString();
        String actual = boatingDockDao.statusNumberBoatsWithColour(expectedColour);
        assertEquals(expected,actual);
    }
    @Test
    public void check_status_numberPiers_with_colours_white_should_success(){
        Integer setCapacity =  1;
        Integer expectedPiers = 1;
        String expectedColour  = "white";
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        boatingDockDao.docked(ferry);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ServiceConstant.STATUS_BODY_NUMBER_PIERS,expectedPiers));
        String expected = stringBuilder.toString();
        String actual = boatingDockDao.statusNumberPiersWithColour(expectedColour);
        assertEquals(expected,actual);
    }
    @Test
    public void slot_number_should_be_1_when_the_same_boat_number_is_found_on_pier_1(){
        Integer setCapacity =  1;
        Integer expectedPiers = 1;
        String expectednumberBoat  = "KA-01-1234-BA";
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        boatingDockDao.docked(ferry);
        String expected = String.format(ServiceConstant.STATUS_NUMBER_PIERS_WITH_NUMBER_BOAT,expectedPiers);
        String actual = boatingDockDao.chekNumberPiersWithNumberBoats(expectednumberBoat);
        assertEquals(expected,actual);
    }
    @Test
    public void slot_number_should_be_not_found_when_number_boat_is_not_define(){
        Integer setCapacity =  1;
        Integer expectedPiers = 1;
        String expectednumberBoat  = "KA-01-B123-ZZ";
        Boats ferry = new Boats("KA-01-1234-BA","white");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.createPiers(setCapacity);
        boatingDockDao.docked(ferry);
        String expected = String.format(ServiceConstant.BOAT_NOT_FOUND);
        String actual = boatingDockDao.chekNumberPiersWithNumberBoats(expectednumberBoat);
        assertEquals(expected,actual);
    }
    @Test
    public void getCapacity_should_success() {
        Integer capacity = 1;
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.setCapacity(capacity);
        Integer actual = boatingDockDao.getCapacity();
        assertEquals(capacity,actual);
    }

    @Test
    public void setCapacity_should_success() {
        Integer capacity = 1;
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl();
        boatingDockDao.setCapacity(capacity);
        assertEquals(capacity,boatingDockDao.getCapacity());
    }


}

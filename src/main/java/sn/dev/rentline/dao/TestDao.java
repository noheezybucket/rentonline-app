package sn.dev.rentline.dao;

import sn.dev.rentline.entity.Building;
import sn.dev.rentline.entity.RentUnit;

import java.sql.SQLException;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        IRentUnitDao metier = new RentUnitImplDao();

        //get the list of all buildings
        for(RentUnit b : metier.getAllUnits()){
            System.out.println(b);
        };
    }
}

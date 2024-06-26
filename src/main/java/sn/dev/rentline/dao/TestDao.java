package sn.dev.rentline.dao;

import sn.dev.rentline.entity.Building;

import java.sql.SQLException;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        IBuildingDao metier = new BuildingImplDao();

        Building b = metier.getBuildingById(5);

        int ok = metier.deleteBuilding(b.getId());
    }
}

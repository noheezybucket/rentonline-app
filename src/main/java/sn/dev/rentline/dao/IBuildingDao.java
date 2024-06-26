package sn.dev.rentline.dao;

import sn.dev.rentline.entity.Building;

import java.sql.SQLException;
import java.util.List;

public interface IBuildingDao {
    public Building addBuilding(Building building);
    public List<Building> getAllBuildings() throws SQLException;
    public Building getBuildingById(int id) throws SQLException;
    public int updateBuilding(Building building);
    public int deleteBuilding(int id);
}

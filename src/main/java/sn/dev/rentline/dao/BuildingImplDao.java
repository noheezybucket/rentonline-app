package sn.dev.rentline.dao;

import sn.dev.rentline.entity.Building;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingImplDao implements IBuildingDao{

    private SingletonConnection db = new SingletonConnection();
    private ResultSet rs;
    private int ok;

    @Override
    public Building addBuilding(Building building) {
        String sql = "INSERT INTO buildings (name, adress, description, equipments, image) VALUES (?, ?, ?, ?, ?);";

        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, building.getName());
            db.getPstm().setString(2, building.getAddress());
            db.getPstm().setString(3, building.getDescription());
            db.getPstm().setString(4, building.getEquipments());
            db.getPstm().setString(5, building.getImage());
            ok = db.executeMaj();
            if(ok == 1){
                String req = "SELECT MAX(id) as max_id FROM buildings;";
                db.initPrepar(req);
                rs = db.executeSelect();

                if(rs.next()){
                    building.setId(rs.getInt("max_id"));
                }
            }
            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return building;
    }

    @Override
    public List<Building> getAllBuildings() throws SQLException {
        List<Building> buildings = new ArrayList<>();
        String sql = "SELECT * FROM buildings;";

        db.initPrepar(sql);
        rs = db.executeSelect();

        while (rs.next()){
            Building b = new Building(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("adress"),
                    rs.getString("equipments"),
                    rs.getString("image")
            );

            buildings.add(b);
        }

        db.closeConnection();

        return  buildings;
    }

    @Override
    public Building getBuildingById(int id) throws SQLException {
        Building building = null;
        String sql = "SELECT * FROM buildings WHERE id = ?;";

        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            db.getPstm().setInt(1, id);
            rs = db.executeSelect();
            if (rs.next()){
                 building = new Building(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("adress"),
                        rs.getString("equipments"),
                        rs.getString("image")
                );
            }
            db.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return building;
    }

    @Override
    public int updateBuilding(Building building) {
        String sql = "UPDATE buildings SET name = ?,  adress = ? , description = ?, equipments = ?, image = ? WHERE id = ?;";

        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, building.getName());
            db.getPstm().setString(2, building.getAddress());
            db.getPstm().setString(3, building.getDescription());
            db.getPstm().setString(4, building.getEquipments());
            db.getPstm().setString(5, building.getImage());
            db.getPstm().setInt(6, building.getId());
            ok = db.executeMaj();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ok;
    }

    @Override
    public int deleteBuilding(int id) {
        String sql = "DELETE FROM buildings WHERE id = ?;";

        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            ok = db.executeMaj();
            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ok;
    }
}

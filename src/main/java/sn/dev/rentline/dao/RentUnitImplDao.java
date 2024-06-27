package sn.dev.rentline.dao;

import sn.dev.rentline.entity.Building;
import sn.dev.rentline.entity.RentUnit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentUnitImplDao implements IRentUnitDao {
    private SingletonConnection db = new SingletonConnection();
    private ResultSet rs;
    private int ok;

    @Override
    public RentUnit addUnit(RentUnit rentunit) throws SQLException {
        String sql = "INSERT INTO rentunits (pieces, surface, price, building_id) VALUES (?, ?, ?, ?);";

        db.initPrepar(sql);
        db.getPstm().setInt(1, rentunit.getPieces());
        db.getPstm().setInt(3, rentunit.getSurface());
        db.getPstm().setInt(2, rentunit.getPrice());
        db.getPstm().setInt(4, rentunit.getBuilding_id());

        ok = db.executeMaj();

        if(ok == 1){
            String req = "SELECT MAX(id) as max_id FROM rentunits;";
            db.initPrepar(req);
            rs = db.executeSelect();

            if(rs.next()){
                rentunit.setId(rs.getInt("max_id"));
            }
        }
        db.closeConnection();

        return rentunit;
    }

    @Override
    public List<RentUnit> getAllUnits() throws SQLException {
        List<RentUnit> rentUnits = new ArrayList<>();
        String sql = "SELECT * FROM rentunits;";

        db.initPrepar(sql);
        rs = db.executeSelect();

        while (rs.next()){
            RentUnit b = new RentUnit(
                    rs.getInt("id"),
                    rs.getInt("pieces"),
                    rs.getInt("surface"),
                    rs.getInt("price"),
                    rs.getInt("building_id")

            );

            rentUnits.add(b);
        }

        db.closeConnection();

        return  rentUnits;
    }

    @Override
    public RentUnit getUnitId(int id) {
        return null;
    }

    @Override
    public int updateUnit(RentUnit rentunit) {
        return 0;
    }

    @Override
    public int deleteUnit(int id) {
        return 0;
    }
}

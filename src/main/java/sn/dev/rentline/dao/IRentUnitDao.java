package sn.dev.rentline.dao;

import sn.dev.rentline.entity.RentUnit;

import java.sql.SQLException;
import java.util.List;

public interface IRentUnitDao {
    public RentUnit addUnit(RentUnit rentunit) throws SQLException;
    public List<RentUnit> getAllUnits() throws SQLException;
    public RentUnit getUnitId(int id);
    public int updateUnit(RentUnit rentunit);
    public int deleteUnit(int id);
}

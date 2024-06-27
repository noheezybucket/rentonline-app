package sn.dev.rentline.web.rentunit;

import lombok.Data;
import sn.dev.rentline.entity.RentUnit;

import java.util.ArrayList;
import java.util.List;

@Data
public class RentUnitModel {
    private List<RentUnit> rentUnits = new ArrayList<>();

}

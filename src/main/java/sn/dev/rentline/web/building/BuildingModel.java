package sn.dev.rentline.web.building;

import lombok.Data;
import sn.dev.rentline.entity.Building;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuildingModel {
    private List<Building> buildings = new ArrayList<>();
}

package sn.dev.rentline.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RentUnit {
    private int id;
    private int pieces;
    private int surface;
    private int price;
    private int building_id;
}

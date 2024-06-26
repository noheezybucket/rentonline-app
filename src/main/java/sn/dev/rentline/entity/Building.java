package sn.dev.rentline.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Building {
    private int id;
    private String name;
    private String address;
    private String description;
    private String equipments;
    private String image;


}

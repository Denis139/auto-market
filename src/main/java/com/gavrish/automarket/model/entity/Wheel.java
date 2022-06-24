package com.gavrish.automarket.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity()
@Data
@Accessors(chain = true)
@ToString(callSuper = true, exclude = {"models"})
@EqualsAndHashCode(callSuper = true, exclude = {"models"})
@NoArgsConstructor
@Table(name = "wheel")
public class Wheel extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "diameter")
    private Double diameter;

    @Column(name = "width", nullable = false)
    private Double width;

    @Column(name = "number_holes", nullable = false)
    private Integer numberHoles;

    @Column(name = "bolt_pattern", nullable = false)
    private String boltPattern;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wheel")
    private List<Model> models = new LinkedList<>();
}

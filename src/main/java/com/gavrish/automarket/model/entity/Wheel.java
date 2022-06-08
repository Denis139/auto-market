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
@NoArgsConstructor
@ToString(callSuper = true, exclude = "modelWheels")
@EqualsAndHashCode(callSuper = true, exclude = "modelWheels")
@Table(name = "wheel")
public class Wheel extends BaseEntity {

    @Column(name = "diameter", nullable = false)
    private Double diameter;

    @Column(name = "width", nullable = false)
    private Double width;

    @Column(name = "number_holes", nullable = false)
    private Integer number_holes;

    @Column(name = "bolt_pattern", nullable = false)
    private String bolt_pattern;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wheel")
    private List<ModelWheel> modelWheels = new LinkedList<>();
}

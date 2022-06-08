package com.gavrish.automarket.model.entity;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"cars", "modelFactories", "modelWheels"})
@EqualsAndHashCode(callSuper = true, exclude = {"cars", "modelFactories", "modelWheels"})
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@Table(name = "model")
public class Model extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Type(type = "pgsql_enum")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "drivetrain", nullable = false)
    private DriveTrainEnum driveTrain;

    @Column(name = "fuel_consumption", nullable = false)
    private Double fuelConsumption;

    @Type(type = "pgsql_enum")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "color", nullable = false)
    private ColorEnum color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    private List<Car> cars = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    private List<ModelFactory> modelFactories = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    private List<ModelWheel> modelWheels = new LinkedList<>();
}

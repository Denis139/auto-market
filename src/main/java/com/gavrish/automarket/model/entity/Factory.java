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
@ToString(callSuper = true, exclude = "modelFactories")
@EqualsAndHashCode(callSuper = true, exclude = "modelFactories")
@Table(name = "factory")
public class Factory extends BaseEntity {

    @Column(name = "factory_name", nullable = false)
    private String factoryName;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "employees", nullable = false)
    private Integer employees;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factory")
    private List<ModelFactory> modelFactories = new LinkedList<>();
}

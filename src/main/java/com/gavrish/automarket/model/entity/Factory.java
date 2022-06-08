package com.gavrish.automarket.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.type.TextType;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity()
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "factories")
@EqualsAndHashCode(callSuper = true, exclude = "factories")
@Table(name = "factory")
public class Factory extends BaseEntity {

    @Column(name = "factory_name", nullable = false)
    private String factoryName;

    @Column(name = "country", nullable = false)
    private TextType country;

    @Column(name = "region", nullable = false)
    private TextType region;

    @Column(name = "city", nullable = false)
    private TextType city;

    @Column(name = "employees", nullable = false)
    private Integer employees;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factory")
    private List<ModelFactory> factories = new LinkedList<>();
}

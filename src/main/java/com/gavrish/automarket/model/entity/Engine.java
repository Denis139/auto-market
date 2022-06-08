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

@Entity()
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "models")
@EqualsAndHashCode(callSuper = true, exclude = "models")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@Table(name = "engine")
public class Engine extends BaseEntity {

    @Type(type = "pgsql_enum")
    @Enumerated(value  = EnumType.STRING)
    @Column(name = "engine_type", nullable = false)
    private EngineTypeEnum engineType;

    @Column(name = "volume", nullable = false)
    private Double volume;

    @Column(name = "power", nullable = false)
    private Integer power;

    @Column(name = "torque", nullable = false)
    private Integer torque;

    @Column(name = "fuel", nullable = false)
    private Integer fuel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "engine")
    private List<Model> models = new LinkedList<>();
}


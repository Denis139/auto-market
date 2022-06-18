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
@Table(name = "transmission")
public class Transmission extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Type(type = "pgsql_enum")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "transmission_type", nullable = false)
    private TransmissionTypeEnum transmissionType;

    @Column(name = "number_gears", nullable = false)
    private Integer numberGears;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transmission")
    private List<Model> models = new LinkedList<>();
}

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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@Table(name = "role")
public class Role extends BaseEntity{

    @Type(type = "pgsql_enum")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role_type", nullable = false)
    private RoleType roleType;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public List<UserRole> userRoleList = new LinkedList<>();
}

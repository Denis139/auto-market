package com.gavrish.automarket.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "app_user")
public class User extends BaseEntity{

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "telephone_number", nullable = false)
    private Integer telephoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserRole> userRoleList = new LinkedList<>();
}

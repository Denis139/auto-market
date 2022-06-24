package com.gavrish.automarket.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.UUID;

@Entity()
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}

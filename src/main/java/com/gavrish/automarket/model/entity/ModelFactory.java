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
@Table(name = "model_factory")
public class ModelFactory {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factory_id")
    private Factory factory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
}

package com.gavrish.automarket.model.dto.view;

import com.gavrish.automarket.model.entity.TransmissionTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors
public class TransmissionView {

    private UUID id;

    private TransmissionTypeEnum transmissionTypeEnum;

    private Integer numberGears;
}

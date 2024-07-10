package com.studymavenspringboot1.rentcar.vehicletype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleTypeRequest implements IVehicleType{
    @JsonIgnore
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    private String type;
}

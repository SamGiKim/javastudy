package com.studymavenspringboot1.rentcar.vehicletype;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class VehicleTypeDto {
    private Long id;
    private String type;

    @Override
    public String toString() {
        return String.format("ID:%6d, 종류:%s}", this.id, this.type);
    }
}

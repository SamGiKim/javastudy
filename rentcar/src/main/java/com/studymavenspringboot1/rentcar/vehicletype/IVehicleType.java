package com.studymavenspringboot1.rentcar.vehicletype;

import java.io.Serializable;

public interface IVehicleType extends Serializable {
    Long getId();
    void setId(Long id);

    String getType();
    void  setType(String type);

    default void copyFields(IVehicleType from) {
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getType() != null && !from.getType().isEmpty()) {
            this.setType(from.getType());
        }
    }

}

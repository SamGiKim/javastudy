package com.studymavenspringboot1.rentcar;

import java.util.List;

public class VehicleJSONRepository implements VehicleRepository{
    @Override
    public boolean save(List<IVehicle> save) {
        return false;
    }

    @Override
    public boolean load(List<IVehicle> load) {
        return false;
    }
}

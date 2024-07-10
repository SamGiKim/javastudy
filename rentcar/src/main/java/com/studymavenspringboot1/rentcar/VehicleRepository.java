package com.studymavenspringboot1.rentcar;

import java.util.List;

public interface VehicleRepository {
    public boolean save(List<IVehicle> save);
    public boolean load(List<IVehicle> load);

}

package com.studymavenspringboot1.rentcar.model;

import java.util.List;

public interface VehicleRepository {
    public boolean save(List<Vehicle> save);
    public boolean load(List<Vehicle> load);

}

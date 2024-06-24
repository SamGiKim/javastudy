package com.studymavenspringboot1.rentcar.model;

import java.util.List;

public interface VehicleService {
    public Vehicle addVehicle(Vehicle addV);
    public boolean removeVehicle(Long removeV);
    public Vehicle updateVehicle(Vehicle updateV);
    public Vehicle findVehicleById(Long findVId);
    public List<Vehicle> getAllVehicle();
    public List<Vehicle> findVehicleForStatus(VehicleStatus findVStatus);

}

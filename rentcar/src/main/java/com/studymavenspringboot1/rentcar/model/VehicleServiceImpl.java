package com.studymavenspringboot1.rentcar.model;

import java.util.List;

public class VehicleServiceImpl implements VehicleService{
    private List<Vehicle> vehicles;


    @Override
    public Vehicle addVehicle(Vehicle addV) {
        return null;
    }

    @Override
    public boolean removeVehicle(Long removeV) {
        return false;
    }

    @Override
    public Vehicle updateVehicle(Vehicle updateV) {
        return null;
    }

    @Override
    public Vehicle findVehicleById(Long findVId) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleForStatus(VehicleStatus findVStatus) {
        return List.of();
    }
}

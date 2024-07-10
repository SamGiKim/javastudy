package com.studymavenspringboot1.rentcar;

import com.studymavenspringboot1.rentcar.vehicletype.VehicleStatus;
import com.studymavenspringboot1.rentcar.vehicletype.IVehicleType;

public interface IVehicle {
    public Long getId();
    public String getCompany();
    public String getModel();
    public int getMakeYear();
    public IVehicleType getType();
    public String getColor();
    public int getTotalKm();
    public String getFactoryNumber();
    public String getRegistNumber();
    public VehicleStatus getStatus();
    public Long setId(Long id);
    public String setCompany(String company);
    public String setModel(String model);
    public int setMakeYear(int makeYear);
    public IVehicleType setType(IVehicleType type);
    public String setColor(String color);
    public int setTotalKm(int totlaKm);
    public String setFactoryNumber(String factoryNumber);
    public String setRegistNumber(String registNumber);
    public VehicleStatus setStatus(VehicleStatus status);

}

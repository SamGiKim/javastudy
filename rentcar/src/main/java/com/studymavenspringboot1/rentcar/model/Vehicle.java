package com.studymavenspringboot1.rentcar.model;

public interface Vehicle {
    public Long getId();
    public String getCompany();
    public String getModel();
    public int getMakeYear();
    public VehicleType getType();
    public String getColor();
    public int getTotalKm();
    public String getFactoryNumber();
    public String getRegistNumber();
    public VehicleStatus getStatus();
}

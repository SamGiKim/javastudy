package com.studymavenspringboot1.rentcar.model;

import lombok.Getter;

@Getter

public class MotorCycle implements Vehicle {
    private Long id;
    private String company;
    private String model;
    private int makeYear;
    private VehicleType type;
    private String color;
    private int totalKm;
    private String factoryNumber;
    private String registNumber;
    private VehicleStatus status;

    @Override
    public Long setId(Long id) {
        return id;
    }

    @Override
    public String setCompany(String company) {
        return "";
    }

    @Override
    public String setModel(String model) {
        return "";
    }

    @Override
    public int setMakeYear(int makeYear) {
        return 0;
    }

    @Override
    public VehicleType setType(VehicleType type) {
        return null;
    }

    @Override
    public String setColor(String color) {
        return "";
    }

    @Override
    public int setTotalKm(int totlaKm) {
        return 0;
    }

    @Override
    public String setFactoryNumber(String factoryNumber) {
        return "";
    }

    @Override
    public String setRegistNumber(String registNumber) {
        return "";
    }

    @Override
    public VehicleStatus setStatus(VehicleStatus status) {
        return null;
    }
}

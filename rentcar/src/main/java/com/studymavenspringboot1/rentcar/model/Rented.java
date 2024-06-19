package com.studymavenspringboot1.rentcar.model;

import java.util.Date;

public class Rented {
    private Vehicle vehicle;
    private Member member;
    private Date startDate;
    private String startPoint;
    private Date endDate;
    private String endPoint;
    private int money;
    private Date rentDate;
    private Date returnDate;
    private Date brokenDate;
    private RentStatus status;
    private Reserved reserved;

    public void rentVehicle(Vehicle vehicle, Member member, Date startDate, String startPoint, int money, Date rentDate, RentStatus status){

    }

    public void returnVehicle(Vehicle vehicle, Member member, Date endDate, String endPoint, Date returnDate){

    }

    public void brokenVehicle(Vehicle vehicle, Member member, Date brokenDate){

    }
}

package com.constructflow.entity;

import java.util.Date;

public class ResoucerRequest {

    private int requestID;
    private Date requestDate;
    private String status;
    private int quantityNeeded;

    public ResoucerRequest() {
        System.out.println("[Entity] Default ResourceRequest created.");
    }

    public ResoucerRequest(int requestID, int quantityNeeded) {
        this.requestID = requestID;
        this.requestDate = new Date();
        this.status = "Pending";
        this.quantityNeeded = quantityNeeded;
        System.out.println("[Entity] ResourceRequest created for quantity: " + quantityNeeded);
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    @Override
    public String toString() {
        return "ResoucerRequest{" +
                "requestID=" + requestID +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", quantityNeeded=" + quantityNeeded +
                '}';
    }
}
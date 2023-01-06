package models;

import java.util.Date;

public class Ticket extends BaseModel   {
    private Vehicle vehicle;
    private String ownerName;
    private Date entryTime;
    private EntryGate entryGate;
    private ParkingLot parkingLot;
    private ParkingSpot parkingSpot;
    private Operator generatedByOperator;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Operator getGeneratedByOperator() {
        return generatedByOperator;
    }

    public void setGeneratedByOperator(Operator generatedByOperator) {
        this.generatedByOperator = generatedByOperator;
    }
}

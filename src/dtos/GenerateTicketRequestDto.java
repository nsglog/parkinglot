package dtos;

import models.EntryGate;
import models.Vehicle;

public class GenerateTicketRequestDto {

    private Vehicle vehicle;
    private EntryGate entryGate;
    private Long parkingLotId;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}

package dtos;

import models.ParkingLot;

public class CreateParkingLotResponseDto extends ResponseDto    {
    private ParkingLot parkingLot;
    private ResponseStatusDto responseStatusDto;


    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ResponseStatusDto getResponseStatusDto() {
        return responseStatusDto;
    }

    public void setResponseStatusDto(ResponseStatusDto responseStatusDto) {
        this.responseStatusDto = responseStatusDto;
    }
}

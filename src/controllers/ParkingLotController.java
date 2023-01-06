package controllers;

import dtos.*;
import models.ParkingFloor;
import models.ParkingLot;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {

    private ParkingLotService parkingLotService;

    public ParkingLotController (ParkingLotService parkingLotService)   {
        this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponseDto createParkingLot (CreateParkingLotRequestDto requestDto) {

        if(requestDto.getNumberOfFloors() < 2)  {
            CreateParkingLotResponseDto responseDto = new CreateParkingLotResponseDto();
            responseDto.setResponseStatus(ResponseStatusDto.FAILURE);
            return responseDto;
        }

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(requestDto.getAddress());

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i=0; i < requestDto.getNumberOfFloors(); ++i) {
            parkingFloors.add(new ParkingFloor());
        }

        parkingLot.setParkingFloors(parkingFloors);

        ParkingLot createdParkingLot = parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDto responseDto = new CreateParkingLotResponseDto();
        responseDto.setParkingLot(createdParkingLot);
        responseDto.setResponseStatus(ResponseStatusDto.SUCCESS);
        return responseDto;
    }

    public UpdateParkingLotResponseDto updateAddress(UpdateParkingLotRequestDto requestDto) {
        ParkingLot updatedParkingLot = parkingLotService.updateAddress(
                requestDto.getId(), requestDto.getAddress()
        );

        UpdateParkingLotResponseDto responseDto = new UpdateParkingLotResponseDto();
        responseDto.setParkingLot(updatedParkingLot);
        responseDto.setResponseStatus(ResponseStatusDto.SUCCESS);
        return responseDto;
    }


}

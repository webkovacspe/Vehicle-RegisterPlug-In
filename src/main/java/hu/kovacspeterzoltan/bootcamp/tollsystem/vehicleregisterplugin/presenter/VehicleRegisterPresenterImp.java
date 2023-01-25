package hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.presenter;

import hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.parser.PlugInParser;
import hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.validator.PlugInValidator;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.dto.VehicleRegisterResponseDTO;
import hu.kovacspeterzoltan.bootcamp.vehicleregister.api.VehicleRegisterPresenterInterface;

public class VehicleRegisterPresenterImp implements VehicleRegisterPresenterInterface {
    private final PlugInValidator validator;
    private final PlugInParser parser;
    public VehicleRegisterResponseDTO vehicleRegisterResponseDTO;

    public VehicleRegisterPresenterImp() {
        validator = new PlugInValidator();
        parser = new PlugInParser();
    }

    @Override
    public void displayMessage(String s) {

    }

    @Override
    public void displayJsonResponse(String vehicleRegisterJsonResponse) {
        validator.vehicleRegisterResponseValidator(vehicleRegisterJsonResponse);
        vehicleRegisterResponseDTO = parser.vehicleJsonStringToVehicleRegisterResponseDTO(vehicleRegisterJsonResponse);
    }
}
package hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin;

import hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.parser.PlugInParser;
import hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.presenter.VehicleRegisterPresenterImp;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.VehicleRegisterPlugInInterface;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.dto.VehicleRegisterRequestDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.dto.VehicleRegisterResponseDTO;
import hu.kovacspeterzoltan.bootcamp.vehicleregister.api.VehicleRegisterFindPlugInAPI;

public class VehicleRegisterFindInteractor implements VehicleRegisterPlugInInterface {
    private VehicleRegisterFindPlugInAPI vehicleRegisterFind;
    private VehicleRegisterPresenterImp vehicleRegisterPresenter;
    private final PlugInParser parser;

    public VehicleRegisterFindInteractor() {
        parser = new PlugInParser();
    }

    public void setVehicleRegisterFindImp(VehicleRegisterFindPlugInAPI vehicleRegisterFindImp) {
        vehicleRegisterFind = vehicleRegisterFindImp;
    }

    public void setVehicleRegisterPresenterImp(VehicleRegisterPresenterImp vehicleRegisterPresenterImp) {
        vehicleRegisterPresenter = vehicleRegisterPresenterImp;
    }

    @Override
    public VehicleRegisterResponseDTO findVehicleByRegistrationNumber(VehicleRegisterRequestDTO requestDTO) {
        vehicleRegisterFind.findVehicleByRegistrationNumberPlugIn(parser.requestDTOToVehicleRequestJsonString(requestDTO));
        return vehicleRegisterPresenter.vehicleRegisterResponseDTO;
    }
}
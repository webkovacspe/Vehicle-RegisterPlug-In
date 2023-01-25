package hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.parser;

import hu.kovacspeterzoltan.bootcamp.tollsystemapp.dto.VehicleRegisterRequestDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.dto.VehicleRegisterResponseDTO;
import org.json.JSONException;
import org.json.JSONObject;

public class PlugInParser {
    public String requestDTOToVehicleRequestJsonString(VehicleRegisterRequestDTO requestDTO) {
        JSONObject j = new JSONObject();
        try {
            j.put("registrationNumber", requestDTO.registrationNumber);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return j.toString();
    }

    public VehicleRegisterResponseDTO vehicleJsonStringToVehicleRegisterResponseDTO(String vehicleRegisterJsonResponse) {
        VehicleRegisterResponseDTO v = new VehicleRegisterResponseDTO();
        try {
            JSONObject jsonObject = new JSONObject(vehicleRegisterJsonResponse);
            String errorMessageKey = "errorMessage";
            if (jsonObject.has(errorMessageKey)) {
                v.errorMessage = jsonObject.getString(errorMessageKey);
            } else {
                v.registrationNumber = jsonObject.getString("registrationNumber").toUpperCase();
                v.vehicleType = jsonObject.getString("vehicleType");
                v.make = jsonObject.getString("make");
                v.model = jsonObject.getString("model");
                v.numberOfSeats = jsonObject.getInt("numberOfSeats");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return v;
    }
}
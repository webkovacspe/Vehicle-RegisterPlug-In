package hu.kovacspeterzoltan.bootcamp.tollsystem.vehicleregisterplugin.validator;

public class PlugInValidator {
    public void vehicleRegisterResponseValidator(String vehicleRegisterJsonResponse) {
        if (vehicleRegisterJsonResponse.equals("")) {
            throw new RuntimeException();
        }
    }
}
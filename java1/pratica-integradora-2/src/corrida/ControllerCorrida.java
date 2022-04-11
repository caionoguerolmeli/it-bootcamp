package corrida;

import java.util.HashMap;
import java.util.Map;

public class ControllerCorrida {
    HashMap<Integer, Participant> participantsMap = new HashMap<>();
    private static ControllerCorrida controller;

    public static final ControllerCorrida getInstance() {
        if (controller == null) {
            controller = new ControllerCorrida();
        }
        return controller;
    }

    public ControllerCorrida() {

    }

    public HashMap<Integer, Participant> getList() {
        return participantsMap;
    }

    public void addInscription(Participant participant) throws Exception {
        if (this.isNewParticipant(participant)) {
            participantsMap.put(participant.getIdNumber(), participant);
        } else {
            throw new Exception("\nParticipante ja esta incrito\n");
        }

    }

    private boolean isNewParticipant(Participant participant) {
        for (Map.Entry<Integer, Participant> entry : participantsMap.entrySet()) {
            if (entry.getValue().getRg() == participant.getRg()) {
                return false;
            }
        }
        return true;
    }

    public boolean cancelInscription(int idNumber) {
        if (participantsMap.remove(idNumber) != null) {
            return true;
        }
        return false;
    }

    public boolean validateData(Participant participant) {
        if (participant.getRg() != 0 && !participant.getBloodGroup().isBlank() && participant.getCellphone() != 0 && participant.getEmergencyphone() != 0
                && !participant.getName().isBlank() && !participant.getSurname().isBlank()) {

            return true;

        }

        return false;
    }

    public int validateInscription(int age, int circuitOption) {
        if (age < 18) {
            if (circuitOption == 3) {
                return 0;
            } else if (circuitOption == 2) {
                return 2000;
            } else {
                return 1300;
            }
        } else if (circuitOption == 3) {
            return 2800;
        } else if (circuitOption == 2) {
            return 2300;
        } else {
            return 1500;
        }
    }

    public boolean isCircuitOptionValid(int circuitOption) throws Exception {
        if (circuitOption < 4 && circuitOption > 0) {
            return true;
        }
        return false;
    }

}

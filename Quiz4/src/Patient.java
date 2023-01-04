import java.util.LinkedList;

public class Patient {
    String name;
    int systolic;
    int diastolic;
    int cholesterol;

    public Patient(String name, int systolic, int diastolic, int cholesterol) {
        this.name = name;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.cholesterol = cholesterol;
    }

    LinkedList<LinkedList<String>> atRisk(LinkedList<Patient> patients) {
        LinkedList<Patient> bP = new LinkedList<>();
        LinkedList<Patient> cH = new LinkedList<>();
        LinkedList<LinkedList<String>> pAtRisk = new LinkedList<>();

        for (Patient patient : patients) {
            if (patient.systolic >= 120 && patient.diastolic >= 80) {
                bloodPressure.add(patient.name);
            }
        }

        for (Patient patient : patients) {
            if (patient.cholesterol >= 200) {
                cH.add(patient);
            }
        }

        pAtRisk.addAll(bP);
        pAtRisk.addAll(cH);

    }
}

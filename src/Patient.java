public class Patient {
    private int patientId;
    private String patientName;
    private String patientDisease;
    private boolean has_insurance;

    public Patient(int patientId, String patientName, String patientDisease, boolean has_insurance) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientDisease = patientDisease;
        this.has_insurance = has_insurance;
    }

    public String toString() {
        return "ID: " + this.patientId + "\nName: " + this.patientName + "\nDisease: " + this.patientDisease + "\nInsurance:  " + this.has_insurance;
    }
}
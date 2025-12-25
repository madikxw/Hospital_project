public class Patient {
    private int patientId;
    private String patientName;
    private String patientDisease;
    private boolean has_insurance;

    public Patient(int patientId,
                   String patientName,
                   boolean has_insurance) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.has_insurance = has_insurance;

    }
    public void setPatientDisease(String patientDisease){
        this.patientDisease = patientDisease;

    }

    public  String getPatientDisease() {
        return patientDisease;
    }

    public int getPatientId() {
        return patientId;
    }


    @Override
    public String toString() {
        return
                "ID: " + this.patientId +
                "\nName: " + this.patientName +
                "\nDisease: " + this.patientDisease +
                "\nInsurance:  " + this.has_insurance;
    }
}
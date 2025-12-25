public class Patient {
    private int patientId;
    private String patientName;
    private String patientDisease;
    private boolean hasInsurance;


    public Patient(int patientId, String patientName, boolean hasInsurance) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.hasInsurance = hasInsurance;
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }


    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @Override
    public String toString() {
        return "ID: " + patientId +
                "\nName: " + patientName +
                "\nDisease: " + patientDisease +
                "\nInsurance: " + hasInsurance;
    }
}
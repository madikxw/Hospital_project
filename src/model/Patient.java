package model;

public class Patient {
    private int patientId;
    private String patientName;
    private String patientDisease;
    private boolean hasInsurance;
    private int patient_age;

    public Patient(int patientId,
                   String patientName,
                   int patient_age,
                   String patientDisease, boolean hasInsurance){
        this.patientId = patientId;
        this.patientName = patientName;
        this.patient_age = patient_age;
        this.patientDisease  = patientDisease;
        this.hasInsurance = hasInsurance;

    }
    public void setPatient_age(int patient_age) {
        if (patient_age > 0) {
            throw new  IllegalArgumentException("🚨ERROR: THIS AGE CANNOT BE REAL ");
        }else{
            this.patient_age = patient_age;
        }

    }
    public int getPatient_age() {
        return patient_age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        if(patientId <=0) {
            throw new IllegalArgumentException("🚨ERROR: ID cannot be negative or zero:");
        }else{
            this.patientId = patientId;
        }
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if(patientName != null && !patientName.isEmpty()){
            this.patientName = patientName;
        }else{
            throw new IllegalArgumentException("🚨ERROR: Name cannot be empty");
        }
    }


    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }



    public void setHasInsurance(boolean  hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public  boolean getHasInsurance(){
        return  hasInsurance;
    }




    @Override
    public String toString() {
        return "ID: " + patientId +
                "\nName: " + patientName +
                "\nDisease: " + patientDisease +
                "\nInsurance: " + hasInsurance;
    }


}
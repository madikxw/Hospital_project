
public class Patient {
    private int patientId;
    private String patientName;
    private String patientDisease;
    private String hasInsurance;
    private int patient_age;

    public Patient(int patientId,
                   String patientName,
                   int patient_age,
                   String patientDisease, String hasInsurance){
        this.patientId = patientId;
        this.patientName = patientName;
        this.patient_age = patient_age;
        this.patientDisease  = this.patientDisease;
        this.hasInsurance = hasInsurance;

    }



    public void setPatient_age(int patient_age) {
        if (patient_age > 0) {
            this.patient_age = patient_age;
        } else if (patient_age <= 0) {
            System.out.println("ERROR: THIS AGE CANNOT BE REAL ");
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
            this.patientId = patientId;
        }else{
            System.out.println("🚨ERROR:id CANNOT BE NEGATIVE");
        }
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if(patientName != null && !patientName.isEmpty()){
            this.patientName = patientName;

        }else{
            System.out.println("ERROR:NAME CANNOT BE EMPTY");
        }
    }


    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }



    public void setHasInsurance(String  hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public  String getHasInsurance(){
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
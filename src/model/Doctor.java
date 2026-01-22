package model;

public class Doctor {
    private int  doctorId;
    private String doctorName;
    private int experienceYears;
    private String specialization;



    public Doctor(int  doctorId, String doctorName, int experienceYears, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        if(doctorId <=0) {
            throw new IllegalArgumentException("🚨ERROR:ID cannot be negative or zero");
        }else{
            this.doctorId = doctorId;
        }
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {

        if(doctorName == null && doctorName.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }else{
            this.doctorName = doctorName;

        }
    }


    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears > 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public String getExperienceInfo() {
        if (experienceYears == 0) {
            return "don't have experience";
        } else {
            return experienceYears + " years";
        }
    }

    @Override
    public String toString() {
        return "ID: " + doctorId +
                "\nNAME: " + doctorName +
                "\nExperience: " + getExperienceInfo() +
                "\nSpecialization: " + specialization;
    }
}
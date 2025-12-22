public class Doctor {
    private String doctorId;
    private String doctorName;
    private int experienceYears;
    private String specialization;

    public Doctor(String doctorId, String doctorName, int experienceYears, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        if (experienceYears > 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }

    }

    public String getExperienceYears() {
        return this.experienceYears == 0 ? "dont have experience" : this.experienceYears + "years";
    }

    public String toString() {
        String var10000 = this.doctorId;
        return "ID: " + var10000 + "\nNAME: " + this.doctorName + "\nexperience:  " + this.getExperienceYears() + "\nspecialization: " + this.specialization;
    }
}
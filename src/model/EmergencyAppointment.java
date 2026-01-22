package model;

public class EmergencyAppointment extends Appointment  implements RiskAssessable {
    private int severityLevel;
    private boolean ambulanceRequired;
    public EmergencyAppointment(int Appointment_id,
                                String Date,
                                String time,
                                int severityLevel,
                                boolean ambulanceRequired,
                                String status){
        super(Appointment_id,Date,time,status);
        this.severityLevel = severityLevel;
        this.ambulanceRequired  =ambulanceRequired;
    }
    @Override
    public String getAppointmentType() {
        return "Emergency model.Appointment";
    }
    @Override
    public String assessRiskleve(){
        return "HIGH";
    }
    @Override
    public int getPriority() {
        return severityLevel;
    }
    public String assessRiskLevel() {
        if (severityLevel >= 4) {
            return "🚨Critical";
        }
        return "Moderate";
    }
    public String determineResponseUrgency() {
        if (severityLevel >= 5) {
            return "Immediate response required";
        } else if (severityLevel >= 3) {
            return "High priority response";
        }
        return "Standard emergency response";
    }
    @Override
    public void performAppointment() {
        System.out.println("🚨Performing an EMERGENCY appointment immediately!");
    }

    public void setSeverityLevel(int severityLevel){
        this.severityLevel = severityLevel;
    }
    public int getSeverityLevel(){
        return  severityLevel;
    }

    public void setAmbulanceRequired(boolean ambulanceRequired) {
        this.ambulanceRequired = ambulanceRequired;
    }
    public boolean getAmbulanceRequired(){
        return ambulanceRequired;
    }






}

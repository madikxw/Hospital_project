package model;

public class RegularAppointment extends Appointment implements RiskAssessable {
    private boolean followUp;
    private String visitType;

    public   RegularAppointment(int Appointment_id,
                                String Date,
                                String time,
                                boolean followUp,
                                String visitType,
                                String status){
        super(Appointment_id,Date,time,status);
        this.followUp = followUp;
        this.visitType = visitType;
    }
    @Override
    public String getAppointmentType() {
        return "Regular model.Appointment";
    }
    @Override
    public String assessRiskleve(){
        return "LOW";
    }



    @Override
    public int getPriority() {
        if (followUp){
            return 2;
        }else{
            return 1;
        }
    }
    public String generateVisitSummary() {
        return "Regular appointment (" + visitType +
                ") on " + getDate() + " at " + getTime();
    }
    public String determineVisitCategory() {
        if (followUp) {
            return "Follow-up visit";
        }
        return "Initial consultation";
    }
    @Override
    public void performAppointment() {
        System.out.println("Performing a scheduled regular appointment..");
    }

    public void setVisitType(String visitType){
        if(visitType.isEmpty()){
            throw new IllegalArgumentException("visit type cannot be empty");
        }else{
            this.visitType = visitType;
        }
    }
    public String getVisitType(){
        return  visitType;
    }
    public void setFollowUp(boolean followUp){
        this.followUp = followUp;
    }
    public boolean getFollowUp (){
        return  followUp;
    }



}

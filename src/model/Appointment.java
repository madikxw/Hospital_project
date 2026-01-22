package model;
public  abstract class Appointment {
    protected int Appointment_id;
    protected String Date;
    protected String Time;
    protected String Status;
    public Appointment(int Appointment_id,
                       String Date,
                       String Time,
                       String Status){
        this.Appointment_id = Appointment_id;
        this.Date = Date;
        this.Time = Time;
        this.Status = Status;
    }


    public String getAppointmentType() {
        return "General Appointment";
    }
    public int getPriority() {
        return 1;  //lowest
    }

    public abstract void performAppointment();








    public void setAppointment_id(int appointment_id) {
        if(appointment_id <=0){
            throw new IllegalArgumentException("Id cannot be negative or 0");
        }else{
            this.Appointment_id = appointment_id;

        }
    }

    public int getAppointment_id() {
        return Appointment_id;
    }

    public void setDate(String date) {
        if(date == null && date.isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty");
        }else{
            this.Date = date;
        }
    }

    public String getDate() {
        return Date;
    }

    public void setTime(String time) {
        if(time == null && time.isEmpty()){
            throw new IllegalArgumentException("time cannot be empty");
        }
        else{
            this.Time = time;
        }
    }
    public String getTime(){
        return Time;
    }

    public void setStatus(String status) {
        if(status == null && status.isEmpty()){
            throw new IllegalArgumentException("status cannot be empty");
        }
        this.Status = status;
    }

    public String getStatus() {
        return Status;
    }

}

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void demonstratePolymorphism() {
        for (Appointment a : appointments) {
            a.performAppointment(); 
        }
    }
    public static void addEmergencyAppointment() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Appointment ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Date: ");
        String date = scan.nextLine();

        System.out.print("Time: ");
        String time = scan.nextLine();

        System.out.print("Severity level (1–5): ");
        int severity = scan.nextInt();

        System.out.print("Ambulance required? (true/false): ");
        boolean ambulance = scan.nextBoolean();
        scan.nextLine();

        System.out.print("Status: ");
        String status = scan.nextLine();

        appointments.add(
                new EmergencyAppointment(id, date, time, severity, ambulance, status)
        );

        System.out.println("🚨 Emergency appointment added");
    }
    public static void viewEmergencyAppointments() {
        for (Appointment a : appointments) {
            if (a instanceof EmergencyAppointment) {
                EmergencyAppointment e = (EmergencyAppointment) a;
                System.out.println(e.getAppointmentType() +
                        " | Risk: " + e.assessRiskLevel());
            }
        }
    }

    public static void addRegularAppointment() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Appointment ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Date: ");
        String date = scan.nextLine();

        System.out.print("Time: ");
        String time = scan.nextLine();

        System.out.print("Status: ");
        String status = scan.nextLine();

        System.out.print("Is follow-up? (true/false): ");
        boolean followUp = scan.nextBoolean();
        scan.nextLine();

        System.out.print("Visit type: ");
        String visitType = scan.nextLine();

        appointments.add(
                new RegularAppointment(id, date, time, followUp, visitType, status)
        );

        System.out.println("✅ Regular appointment added");
    }

    public static void addAppointment() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Appointment ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Date: ");
        String date = scan.nextLine();

        System.out.print("Time: ");
        String time = scan.nextLine();

        System.out.print("Status: ");
        String status = scan.nextLine();

        Appointment a = new Appointment(id, date, time, status);
        appointments.add(a);

        System.out.println("✅ General appointment added");
    }
    public static void viewAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments yet.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println("Type: " + a.getAppointmentType());
            System.out.println("Priority: " + a.getPriority());
            a.performAppointment(); // POLYMORPHISM
            System.out.println("----------------");
        }
    }


    public static   void addPatient(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Patient ID: ");
        int patientId = scan.nextInt();
        scan.nextLine();
        System.out.print("Patient Name: ");
        String patientName = scan.nextLine();
        System.out.println("Patient Age:");
        int patient_age = scan.nextInt();
        scan.nextLine();
        System.out.print("Patient Disease: ");
        String patientDisease = scan.nextLine();

        System.out.print("Does he/her has insurance? (yes/no): ");
        String  hasInsurance = scan.nextLine();


        Patient pat1  = new Patient(patientId, patientName,patient_age,patientDisease,hasInsurance);
       patients.add(pat1);
        System.out.println("\n✅ Patient has successfully  added !");
    }


    public static void viewAllPatient(){
        System.out.println("\n====================");
        System.out.println("ALL PATIENTS ");
        System.out.println("====================");
        if (patients.isEmpty()){
            System.out.println("we dont have patients yet🥲");
            return;
        }
        System.out.println("total number of patients:"+ patients.size());
        System.out.println();
        for(int i = 0; i< patients.size();i++){
            Patient patient =  patients.get(i);
            System.out.println((i+1) + "." +  "   Patient age: "  + patient.getPatient_age() + "  Patient Name :" + patient.getPatientName() + "  Patient Disease: " + patient.getPatientDisease() + " " + "has insurance: "+  patient.getHasInsurance());

        }
    }

    public static  void addDoctor(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Doctor ID:");
        int doctorId = scan.nextInt();
        scan.nextLine();
        System.out.println("Doctor Name:");
        String DoctorName = scan.nextLine();
        System.out.println("Doctor specialization:");
        String specialization = scan.nextLine();
        System.out.println("Doctor experience:");
        int experienceYears = scan.nextInt();
        scan.nextLine();

        Doctor doc1 = new Doctor(doctorId,DoctorName, experienceYears, specialization);
        doctors.add(doc1);
        System.out.println("\n✅ Doctor has successfully  added !");
    }
    public static  void viewAllDoctor(){
        System.out.println("\n===============");
        System.out.println("ALL DOCTORS");
        System.out.println("==============");
        if(doctors.isEmpty()){
            System.out.println("we dont have patients yet🥲");
            return;
        }
        for(int i =0;i<doctors.size();i++){
            Doctor doctor = doctors.get(i);
            System.out.println((i+1) + "." +  "   Doctor id: "  + doctor.getDoctorId() + "  Doctor Name " + doctor.getDoctorName() + "  Doctor's experience: " + doctor.getExperienceYears() + " " + "Doctor's specialization: "+ doctor.getExperienceInfo());

        }
    }

    public static void DisplayMenu(){
        System.out.println("\n======================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM ");
        System.out.println("======================");
        System.out.println("1.Add New Patient");
        System.out.println("2. View All Patients");
        System.out.println("3.Add New Doctor");
        System.out.println("4.View All Doctors");
        System.out.println("5. Add General Appointment");
        System.out.println("6. Add Regular Appointment");
        System.out.println("7. Add Emergency Appointment");
        System.out.println("8. View All Appointments");
        System.out.println("9. View Emergency Appointments");
        System.out.println("10. demonstratePolymorphism");
        System.out.println("11.Exit");
        System.out.println("======================");
        System.out.print("Enter your choice:");
    }


    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors= new ArrayList<>();
    private static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private  static  ArrayList<Appointment> appointments = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        doctors.add(new Doctor(1, "Alice Brown", 5, "Neurologist"));
        doctors.add(new Doctor(2, "John Smith", 10, "Cardiologist"));
        patients.add(new Patient(1, "Tom Hardy", 30, "Flu", "yes"));
        patients.add(new Patient(2, "Anna Lee", 25, "Cold", "no"));
        appointments.add(new Appointment(1,"12.04.2024","13-00","Completed"));
        appointments.add(new RegularAppointment(2, "12.04.2024", "14:00", false, "Consultation", "sceduled"));
        appointments.add( new EmergencyAppointment(3,"09.09.2023","15-00",4, true,"Critical"));






        //menu loop
        boolean running_menu = true;
        while(running_menu){
            DisplayMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                   addPatient();
                   break;
                case 2:
                    viewAllPatient();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewAllDoctor();
                    break;
                case 5:
                    addAppointment();
                    break;
                case 6:
                    addRegularAppointment();
                    break;
                case 7:
                    addEmergencyAppointment();
                    break;
                case 8:
                    viewAllAppointments();
                    break;
                case 9:
                    viewEmergencyAppointments();
                    break;
                case 10:
                    demonstratePolymorphism();
                    break;

                case 11:
                    System.out.println("Goodbye 👋");
                    running_menu = false;
                    break;
                default:
                    System.out.println("\n ERROR: INVALID CHOICE❌");



            }
            if(running_menu){
                System.out.println("\n Press enter to continue...");
                scan.nextLine();

            }

        }
        scan.close();











        // About Medical Record

        MedicalRecord record1 = new MedicalRecord("01", 1000.2);
        record1.setHasInsurance(true);
        record1.setNotes("Routine check-up");

        System.out.println("Notes: " + record1.getNotes());
        System.out.println(record1.toString());

    }
}
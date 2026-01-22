package menu;
import model.*;

import java.util.Scanner;
import java.util.ArrayList;

 public class HospitalMenu implements Menu {
     private static ArrayList<Patient> patients = new ArrayList<>();
     private static ArrayList<Doctor> doctors = new ArrayList<>();
     private static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
     private static ArrayList<Appointment> appointments = new ArrayList<>();
     private Scanner scanner;
     public HospitalMenu() {
         scanner = new Scanner(System.in);
     }
     
     @Override
     public void run(){
         boolean running_time = true;
         while(running_time){
             DisplayMenu();
             try{
                 int choice = scanner.nextInt();
                 scanner.nextLine();
                 switch(choice) {
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
                         addRegularAppointment();
                         break;
                     case 6:
                         addEmergencyAppointment();
                         break;
                     case 7:
                         viewAllAppointments();
                         break;
                     case 8:
                         viewEmergencyAppointments();
                         break;
                     case 9:
                         demonstratePolymorphism();
                         break;
                     case 10:
                         running_time = false;
                         System.out.println("👋Goodbye!");
                     default:
                         System.out.println("\n ❌ERROR: INVALID CHOICE");
                         break;
                 }
                 if(running_time){
                     System.out.println("Enter the choice:");
                     scanner.nextLine();

                 }
             }
             catch (Exception e ){
                 System.out.println("🚨Invalid input!");
                 scanner.nextLine();

             }
         }
     }

     @Override
     public void DisplayMenu() {
         System.out.println("\n======================");
         System.out.println(" HOSPITAL MANAGEMENT SYSTEM ");
         System.out.println("======================");
         System.out.println("1.AddPatient");
         System.out.println("2. View All Patients");
         System.out.println("3.Add Doctor");
         System.out.println("4.View All Doctors");
         System.out.println("5. Add Regular Appointment");
         System.out.println("6. Add Emergency Appointment");
         System.out.println("7. View All Appointments");
         System.out.println("8. View Emergency Appointments");
         System.out.println("9. demonstratePolymorphism");
         System.out.println("10.Exit");
         System.out.println("======================");
         System.out.print("Enter your choice:");
     }


     public static void demonstratePolymorphism() {
         for (Appointment a : appointments) {
             a.performAppointment();
         }
     }

     public static void addEmergencyAppointment() {
         Scanner scan = new Scanner(System.in);
         try {
             System.out.print(" Appointment ID: ");
             int id = scan.nextInt();
             scan.nextLine();

             System.out.print("Date: ");
             String date = scan.nextLine();

             System.out.print("Time: ");
             String time = scan.nextLine();

             System.out.print("Severity level (1–5): ");
             int severity = scan.nextInt();
             if (severity < 1 || severity > 5) {
                 throw new IllegalArgumentException("You can chose only in range between 1 and 5 ");
             }

             System.out.print("Ambulance required? (true/false): ");
             boolean ambulance = scan.nextBoolean();
             scan.nextLine();

             System.out.print("Status: ");
             String status = scan.nextLine();

             appointments.add(
                     new EmergencyAppointment(id, date, time, severity, ambulance, status)
             );

             System.out.println("🚨 Emergency appointment added");

         } catch (IllegalArgumentException e) {
             System.out.println("ERROR : " + e.getMessage());

         } catch (Exception e) {
             System.out.println("ERROR: invalid input type");
             scan.nextLine();
         }


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

         System.out.print("Regular Appointment ID: ");
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


     public static void addPatient() {
         Scanner scan = new Scanner(System.in);
         try {

             System.out.print("Patient ID: ");
             int patientId = scan.nextInt();
             if (patientId <= 0) {
                 throw new IllegalArgumentException("ID cannot be neagtive or zero");
             }
             scan.nextLine();
             System.out.print("Patient Name: ");
             String patientName = scan.nextLine();
             if (patientName.isEmpty()) {
                 throw new IllegalArgumentException("Name cannot be empty");
             }

             System.out.println("Patient Age:");
             int patient_age = scan.nextInt();
             scan.nextLine();
             if (patient_age < 0) {
                 throw new IllegalArgumentException("Age cannot be negative");
             }

             System.out.print("Patient Disease:");
             String patientDisease = scan.nextLine();

             System.out.print("Does he/her has insurance? (yes/no): ");
             String hasInsurance = scan.nextLine();

             Patient pat1 = new Patient(patientId, patientName, patient_age, patientDisease, hasInsurance);
             patients.add(pat1);
             System.out.println("\n✅Patient has successfully  added !");
         } catch (IllegalArgumentException e) {
             System.out.println("ERROR: " + e.getMessage());
         } catch (Exception e) {
             System.out.println("ERROR : invalid input type");
             scan.nextLine();
         }

     }


     public static void viewAllPatient() {
         System.out.println("\n====================");
         System.out.println("ALL PATIENTS ");
         System.out.println("====================");
         if (patients.isEmpty()) {
             System.out.println("we dont have patients yet🥲");
             return;
         }
         System.out.println("total number of patients:" + patients.size());
         System.out.println();
         for (int i = 0; i < patients.size(); i++) {
             Patient patient = patients.get(i);
             System.out.println((i + 1) + "." + "  Patient age: " + patient.getPatient_age() + " Patient Name :" + patient.getPatientName() + " Patient Disease: " + patient.getPatientDisease() + " " + "has insurance: " + patient.getHasInsurance());

         }
     }

     public static void addDoctor() {
         Scanner scan = new Scanner(System.in);

         try {
             System.out.println("Doctor ID:");
             int doctorId = scan.nextInt();
             scan.nextLine();
             if (doctorId <= 0) {
                 throw new IllegalArgumentException("ID cannot be negative or zero");
             }
             System.out.println("Doctor Name:");
             String DoctorName = scan.nextLine();
             if (DoctorName.isEmpty()) {
                 throw new IllegalArgumentException("Name cannot be empty ");
             }
             System.out.println("Doctor specialization:");
             String specialization = scan.nextLine();
             System.out.println("Doctor experience:");
             int experienceYears = scan.nextInt();
             scan.nextLine();

             Doctor doc1 = new Doctor(doctorId, DoctorName, experienceYears, specialization);
             doctors.add(doc1);
             System.out.println("\n✅ Doctor has successfully  added !");
         } catch (IllegalArgumentException e) {
             System.out.println("ERROR: " + e.getMessage());
         } catch (Exception e) {
             System.out.println("ERROR: invalid input type");
             scan.nextLine();
         }
     }

     public static void viewAllDoctor() {
         System.out.println("\n===============");
         System.out.println("ALL DOCTORS");
         System.out.println("==============");
         if (doctors.isEmpty()) {
             System.out.println("we dont have patients yet🥲");
             return;
         }
         for (int i = 0; i < doctors.size(); i++) {
             Doctor doctor = doctors.get(i);
             System.out.println((i + 1) + "." + "  Doctor id: " + doctor.getDoctorId() + " Doctor Name " + doctor.getDoctorName() + " Doctor's experience: " + doctor.getExperienceYears() + " " + "Doctor's specialization: " + doctor.getExperienceInfo());

         }
     }





 }

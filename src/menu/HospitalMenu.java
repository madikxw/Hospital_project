package menu;

import Database.*;
import Database.hidden.AppointmentDAO;
import Database.hidden.PatientDAO;
import model.*;

import java.util.Scanner;

public class HospitalMenu implements Menu {

    private Scanner scanner;

    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;
    private AppointmentDAO appointmentDAO;

    public HospitalMenu() {
        this.scanner = new Scanner(System.in);
        this.patientDAO = new PatientDAO();
        this.doctorDAO = new DoctorDAO();
        this.appointmentDAO = new AppointmentDAO();
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            DisplayMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> viewAllPatients();
                    case 3 -> addDoctor();
                    case 4 -> viewAllDoctors();
                    case 5 -> addRegularAppointment();
                    case 6 -> addEmergencyAppointment();
                    case 7 -> viewAllAppointments();
                    case 8 -> viewEmergencyAppointments();
                    case 9 -> demonstratePolymorphism();
                    case 10 -> running = false;

                    case 11 -> updateDoctor();
                    case 12 -> deleteDoctor();
                    case 13 -> searchDoctorByName();
                    case 14 -> searchDoctorByExperience();

                    default -> System.out.println("❌ Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("🚨 Invalid input");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void DisplayMenu() {
        System.out.println("""
    ======================
    HOSPITAL MANAGEMENT SYSTEM
    ======================
    1. Add Patient
    2. View All Patients
    3. Add Doctor
    4. View All Doctors
    5. Add Regular Appointment
    6. Add Emergency Appointment
    7. View All Appointments
    8. View Emergency Appointments
    9. Demonstrate Polymorphism
    10. Exit
    ----------------------
    11. Update Doctor
    12. Delete Doctor
    13. Search Doctor by Name
    14. Search Doctor by Experience
    ======================
    """);
        System.out.print("Enter choice: ");
    }



    private void addPatient() {
        System.out.print("Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Disease: ");
        String disease = scanner.nextLine();

        System.out.print("Has insurance (true/false): ");
        boolean insurance = scanner.nextBoolean();

        patientDAO.insertPatient(new Patient(id, name, age, disease, insurance));
    }

    private void viewAllPatients() {
        patientDAO.getAllPatients();
    }



    private void addDoctor() {
        System.out.print("Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        doctorDAO.InsertDoctor(new Doctor(id, name, exp,specialization));
    }

    private void viewAllDoctors() {
        doctorDAO.getAllDoctor();
    }

    private void updateDoctor() {
        System.out.print("Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New name: ");
        String name = scanner.nextLine();

        System.out.print("New specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("New experience: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        doctorDAO.Updatedoctor(new Doctor(id, name, exp,specialization));
    }

    private void deleteDoctor() {
        System.out.print("Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        doctorDAO.DeleteDoctor(id);
    }

    private void searchDoctorByName() {
        System.out.print("Search name: ");
        String name = scanner.nextLine();
        doctorDAO.SearchByname(name);
    }
    private void searchDoctorByExperience() {
        System.out.print("Enter minimum experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        doctorDAO.SearchByExperience(exp);
    }



    private void addRegularAppointment() {
        appointmentDAO.insertRegularAppointment(scanner);
    }

    private void addEmergencyAppointment() {
        appointmentDAO.insertEmergencyAppointment(scanner);
    }

    private void viewAllAppointments() {
        appointmentDAO.getAllAppointments();
    }

    private void viewEmergencyAppointments() {
        appointmentDAO.getEmergencyAppointments();
    }

    private void demonstratePolymorphism() {
        appointmentDAO.performAllAppointments();
    }
}
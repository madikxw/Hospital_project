package menu;

import Database.*;
import Database.hidden.AppointmentDAO;
import Database.hidden.PatientDAO;
import model.*;

import java.util.List;
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
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        viewAllPatients();
                        break;
                    case 3:
                        addDoctor();
                        break;
                    case 4:
                        viewAllDoctors();
                        break;
                    case 5 :
                        addRegularAppointment();
                        break;
                    case 6 :
                        addEmergencyAppointment();
                        break;
                    case 7 :
                        viewAllAppointments();
                        break;
                    case 8 :
                        viewEmergencyAppointments();
                        break;
                    case 9 :
                        demonstratePolymorphism();
                        break;
                    case 10 :
                        running = false;
                    case 11 :
                        updateDoctor();
                        break;
                    case 12 :
                        deleteDoctor();
                        break;

                    case 13 :
                        searchDoctorByName();
                        break;

                    case 14 : searchDoctorByMinExperience();
                    break;


                    default :
                        System.out.println("❌ Invalid choice");
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
    14. Search Doctor by min Experience
   
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
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }

    private void viewAllPatients() {
        patientDAO.getAllPatients();
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();

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
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }
    private void viewAllDoctors() {
        doctorDAO.getAllDoctor();
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
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
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();

    }
    private void deleteDoctor() {
        System.out.print("Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        doctorDAO.DeleteDoctor(id);
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }

    private void searchDoctorByName() {
        System.out.print("Search name: ");
        String name = scanner.nextLine();
        doctorDAO.SearchByname(name);
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }
    private void searchDoctorByExperience() {
        System.out.print("Enter minimum experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        doctorDAO.searchByMinExperience(exp);
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();

    }

    private void addRegularAppointment() {
        appointmentDAO.insertRegularAppointment(scanner);
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }
    private void addEmergencyAppointment() {
        appointmentDAO.insertEmergencyAppointment(scanner);
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();

    }

    private void viewAllAppointments() {
        appointmentDAO.getAllAppointments();
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }

    private void viewEmergencyAppointments() {
        appointmentDAO.getEmergencyAppointments();
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();

    }

    private void demonstratePolymorphism() {
        appointmentDAO.performAllAppointments();
        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }
    private void searchDoctorByMinExperience() {
        System.out.print("Enter minimum experience years: ");
        int minExp = scanner.nextInt();
        scanner.nextLine();
        List<Doctor> doctors = doctorDAO.searchByMinExperience(minExp);
        if (doctors.isEmpty()) {
            System.out.println("No doctors found");
        } else {
            for (Doctor d : doctors) {
                System.out.println("ID: " + d.getDoctorId());
                System.out.println("Name: " + d.getDoctorName());
                System.out.println("Specialization: " + d.getSpecialization());
                System.out.println("Experience: " + d.getExperienceYears());
                System.out.println("----------------------");
            }
        }

        System.out.println("Нажми Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }


}
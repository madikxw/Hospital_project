import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // About Doctor
        Doctor doc1 = new Doctor("01", "Azamat", 10, "Surgeon");

        System.out.println(doc1.toString());
        System.out.println();

        // About Patient

        System.out.print("Patient ID: ");
        int patientId = scan.nextInt();
        scan.nextLine(); // Consume leftover newline

        System.out.print("Patient Name: ");
        String patientName = scan.nextLine();

        System.out.print("Patient Disease: ");
        String patientDisease = scan.nextLine();

        System.out.print("Do you have insurance? (yes/no): ");
        String input = scan.nextLine();
        boolean hasInsurance;

        if (input.equalsIgnoreCase("yes")) {
            hasInsurance = true;
        } else if (input.equalsIgnoreCase("no")) {
            hasInsurance = false;
        } else {
            System.out.println("Invalid input");
            return;
        }

        Patient pat1 = new Patient(patientId, patientName, hasInsurance);
        pat1.setPatientDisease(patientDisease);


        System.out.println(pat1.toString());
        System.out.println("Patient Disease: " + pat1.getPatientDisease());
        System.out.println();

        // About Medical Record

        MedicalRecord record1 = new MedicalRecord("01", 1000.2);
        record1.setHasInsurance(true); // setter automatically updates discount
        record1.setNotes("Routine check-up");

        System.out.println("Notes: " + record1.getNotes());
        System.out.println(record1.toString());
    }
}
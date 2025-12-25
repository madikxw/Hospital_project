import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //about doctor

        Doctor doc1 = new Doctor("01", "azamat", 10, "surgeon");
        System.out.println(doc1.toString());


        //about  patient
        Scanner scan = new Scanner(System.in);
        System.out.println("ID patient:");
        int patientId = scan.nextInt();
        scan.nextLine();
        System.out.println("Name patient:");
        String patientName = scan.nextLine();
        System.out.println("Patient disease:");
        String patientDisease = scan.nextLine();
        System.out.println("do ypu have any insurance?'\n(yes/no) ");
        String input = scan.nextLine();
        boolean has_insurance;

        if (input.equalsIgnoreCase("yes")) {
            has_insurance = true;
        } else if (input.equalsIgnoreCase("no")) {
            has_insurance = false;
        } else {
            System.out.println("Invalid input");
            return;
        }
        Patient pat1 = new Patient(patientId, patientName, has_insurance);
        pat1.setPatientDisease("curring");
        System.out.println(pat1.toString());
        System.out.println(pat1.getPatientDisease());
        System.out.println("\n");


        //about medical record

        MedicalRecord record1 = new MedicalRecord("01", 1000.2);
        record1.setHas_Insurance(true);
        record1.set_notes("Dwdw");
        System.out.println(record1.getNotes());
        record1.discount();
        System.out.println(record1.toString());


    }
}
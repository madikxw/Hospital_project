import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Doctor doc1 = new Doctor("01", "azamat", 10, "surgeon");
        System.out.println(doc1.toString());
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
        if (input.equals("yes")) {
            has_insurance = true;
        } else {
            if (!input.equals("no")) {
                System.out.println("Invalid input");
                return;
            }

            has_insurance = false;
        }

        Patient pat1 = new Patient(patientId, patientName, patientDisease, has_insurance);
        System.out.println(pat1.toString());
    }
}
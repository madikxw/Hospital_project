package Database.hidden;

import Database.DatabaseConnection;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AppointmentDAO {


    public void insertRegularAppointment(Scanner scanner) {

        String sql = """
                INSERT INTO appointment
                (appointment_id, date, time, type, status, follow_up, visit_type)
                VALUES (?, ?, ?, 'REGULAR', ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();

        try {
            System.out.print("Appointment ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Date: ");
            String date = scanner.nextLine();

            System.out.print("Time: ");
            String time = scanner.nextLine();

            System.out.print("Status: ");
            String status = scanner.nextLine();

            System.out.print("Follow-up (true/false): ");
            boolean followUp = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("Visit type: ");
            String visitType = scanner.nextLine();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.setString(4, status);
            ps.setBoolean(5, followUp);
            ps.setString(6, visitType);

            ps.executeUpdate();
            ps.close();

            System.out.println("✅ Regular appointment added");

        } catch (Exception e) {
            System.out.println("❌ Failed to add regular appointment");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


    public void insertEmergencyAppointment(Scanner scanner) {

        String sql = """
                INSERT INTO appointment
                (appointment_id, date, time, type, status, severity, ambulance_required)
                VALUES (?, ?, ?, 'EMERGENCY', ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();

        try {
            System.out.print("Appointment ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Date: ");
            String date = scanner.nextLine();

            System.out.print("Time: ");
            String time = scanner.nextLine();

            System.out.print("Status: ");
            String status = scanner.nextLine();

            System.out.print("Severity (1–5): ");
            int severity = scanner.nextInt();

            System.out.print("Ambulance required (true/false): ");
            boolean ambulance = scanner.nextBoolean();
            scanner.nextLine();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.setString(4, status);
            ps.setInt(5, severity);
            ps.setBoolean(6, ambulance);

            ps.executeUpdate();
            ps.close();

            System.out.println("🚨 Emergency appointment added");

        } catch (Exception e) {
            System.out.println("❌ Failed to add emergency appointment");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


    public void getAllAppointments() {

        String sql = "SELECT * FROM appointment";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                System.out.println(
                        rs.getInt("appointment_id") + " | " +
                                rs.getString("type") + " | " +
                                rs.getString("date") + " " +
                                rs.getString("time") + " | status: " +
                                rs.getString("status")
                );
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("❌ Failed to load appointments");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


    public void getEmergencyAppointments() {

        String sql = "SELECT * FROM appointment WHERE type = 'EMERGENCY'";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();



            while (rs.next()) {
                System.out.println(
                        rs.getInt("appointment_id") + " | " +
                                "Severity: " + rs.getInt("severity") +
                                " | Ambulance: " + rs.getBoolean("ambulance_required")
                );
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("❌ Failed to load emergency appointments");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void performAllAppointments() {

        String sql = "SELECT * FROM appointment";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");

                Appointment appointment;

                if (type.equals("EMERGENCY")) {
                    appointment = new EmergencyAppointment(
                            rs.getInt("appointment_id"),
                            rs.getString("date"),
                            rs.getString("time"),
                            rs.getInt("severity"),
                            rs.getBoolean("ambulance_required"),
                            rs.getString("status")
                    );
                } else {
                    appointment = new RegularAppointment(
                            rs.getInt("appointment_id"),
                            rs.getString("date"),
                            rs.getString("time"),
                            rs.getBoolean("follow_up"),
                            rs.getString("visit_type"),
                            rs.getString("status")
                    );
                }

                appointment.performAppointment();
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("❌ Polymorphism demo failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
package Database.hidden;

import Database.DatabaseConnection;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {

    public void insertPatient(Patient patient) {

        String sql = " INSERT INTO patient (patient_id, name, age, disease, has_insurance)  VALUES (?, ?, ?, ?,)  ";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getPatientName());
            ps.setInt(3, patient.getPatient_age());
            ps.setString(4, patient.getPatientDisease());
            ps.setBoolean(5, patient.getHasInsurance());

            ps.executeUpdate();
            ps.close();

            System.out.println("✅ Patient inserted successfully");

        } catch (Exception e) {
            System.out.println("❌ Failed to insert patient");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllPatients() {

        String sql = "SELECT * FROM patient";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                System.out.println(rs.getInt("patient_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("disease") + " | insurance: " +
                                rs.getBoolean("has_insurance"));
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("❌ Failed to load patients");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
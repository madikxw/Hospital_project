package Database;
import java.util.List;
import java.util.ArrayList;
import model.Doctor;
import java.sql.ResultSet;
import java.sql.*;
public class DoctorDAO{
    public void InsertDoctor(Doctor doctor){
        String sql = "INSERT INTO doctor(doctor_id,name,experience_years,specialization) VALUES(?,?,?,?)";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, doctor.getDoctorId());
            statement.setString(2, doctor.getDoctorName());
            statement.setInt(3,doctor.getExperienceYears());
            statement.setString(4, doctor.getSpecialization());
            int Rows = statement.executeUpdate();
            if(Rows >0){
                System.out.println("successfully added");
            }
            statement.close();
        }catch(SQLException e ){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


    public void getAllDoctor(){
        String sql = "SELECT * FROM doctor";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("doctor_id");
                String name = resultSet.getString("name");
                int experience_years = resultSet.getInt("experience_years");
                String specialization  = resultSet.getString("specialization");
                System.out.println("ID:" + id);
                System.out.println("name: "+name);
                System.out.println("experience: "+experience_years);
                System.out.println("specialization: "+ specialization);
            }
            resultSet.close();
            statement.close();

        }catch (SQLException e ){
            System.out.println("ERROR");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }


    public void SearchByname(String name){
        String sql = "SELECT * FROM doctor WHERE name ILIKE ?";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("doctor_id"));
                System.out.println("NAME: "+ resultSet.getString("name"));
                System.out.println("specialization: "+resultSet.getString("specialization"));
                System.out.println("experience: "+ resultSet.getInt("experience_years"));
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e ){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

    }


    public boolean Updatedoctor(Doctor doctor){
        String sql = "UPDATE dcotor SET name = ?,specialization = ?,experience_years = ? WHERE doctor_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if(connection ==null){
            System.out.println("error");
            return  false;
        }
        try{
            PreparedStatement sd = connection.prepareStatement(sql);
            sd.setString(1,doctor.getDoctorName());
            sd.setString(2, doctor.getSpecialization());
            sd.setInt(3,doctor.getExperienceYears());
            sd.setInt(4,doctor.getDoctorId());

        }catch (SQLException e ){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;

    }


    public void DeleteDoctor(int id){
        String sql = "DELETE *FROM doctor WHERE doctor_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            if(row>0){
                System.out.println("success");
            }
            statement.close();

        }catch (SQLException e ){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public List<Doctor> searchByMinExperience(int minExperience) {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor WHERE experience_years >= ? ORDER BY experience_years DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.out.println("connection failed");
            return doctors;
        }

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, minExperience);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setDoctorName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setExperienceYears(rs.getInt("experience_years"));
                doctors.add(doctor);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return doctors;
    }

}
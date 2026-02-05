package Database;
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
                String spicalization  = resultSet.getString("specalization");
                System.out.println("ID:" + id);
                System.out.println("name: "+name);
                System.out.println("experience: "+experience_years);
                System.out.println("specialization"+ spicalization);
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
        String sql = "SELECT *FROM doctor where  ILIKE name = ?";
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
        String sql = "UPDATE doctor SET name = ?, specialization = ? ,experience_years = ? WHERE doctor_id = ? ";
        Connection connection = DatabaseConnection.getConnection();
        if(connection ==null){
            return false;
        }
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setInt(3,doctor.getExperienceYears());
            ps.setInt(4,doctor.getDoctorId());
            int rows = ps.executeUpdate();
            ps.close();
            if(rows >0){
                System.out.println("successfully added");
                return  true;
            }

        } catch(SQLException e ){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
        return  false;
    }
    public void DeleteDoctor(int id){
        String sql = "DELETE* FROM doctor WHERE doctor_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int rows = statement.executeUpdate();
            if(rows>0){
                System.out.println("successfully deleted");
            }else{
                System.out.println("error");
            }


        }catch (SQLException e ){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }

    }

    public void SearchByExperience(int minYears){
        String sql = "SELECT*FROM doctor where experience_years >=?";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,minYears);
            ResultSet resultSet = statement.executeQuery();
            boolean found = false;
            while(resultSet.next()){
                found = true;
                System.out.println("ID: "+ resultSet.getInt("doctor_id"));
                System.out.println("name: "+ resultSet.getString("name"));
                System.out.println("specialization: "+ resultSet.getString("specialization"));
                System.out.println("Experience:" + resultSet.getInt("experience_years"));
            }
            if(!found){
                System.out.println("sorry didnt found");
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

}
package Database;
import model.Doctor;


public class testInsert {
    public static void main(String[] args){
        Doctor doc2 = new Doctor(1,"madiyar",3,"surgey");
        DoctorDAO dao = new DoctorDAO();
        dao.InsertDoctor(doc2);
    }
}

package src.DAO;
import src.Models.*;
interface StudentDAO {
    public void addStudent(Student student);
    public Student getStudentById(int id);
}

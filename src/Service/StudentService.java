package src.Service;
import java.util.ArrayList;
import java.util.List;

import src.Models.Student;
public class StudentService {

    private List<Student> students=new ArrayList<>();

    public void add_students(Student student){
        students.add(student);
    }
    public List<Student> get_allStudents(){
        return students;
    }
    
}
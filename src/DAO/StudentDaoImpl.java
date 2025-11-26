package src.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.Models.*;
import src.utils.DatabaseConnections;
public class StudentDaoImpl implements StudentDAO {

    Connection conn=null;
    PreparedStatement stu=null;
    PreparedStatement det=null;
    PreparedStatement loc=null;
    PreparedStatement skill=null;
    @Override
    public void addStudent(Student student) {
        try{

            conn=DatabaseConnections.getConnection();

            String inStu="insert into students(name,email) values(?,?)";
            stu=conn.prepareStatement(inStu,PreparedStatement.RETURN_GENERATED_KEYS);
            stu.setString(1, student.getName());
            stu.setString(2, student.getEmail());
            stu.executeUpdate();

            ResultSet rs=stu.getGeneratedKeys();
            int stuId=0;
            while(rs.next()){
                stuId=rs.getInt(1);
            }
            

            stuDet detail=student.getDetail();
            String inDet="insert into Student_detail(Student_id,phone_number,Secondary_email) values (?,?,?)";
            det=conn.prepareStatement(inDet,PreparedStatement.RETURN_GENERATED_KEYS);
            det.setInt(1,stuId);
            det.setString(2, detail.getPhno());
            det.setString(3, detail.getSecEmail());
            det.executeUpdate();

            Location location=detail.getLocation();
            String inLoc="insert into Student_Location(Student_id,city,district,pincode,state,country)"+
            "values(?,?,?,?,?)";
            loc=conn.prepareStatement(inLoc);
            loc.setInt(1,stuId);
            loc.setString(2, location.getCity());
            loc.setString(3, location.getDistrict());
            loc.setInt(4, location.getPincode());
            loc.setString(5, location.getState());
            loc.setString(6, location.getCountry());
            loc.executeUpdate();
            
        } catch(Exception e){
            System.out.print("Error adding student: "+e.getMessage());
 
        }
    }

    public void Show_All_Students(){
        
    }

    @Override
    public Student getStudentById(int id) {
        try{
            conn=DatabaseConnections.getConnection();
            String getStu="select * from students where student_id=?";
            stu=conn.prepareStatement(getStu);
            stu.setInt(1, id);
            ResultSet rs=stu.executeQuery();
            Student student=new Student();
            while(rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
            }
            return student;
        } catch(Exception e){
            System.out.print("Error fetching student: "+e.getMessage());
            return null;
        }
    }
}

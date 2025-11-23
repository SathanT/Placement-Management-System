package src.Controller;
import java.util.*;

import src.Service.*;
import src.Models.Student;
import src.Models.Company;

public class Controller {

    private StudentService stuSer;
    private CompanyService comSer;
    private StudentFilter stuFil;
    private CompanyFilter comFil;
    
    public Controller(){
        stuSer=new StudentService();
        comSer=new CompanyService();
        stuFil=new StudentFilter();
        comFil=new CompanyFilter();

    }

    public StudentService getStuSer() {
        return stuSer;
    }

    public CompanyService getComSer() {
        return comSer;
    }

    public StudentFilter getStuFil() {
        return stuFil;
    }

    public CompanyFilter getComFil() {
        return comFil;
    }

    public List<Company> Filter_By_Student_skill(Student student){

        List<Company> filtered=stuFil.Skill_Match_Company(student,comSer.get_Companies());
        return filtered;

    }
    public List<Company> Filter_By_Student_Lpa(int start,int end){

        List<Company> filtered=stuFil.LPA_filter(start,end,comSer.get_Companies());
        return filtered;

    }
    public List<Company> Filter_By_Student_Role(String role){

        List<Company> filtered=stuFil.Role_filter(role,comSer.get_Companies());
        return filtered;

    }
     public List<Student> Filter_By_Company(Company company){
        List<Student> filtered=comFil.Skill_filter(company,stuSer.get_allStudents());
        return filtered;
     }
    
}

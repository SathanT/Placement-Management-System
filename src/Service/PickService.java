package src.Service;
import java.util.*;

import src.Models.Company;
import src.Models.Student;
import src.Models.stuDet;
import src.Models.JobDetails;
import src.Models.Location;
public class PickService {
    
    public void StudentPick(List<Student> students,int index){
        Student choosed=students.get(index-1);
        stuDet detail=choosed.getDetail();
        System.out.println("---------------Choosed Student------------");
        System.out.println("Student ID  :  "+choosed.getId());
        System.out.println("Student Name  :  "+choosed.getName());
        System.out.println("Student EmailId  :  "+choosed.getEmail());
        System.out.println("Student ID  :  "+detail.getPhno());
        System.out.println("Student ID  :  "+detail.getSecEmail());
    }

    public void CompanyPick(List<Company> companies,int index){
        Company com=companies.get(index);
        JobDetails jd=com.getDet();
        Location loc=com.getLocation();

        System.out.println("-------------Choosed Comapny-----------");
        System.out.println("Company ID  :  "+com.getId());
        System.out.println("Company Name  :  "+com.getName());
        System.out.println("Role  :  "+jd.getRole());
        System.out.println("LPA  :  "+jd.getLpa());
        System.out.println("InterShip Duration  :  "+jd.getInternDur());
        System.out.println("Inter Stiphen  :  "+jd.getStiphen());
        System.out.println("Company Location  :  "+loc.getCity());

    }
}

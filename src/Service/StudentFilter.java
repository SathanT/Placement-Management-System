package src.Service;

import java.util.ArrayList;
import java.util.List;

import src.Models.Company;
import src.Models.JobDetails;
import src.Models.JobDetails.Status;
import src.Models.Skills;
import src.Models.Student;

public class StudentFilter {

    public void Skill_Match_Company(Student stud,List<Company> companies){
        Skills stu=stud.getSkills();
        List<String>comm_core=new ArrayList<>(stu.getCore());
        List<String>comm_webDev=new ArrayList<>(stu.getWebDev());
        List<String>comm_dataBase=new ArrayList<>(stu.getDataBase());
        List<String>comm_ai=new ArrayList<>(stu.getAi());

        List<Company> result=new ArrayList<>(); //store result company
        int counter=0;
        for(Company i : companies){
            Skills req=i.getReqSkills();
            boolean flag=true;
            //get common skills
            comm_core.retainAll(req.getCore());
            comm_webDev.retainAll(req.getWebDev());
            comm_dataBase.retainAll(req.getDataBase());
            comm_ai.retainAll(req.getAi());

            if(!comm_core.isEmpty() || !comm_webDev.isEmpty() || !comm_dataBase.isEmpty() || !comm_ai.isEmpty()){
                if(flag){
                    System.out.println("-------Your Skills are matched with this Company-------");
                    flag=false;
                }
                System.out.println("Company Index  :  "+counter++);
                System.out.println("Company Name  : "+i.getName());
                
                if(!comm_core.isEmpty()){
                    System.out.println("Matched core Skill :"+comm_core);
                }                
                if(!comm_webDev.isEmpty()){
                    System.out.println("Matched Web Dev Skill :"+comm_webDev);
                }
                if(!comm_dataBase.isEmpty()){
                    System.out.println("Matched Database Skill :"+comm_dataBase);
                }
                if(!comm_ai.isEmpty()){
                    System.out.println("Matched AI Skill :"+comm_ai);      
                }                                     
                result.add(i);
            }
        }
    }
    public List<Company> LPA_filter(int start,int end,List<Company> companies){
        List<Company> result=new ArrayList<>();

        for(Company i : companies){
            JobDetails jd=i.getDet();
            if(jd.getLpa()<=end && jd.getLpa()>=start){
                result.add(i);
            }
        }
        return result;
    }

    public List<Company> Role_filter(List<Company> companies, String role) {
        List<Company> result = new ArrayList<>();
        Status checkStatus = Status.valueOf(role.toUpperCase());

        for (Company i : companies) {
            JobDetails jd = i.getDet();

            if (jd.checkRole(checkStatus)) {
                result.add(i);
            }
        }

        return result;
    }
}

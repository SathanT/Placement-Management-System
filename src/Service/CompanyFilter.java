package src.Service;

import java.util.ArrayList;
import java.util.List;

import src.Models.Company;
import src.Models.Skills;
import src.Models.Student;

public class CompanyFilter {
    public List<Student> Skill_filter(Company  company,List<Student> students){
        Skills req=company.getReqSkills();

        List<String>comm_core=new ArrayList<>(req.getCore());
        List<String>comm_webDev=new ArrayList<>(req.getWebDev());
        List<String>comm_dataBase=new ArrayList<>(req.getDataBase());
        List<String>comm_ai=new ArrayList<>(req.getAi());

        List<Student> result=new ArrayList<>(); //store result company
        int counter=1;
        for(Student i : students){
            Skills skill=i.getSkills();
            boolean flag=true;
            //get common skills
            comm_core.retainAll(skill.getCore());
            comm_webDev.retainAll(skill.getWebDev());
            comm_dataBase.retainAll(skill.getDataBase());
            comm_ai.retainAll(skill.getAi());

            if(!comm_core.isEmpty() || !comm_webDev.isEmpty() || !comm_dataBase.isEmpty() || !comm_ai.isEmpty()){
                if(flag){
                    System.out.println("-------Your Requirements are matched with this Students-------");
                    flag=false;
                }
                System.out.println("Student Index : "+counter++);
                System.out.println("Student Name  : "+i.getName());
                
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
        return result;
    }
}

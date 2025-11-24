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
        
        for(Student i : students){
            Skills skill=i.getSkills();
            //get common skills
            comm_core.retainAll(skill.getCore());
            comm_webDev.retainAll(skill.getWebDev());
            comm_dataBase.retainAll(skill.getDataBase());
            comm_ai.retainAll(skill.getAi());

            if(!comm_core.isEmpty() || !comm_webDev.isEmpty() || !comm_dataBase.isEmpty() || !comm_ai.isEmpty()){                                                      
                result.add(i);
            }
        }
        return result;
    }
}

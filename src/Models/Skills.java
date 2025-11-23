package src.Models;
import java.util.*;
public class Skills {
    List<String> core;
    List<String> webDev;
    List<String> dataBase;
    List<String> ai;
    public Skills(){
        this.core=new ArrayList<>();
        this.webDev=new ArrayList<>();
        this.dataBase=new ArrayList<>();
        this.ai=new ArrayList<>();
    }
    
    public void addCore(String skill){
        core.add(skill);
    }
    public void addWebDev(String skill){
        webDev.add(skill);
    }
    public void addDataBase(String skill){
        dataBase.add(skill);
    }
    public void addAi(String skill){
        ai.add(skill);
    }

    public List<String> getCore(){
        return core;
    }
    public List<String> getWebDev(){
        return webDev;
    }
    public List<String> getDataBase(){
        return dataBase;
    }
    public List<String> getAi(){
        return ai;
    }
}

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
    
    public void addCore(String skil){
        core.add(skil);
    }
    public void addWebDev(String skil){
        webDev.add(skil);
    }
    public void addDataBase(String skil){
        dataBase.add(skil);
    }
    public void addAi(String skil){
        ai.add(skil);
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

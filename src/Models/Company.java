package src.Models;
public class Company extends Admin{
    private JobDetails det;
    private Location location;
    private Skills reqSkills;

    public  Company(String id,String name,JobDetails det,Location location,Skills reqSkills){
        super(id,name);
        this.det=det;
        this.location=location;
        this.reqSkills=reqSkills;
    }

    public Skills getReqSkills() {
        return reqSkills;
    }

    public void setReqSkills(Skills reqSkills) {
        this.reqSkills = reqSkills;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public JobDetails getDet(){
        return det;
    }
    public void setDet(JobDetails det){
        this.det=det;
    }

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location=location;
    }


}

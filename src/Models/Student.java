package src.Models;

public class Student extends Admin{
    private stuDet detail;
    private String email;
    private Skills skills;

    public Student(String id,String name,stuDet detail,String email,Skills skill){
        super(id,name);
        this.detail=detail;
        this.email=email;
        this.skills=skill;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public stuDet getDetail() {
        return detail;
    }

    public void setDetail(stuDet detail) {
        this.detail = detail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }
    

}
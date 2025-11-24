import src.Models.*;
import java.util.*;
import src.Controller.Controller;

public class Main {
    public static void main(String[] args){
        Controller controll = new Controller();

        // Create skills for students
        Skills sk1 = new Skills(); sk1.addCore("C"); sk1.addWebDev("HTML"); sk1.addDataBase("MySQL");
        Skills sk2 = new Skills(); sk2.addCore("C++"); sk2.addAi("Python"); sk2.addDataBase("Postgres");
        Skills sk3 = new Skills(); sk3.addCore("Java"); sk3.addWebDev("Spring"); sk3.addAi("ML Basics");
        Skills sk4 = new Skills(); sk4.addCore("Java"); sk4.addWebDev("React"); sk4.addDataBase("MongoDB");
        Skills sk5 = new Skills(); sk5.addCore("C#"); sk5.addWebDev("Angular"); sk5.addDataBase("SQL Server");
        Skills sk6 = new Skills(); sk6.addCore("Python"); sk6.addAi("Deep Learning"); sk6.addDataBase("SQLite");
        Skills sk7 = new Skills(); sk7.addCore("Go"); sk7.addWebDev("Vue"); sk7.addDataBase("Redis");
        Skills sk8 = new Skills(); sk8.addCore("Java"); sk8.addWebDev("Spring Boot"); sk8.addAi("Data Analysis");
        Skills sk9 = new Skills(); sk9.addCore("C"); sk9.addWebDev("Node.js"); sk9.addDataBase("MySQL");
        Skills sk10 = new Skills(); sk10.addCore("Rust"); sk10.addWebDev("Svelte"); sk10.addAi("NLP");

        // Create students
        controll.getStuSer().add_students(makeStudent("S001","Alice", "9990001111", "alice@example.com", "Coimbatore","Gandhipuram","TamilNadu","India",641001, sk1));
        controll.getStuSer().add_students(makeStudent("S002","Bob", "9990002222", "bob@example.com", "Salem","Edapadi","TamilNadu","India",636501, sk2));
        controll.getStuSer().add_students(makeStudent("S003","Carol", "9990003333", "carol@example.com", "Chennai","Adyar","TamilNadu","India",600020, sk3));
        controll.getStuSer().add_students(makeStudent("S004","David", "9990004444", "david@example.com", "Madurai","Melur","TamilNadu","India",625020, sk4));
        controll.getStuSer().add_students(makeStudent("S005","Eve", "9990005555", "eve@example.com", "Trichy","Anna Nagar","TamilNadu","India",620001, sk5));
        controll.getStuSer().add_students(makeStudent("S006","Frank", "9990006666", "frank@example.com", "Salem","Omalur","TamilNadu","India",636456, sk6));
        controll.getStuSer().add_students(makeStudent("S007","Grace", "9990007777", "grace@example.com", "Erode","Surampatti","TamilNadu","India",638009, sk7));
        controll.getStuSer().add_students(makeStudent("S008","Heidi", "9990008888", "heidi@example.com", "Tirunelveli","Palayam","TamilNadu","India",627001, sk8));
        controll.getStuSer().add_students(makeStudent("S009","Ivan", "9990009999", "ivan@example.com", "Salem","Sangagiri","TamilNadu","India",637301, sk9));
        controll.getStuSer().add_students(makeStudent("S010","Judy", "9990010000", "judy@example.com", "Vellore","Katpadi","TamilNadu","India",632007, sk10));

        // Create job details and companies
        JobDetails jd1 = new JobDetails(6, "6 months", 10000); jd1.setRole(JobDetails.Status.SDE);
        JobDetails jd2 = new JobDetails(4, "3 months", 5000); jd2.setRole(JobDetails.Status.QA);
        JobDetails jd3 = new JobDetails(5, "6 months", 8000); jd3.setRole(JobDetails.Status.DATA_ANALYST);
        JobDetails jd4 = new JobDetails(3, "4 months", 4000); jd4.setRole(JobDetails.Status.HR);
        JobDetails jd5 = new JobDetails(12, "12 months", 20000); jd5.setRole(JobDetails.Status.SDE);

        // Company required skills
        Skills req1 = new Skills(); req1.addCore("Java"); req1.addWebDev("Spring");
        Skills req2 = new Skills(); req2.addCore("C"); req2.addWebDev("Node.js");
        Skills req3 = new Skills(); req3.addCore("Python"); req3.addAi("Data Analysis");
        Skills req4 = new Skills(); req4.addCore("C++"); req4.addDataBase("Postgres");
        Skills req5 = new Skills(); req5.addCore("Rust"); req5.addWebDev("Svelte");

        controll.getComSer().add_companies(makeCompany("C001","TechSoft", jd1, "Coimbatore","Gandhipuram","TamilNadu","India",641001, req1));
        controll.getComSer().add_companies(makeCompany("C002","NodeWorks", jd2, "Salem","Edapadi","TamilNadu","India",636501, req2));
        controll.getComSer().add_companies(makeCompany("C003","DataLabs", jd3, "Chennai","Adyar","TamilNadu","India",600020, req3));
        controll.getComSer().add_companies(makeCompany("C004","FastSystems", jd4, "Madurai","Melur","TamilNadu","India",625020, req4));
        controll.getComSer().add_companies(makeCompany("C005","InnovateX", jd5, "Bengaluru","Whitefield","Karnataka","India",560066, req5));

        List<Company> filter=controll.getStuFil().LPA_filter(4, 8, controll.getComSer().get_Companies());
        System.out.println("\nCompanies with LPA between 4 and 8:");
        controll.getPickSer().filtered_companies(filter);
        System.out.println("\nPicking company from filtered list:\n");
        controll.getPickSer().CompanyPick(filter, 0);

    }

    private static Student makeStudent(String id, String name, String phno, String email, String district, String city, String state, String country, int pin, Skills skills){
        Location loc = new Location(district,city,state,country,pin);
        stuDet det = new stuDet(phno, email, loc);
        return new Student(id, name, det, email, skills);
    }

    private static Company makeCompany(String id, String name, JobDetails jd, String district, String city, String state, String country, int pin, Skills req){
        Location loc = new Location(district,city,state,country,pin);
        return new Company(id, name, jd, loc, req);
    }

}

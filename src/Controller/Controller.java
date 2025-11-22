package src.Controller;
import java.util.*;

import src.Service.*;

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
}

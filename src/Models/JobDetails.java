package src.Models;
public class JobDetails {

    public enum Status{
        SDE,
        QA,
        HR,
        DATA_ANALYST
    }
    private Status role;
    private int lpa;
    private String internDur;
    private int sti;

    public JobDetails(int lpa,String interDur,int sti){
        this.lpa=lpa;
        this.internDur=interDur;
        this.sti=sti;
    }

    public boolean checkRole(JobDetails.Status check) {
        return this.role==check;
    }
    public Status getRole(){
        return role;
    }

    public void setRole(JobDetails.Status role) {
        this.role = role;
    }

    public int getLpa() {
        return lpa;
    }

    public void setLpa(int lpa) {
        this.lpa = lpa;
    }

    public String getInternDur() {
        return internDur;
    }

    public void setInternDur(String internDur) {
        this.internDur = internDur;
    }

    public int getStiphen() {
        return sti;
    }

    public void setStiphen(int sti) {
        this.sti = sti;
    }

}

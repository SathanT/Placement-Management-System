package src.Models;
public class stuDet {
    private String phno;
    private String secEmail;
    private Location location;
    public stuDet(String phno,String secEmail,Location location){
        this.phno=phno;
        this.secEmail=secEmail;
        this.location=location;
    }
    public String getPhno() {
        return phno;
    }
    public void setPhno(String phno) {
        this.phno = phno;
    }
    public String getSecEmail() {
        return secEmail;
    }
    public void setSecEmail(String secEmail) {
        this.secEmail = secEmail;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

}

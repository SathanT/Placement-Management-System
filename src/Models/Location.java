package src.Models;
public class Location {
    private String city;
    private String district;
    private int pincode;
    private String state;
    private String country;

    public Location(String district,String city,String state,String country,int pincode){
        this.district=district;
        this.city=city;
        this.state=state;
        this.country=country;
        this.pincode=pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
}

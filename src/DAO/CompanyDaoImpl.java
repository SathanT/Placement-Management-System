package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.Models.Company;
import src.Models.JobDetails;
import src.utils.DatabaseConnections;
import src.Models.Location;

public class CompanyDaoImpl implements CompanyDAO{
    Connection conn=null;
    PreparedStatement com=null;
    PreparedStatement det=null;
    PreparedStatement loc=null;
    PreparedStatement skill=null;
    @Override
    public void addCompany(Company company) {
        try{

            conn=DatabaseConnections.getConnection();

            String incom="insert into company(name) values(?)";
            com=conn.prepareStatement(incom,PreparedStatement.RETURN_GENERATED_KEYS);
            com.setString(1, company.getName());
            com.executeUpdate();

            ResultSet rs=com.getGeneratedKeys();
            int comId=0;
            while(rs.next()){
                comId=rs.getInt(1);
            }
            

            JobDetails detail=company.getDet();//------>extract details from the company
            String inDet="insert into company_detail(company_id,role,lpa,intern_duration,stiphen) values (?,?,?,?,?)";
            det=conn.prepareStatement(inDet,PreparedStatement.RETURN_GENERATED_KEYS);
            det.setInt(1,comId);
            det.setString(2, String.valueOf(detail.getRole()));
            det.setInt(3, detail.getLpa());
            det.setString(3, detail.getInternDur());
            det.setInt(3, detail.getStiphen());
            det.executeUpdate();

            Location location=company.getLocation();//------>extract location from the compnay
            String inLoc="insert into company_Location(company_id,city,district,pincode,state,country)"+
            "values(?,?,?,?,?)";
            loc=conn.prepareStatement(inLoc);
            loc.setInt(1,comId);
            loc.setString(2, location.getCity());
            loc.setString(3, location.getDistrict());
            loc.setInt(4, location.getPincode());
            loc.setString(5, location.getState());
            loc.setString(6, location.getCountry());
            loc.executeUpdate();
            
        } catch(Exception e){
            System.out.print("Error adding company: "+e.getMessage());
 
        }
    }

    public void getCompanyById(int companyId){
        try{
            conn=DatabaseConnections.getConnection();
            String query="select * from company where id=?";
            com=conn.prepareStatement(query);
            com.setInt(1, companyId);
            ResultSet rs=com.executeQuery();
            while(rs.next()){
                System.out.println("Company ID: "+rs.getInt("id"));
                System.out.println("Company Name: "+rs.getString("name"));
            }
        } catch(Exception e){
            System.out.print("Error fetching company: "+e.getMessage());
        }
    }
}

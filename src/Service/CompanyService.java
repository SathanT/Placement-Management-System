package src.Service;
import src.Models.Company;

import java.util.*;
public class CompanyService {
    
    private List<Company> companies=new ArrayList<>();

    public void add_companies(Company company){
        companies.add(company);
    }
    public List<Company> get_Companies(){
        return companies;
    }
}
package POJO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Business {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String business;

    @ManyToMany
    private String stringBusiness;
    protected Business(){}

    public Business(String name, String business){
        this.name = name;
        this.business = business;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBusiness() {
        return business;
    }

    public String getStringBusiness() {
        return stringBusiness;
    }
}

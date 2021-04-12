package POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Business {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String phoneNumber;
    private Boolean isCharity = false;
    @OneToMany(mappedBy = "business")
    private Collection<Donation> donations = Collections.EMPTY_LIST;

    public Collection<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Collection<Donation> donations) {
        this.donations = donations;
    }

    public Business(String name){
        this.name = name;
    }

    public Business() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getCharity() {
        return isCharity;
    }

    public void setCharity(Boolean charity) {
        isCharity = charity;
    }
}

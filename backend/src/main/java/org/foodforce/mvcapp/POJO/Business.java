package org.foodforce.mvcapp.POJO;

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
    private int totalItemsDonated = 0;
    private Boolean isCharity = false;
    @OneToMany(mappedBy = "business")
    private Collection<Donation> donations = Collections.EMPTY_LIST;

    public Collection<Donation> getDonations() {
        return donations;
    }

    public void setDonations(Collection<Donation> donations) {
        this.donations = donations;
    }

    public Business(String name, String streetAddress, String city, String state, String phoneNumber, Boolean isCharity){
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.isCharity = isCharity;

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

    public int getTotalItemsDonated() {
        return totalItemsDonated;
    }

    public void setTotalItemsDonated(int totalItemsDonated) {
        this.totalItemsDonated = totalItemsDonated;
    }

    public void increaseItemsDonated(){
        this.totalItemsDonated++;
    }
}

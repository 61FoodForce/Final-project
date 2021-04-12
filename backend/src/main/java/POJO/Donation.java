package POJO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Donation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String donation;

    @ManyToOne
    private String stringDonation;

    protected Donation(){}

    public Donation(String name, String donation){
        this.name = name;
        this.donation = donation;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDonation() {
        return donation;
    }

    public String getStringDonation() {
        return stringDonation;
    }


}

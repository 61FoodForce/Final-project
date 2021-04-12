package org.foodforce.mvcapp;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.foodforce.mvcapp.Storage.DonationStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private DonationStorage donationStorage;
    private BusinessStorage businessStorage;

    public Populator(DonationStorage donationStorage, BusinessStorage businessStorage){
        this.donationStorage = donationStorage;
        this.businessStorage = businessStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        Business business1 = new Business( "Mid Ohio food bank");
        business1.setStreetAddress("755 South High Street");
        business1.setCity("Columbus");
        business1.setState("Ohio");
        business1.setPhoneNumber("614-555-6700");
        business1.setCharity(true);
        businessStorage.saveBusiness(business1);

        Donation donation1 = new Donation("Beans", business1);
        donation1.setFoodUnit("CAN");
        donation1.setFoodQuantity(15);
        donationStorage.saveDonation(donation1);




    }
}

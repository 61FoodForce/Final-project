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
      //________________________________________________
        Business business1 = new Business( "Mid Ohio food bank", "755 South High Street", "Columbus", "Ohio", "614-555-6700", true);
//        business1.setStreetAddress("755 South High Street");
//        business1.setCity("Columbus");
//        business1.setState("Ohio");
//        business1.setPhoneNumber("614-555-6700");
//        business1.setCharity(true);
        this.businessStorage.saveBusiness(business1);

        Donation donation2 = new Donation("Chips", business1, 11, Donation.Unit.BAG);
        //donation1.setFoodUnit(Donation.Unit.CAN);
//        donation1.setFoodQuantity(15);
        this.donationStorage.saveDonation(donation2);

        Donation donation1 = new Donation("Beans", business1, 15, Donation.Unit.CAN);
        //donation1.setFoodUnit(Donation.Unit.CAN);
//        donation1.setFoodQuantity(15);
        this.donationStorage.saveDonation(donation1);


        Business business2 = new Business( "Ray Ray Hog Pit", "680 North High Street", "Columbus", "Ohio", "614-399-6255", true);
        this.businessStorage.saveBusiness(business2);

        Donation donation3 = new Donation("BBQ Sauce", business2, 15, Donation.Unit.CAN);
        //donation1.setFoodUnit(Donation.Unit.CAN);
//        donation1.setFoodQuantity(15);
        this.donationStorage.saveDonation(donation3);





    }
}

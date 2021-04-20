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

        Business business1 = new Business( "krober", "755 South High Street", "Columbus", "Ohio", "614-555-6700", false);
        this.businessStorage.saveBusiness(business1);

        Donation donation1 = new Donation("Chips", business1, 11, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation1);
        Donation donation2 = new Donation("Calona oil", business1, 9, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation2);


        Business business2 = new Business( "Ray Ray Hog Pit", "680 North High Street", "Columbus", "Ohio", "614-400-6255", false);
        this.businessStorage.saveBusiness(business2);

        Donation donation3 = new Donation("BBQ Sauce", business2, 15, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation3);
        Donation donation4 = new Donation("Beans", business2, 20, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation4);



        Business business3 = new Business( "Aldim", "123 left street", "Columbus", "Ohio", "614-555-6700", false);
        this.businessStorage.saveBusiness(business3);

        Donation donation5 = new Donation("rice", business3, 11, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation5);
        Donation donation6 = new Donation("cereal", business3, 50, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation6);



        Business business4 = new Business( "Samy Club", "150 N Sycamore St", "Columbus", "Ohio", "614-700-6780", false);
        this.businessStorage.saveBusiness(business4);

        Donation donation7 = new Donation("Canned stew", business4, 40, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation7);
        Donation donation8 = new Donation("Canned fruit", business4, 10, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation8);


        Business business5 = new Business( "Wholes Food", "3670 W Dublin Granville R", "Columbus", "Ohio", "614-700-67700", false);
        this.businessStorage.saveBusiness(business5);

        Donation donation9 = new Donation("Peanut butter", business5, 30, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation9);
        Donation donation10 = new Donation("Pasta", business5, 35, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation10);



        Business business6 = new Business( "Saraga International Grocery", "1265 Morse Rd", "Columbus", "Ohio", "614-700-8000", false);
        this.businessStorage.saveBusiness(business6);

        Donation donation11 = new Donation("Canned soup", business6, 20, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation11);
        Donation donation12 = new Donation("Canned Vegetable", business6, 17, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation12);



        Business business7 = new Business( "Saraga International Grocery", "1265 Morse Rd", "Columbus", "Ohio", "614-600-6500", false);
        this.businessStorage.saveBusiness(business7);

        Donation donation13= new Donation("Applesauce", business7, 33, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation13);
        Donation donation14 = new Donation("Canned Meat", business7, 18, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation14);




        Business business8 = new Business( "Trader Joe", "888 Townsfair Way", "Columbus", "Ohio", "614-700-1230", false);
        this.businessStorage.saveBusiness(business8);


        Business business9 = new Business( "The Refectory Restaurant", "2891 E Main St", "Columbus", "Ohio", "614-700-1350", false);
        this.businessStorage.saveBusiness(business9);

        Donation donation15= new Donation("Canned Chicken", business8, 20, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation15);
        Donation donation16 = new Donation("Crackers", business8, 60, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation16);

        Business nonProfit = new Business( "Mid Ohio Food bank", "3960 Brookham Drive", "Columbus", "Ohio", "614-277-3663", true);
        this.businessStorage.saveBusiness(nonProfit);

        Business nonProfit2 = new Business( "South Roots", "280 Reeb Ave", "Columbus", "Ohio", "(614) 468-9300", true);
        this.businessStorage.saveBusiness(nonProfit2);

        Business nonProfit3= new Business( "Church for all people", "946 Parsons Ave", "Columbus", "Ohio", "(614) 445-7342gi", true);
        this.businessStorage.saveBusiness(nonProfit3);

        Business nonProfit4= new Business( "Local Matters", "633 Parson ave", "Columbus", "Ohio", "614-263-5662", true);
        this.businessStorage.saveBusiness(nonProfit4);

        Business nonProfit5= new Business( "Sprouting Spoon", "194 West 1st St", "Columbus", "Ohio", "614-777-6888", true);
        this.businessStorage.saveBusiness(nonProfit5);

        Business nonProfit6= new Business( "Children Hunger Alliance", "1105 Schrock Rd", "Columbus", "Ohio", "614-341-7700", true);
        this.businessStorage.saveBusiness(nonProfit6);

        Business nonProfit7= new Business( "Heart Food Pantry", "6475  East Main St", "Columbus", "Ohio", "614-600-6065", true);
        this.businessStorage.saveBusiness(nonProfit7);

        Business nonProfit8= new Business( "Food for Hunger", " 1684 Venture Dr", "Mt Vernon", "Ohio", "614-341-7700", true);
        this.businessStorage.saveBusiness(nonProfit8);

        Business nonProfit9= new Business( "Nnemap Food Pantry", " 677 East 11th ave", "Columbus", "Ohio", "614-297-0533", true);
        this.businessStorage.saveBusiness(nonProfit9);

        Business nonProfit10= new Business( "Hillard Food Pantry", " 4410 Cemetery Rd", "Columbus", "Ohio", " (614) 363-4159", true);
        this.businessStorage.saveBusiness(nonProfit10);

        Donation donation17= new Donation("Instant Mashed Potatoes", business9, 27, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation17);
        Donation donation18 = new Donation("Dried Spices", business9, 20, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation18);



        Business business10 = new Business( "The Table", "21 E 5th Ave #101", "Columbus", "Ohio", "614-700-1355", false);
        this.businessStorage.saveBusiness(business10);

        Donation donation19= new Donation("honey", business10, 15, Donation.Unit.CAN);
        this.donationStorage.saveDonation(donation19);
        Donation donation20= new Donation("dried fruits", business10, 22, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation20);
        Donation donation21= new Donation("Chips", business10, 1, Donation.Unit.BAG);
        this.donationStorage.saveDonation(donation21);


    }
}

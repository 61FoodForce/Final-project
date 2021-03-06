package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.foodforce.mvcapp.Storage.DonationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/donations")
public class donationsController {
    private DonationStorage donationStorage;
    private BusinessStorage businessStorage;
    public donationsController(DonationStorage donationStorage, BusinessStorage businessStorage) {
        this.donationStorage = donationStorage;
        this.businessStorage = businessStorage;
    }

    // Displays all donations to donation display page.
    @RequestMapping("")
    public String displayAllDonations(Model model) {


    model.addAttribute("businesses", businessStorage.retrieveAllForProfit());
    model.addAttribute("nonProfits", businessStorage.retrieveAllCharities());

        return "donationdisplayPage";


    }

    //Allows user to search donations
//    @RequestMapping("/donations")
//    public String displayDonations(@PathVariable long id, Model model) {
//        model.addAttribute("donations", donationStorage.retrieveDonationById(id));
//        return "donation-display-page";
//    }

//    @PostMapping("/submitDonation")
//    public String addDonation(@PathVariable long id, @RequestParam String name, @RequestParam Business business, @RequestParam int foodQuantity, @RequestParam int foodUnit) {
//        Donation donationToAdd = new Donation(name, business, foodQuantity, Donation.Unit.CAN);
//        donationStorage.saveDonation(donationToAdd);
//        return "redirect:";
    @PostMapping("/submitDonation")
    public String addDonation(String _name, int business, int _foodQuantity, String foodUnit) {
        Donation.Unit unit = Donation.Unit.CAN;

        switch (foodUnit) {
            case "lbs":
                unit = Donation.Unit.POUND;
                break;

            case "cans":
                unit = Donation.Unit.CAN;
                break;

            case "gallons":
                unit = Donation.Unit.GALLONS;
                break;

            case "box":
                unit = Donation.Unit.BOX;
                break;

            case "case":
                unit = Donation.Unit.CASE;
                break;

        }


        Donation donationToAdd = new Donation(_name, businessStorage.retrieveBusinessById(business).get(), _foodQuantity, unit);
        donationStorage.saveDonation(donationToAdd);
        return "redirect:/donations";

    }
    @DeleteMapping("/acceptDonation")
    public String deleteDonation(@PathVariable long id) {
       // donationStorage.retrieveDonationById().get
        donationStorage.deleteDonationById(id);
        return "redirect:/donations";
    }

    @GetMapping("/acceptDonation")
    public String increaseDonationCount(@RequestParam String _business, @RequestParam(name="id") List<Integer> donations, @RequestParam(name="charity") int charityId) {
        Business business = businessStorage.retrieveBusinessByName(_business);
        for (int i:donations) {
            business.increaseItemsDonated();
            Business nonProfit = businessStorage.retrieveBusinessById(charityId).get();
            business.getDonation(i).get().setReadyForPickup(true);
            business.getDonation(i).get().setDonatedBy(business.getName());
            business.getDonation(i).get().setBusiness(nonProfit);
            businessStorage.saveBusiness(business);
            businessStorage.saveBusiness(nonProfit);
        }
//        for (donationsAccepted:business.getDonations()){
//            donationStorage.deleteDonationById(donation.getId());
//        }
        businessStorage.saveBusiness(business);
        return "redirect:/charities/"+charityId;

    }
//    @RequestMapping("/searchDonations")
//    public String showDonationByName(@RequestParam String _search, Model model) {
//        model.addAttribute("donation", donationStorage.retrieveDonationByName(_search));
//        return "search-display-page";}


    @RequestMapping("/searchDonations")
    public String showDonationByName(@RequestParam String _search, Model model) {
        Iterable<Donation> donations = donationStorage.retrieveAllDonations();
        ArrayList<Donation> foundDonations = new ArrayList<Donation>();
        //Map<String, Donation> searchedDonations = new HashMap<>();
        for (Donation donation: donations){
            if (donation.getName().toLowerCase(Locale.ROOT).contains(_search.toLowerCase(Locale.ROOT)) && _search.length()>0){
                foundDonations.add(donation);
            }
        }
        model.addAttribute("nonProfits", businessStorage.retrieveAllCharities());
        model.addAttribute("foundDonations", foundDonations);
        return "/search-display-page";
    }

    @RequestMapping("/donationForm")
    public String donationForm(Model model){
        Iterable<Business> businesses = businessStorage.retrieveAllForProfit();

        model.addAttribute("businesses", businesses);
        return "donationForm";
    }
}


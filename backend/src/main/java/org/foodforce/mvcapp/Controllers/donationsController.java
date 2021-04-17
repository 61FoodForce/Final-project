package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.foodforce.mvcapp.Storage.DonationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
       // model.addAttribute("donations", donationStorage.retrieveAllDonations());
        model.addAttribute("businesses", businessStorage.retrieveAllBusiness());
        return "donation-display-page";
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
    public String addDonation(String _name, String _business, int _foodQuantity) {
        Donation donationToAdd = new Donation(_name, businessStorage.retrieveBusinessByName(_business), _foodQuantity, Donation.Unit.CAN);
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
    public String increaseDonationCount(@RequestParam String _charity, @RequestParam String _business, @RequestParam(name="id") List<Integer> donations) {
        Business business = businessStorage.retrieveBusinessByName(_business);
        for (int i:donations) {
            business.increaseItemsDonated();
        }
       // for (Donation donation:business.getDonations()){
       //     donationStorage.deleteDonationById(donation.getId());
       // }
        businessStorage.saveBusiness(business);
        return "redirect:/donations";

    }




}
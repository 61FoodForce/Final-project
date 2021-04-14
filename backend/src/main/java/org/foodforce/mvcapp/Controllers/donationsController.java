package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.Storage.DonationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/donations")
public class donationsController {
    private DonationStorage donationStorage;

    public donationsController(DonationStorage donationStorage) {
        this.donationStorage = donationStorage;
    }

    @GetMapping("{id}")
    public String displayDonations(@PathVariable long id, Model model) {
        model.addAttribute("donations", donationStorage.retrieveDonationById(id));
        return "";
    }

//    @PostMapping("/submitDonation")
//    public String addDonation(@PathVariable long id, @RequestParam String name, @RequestParam Business business, @RequestParam int foodQuantity, @RequestParam int foodUnit) {
//        Donation donationToAdd = new Donation(name, business, foodQuantity, Donation.Unit.CAN);
//        donationStorage.saveDonation(donationToAdd);
//        return "redirect:";
    @PostMapping("/submitDonation")
    public String addDonation(String _name, Business _business, int _foodQuantity) {
        Donation donationToAdd = new Donation(_name, _business, _foodQuantity, Donation.Unit.CAN);
        donationStorage.saveDonation(donationToAdd);
        return "donation-display";
    }

    @DeleteMapping("{id}")
    public String deleteDonation(@PathVariable long id) {
        donationStorage.deleteDonationById(id);
        return "redirect:";
    }


}
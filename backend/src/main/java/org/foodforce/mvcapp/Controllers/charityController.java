package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.foodforce.mvcapp.Storage.DonationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("/charities")
public class charityController {
    private BusinessStorage businessStorage;
    private DonationStorage donationStorage;

    public charityController(BusinessStorage businessStorage, DonationStorage donationStorage) {
        this.businessStorage = businessStorage;
        this.donationStorage = donationStorage;
    }

    @GetMapping("")
    public String displayCharities(Model model) {

        model.addAttribute("charities", businessStorage.retrieveAllCharities());
        return "charityList";
    }

    @GetMapping("{id}")
    public String displayBusiness(@PathVariable long id, Model model) {
        ArrayList<Donation> pickUpList = new ArrayList<Donation>();
        for (Donation donation: businessStorage.retrieveBusinessById(id).get().getDonations())
        {
             if(donation.isReadyForPickup()){
                 pickUpList.add(donation);
             }
        }

        model.addAttribute("charity", businessStorage.retrieveBusinessById(id).get());
        model.addAttribute("pickUpList", pickUpList);
        return "charityDetail";
    }
    @GetMapping("/receivedItem")
    public String receiveItem(@RequestParam Long donationId){
        Donation donation = donationStorage.retrieveDonationById(donationId).get();
        donation.setReadyForPickup(false);
        donationStorage.saveDonation(donation);
        Long charId = donation.getBusiness().getId();
        return "redirect:/charities/" + charId;
    }
}
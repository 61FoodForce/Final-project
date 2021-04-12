package Controllers;

import POJO.Business;
import POJO.Donation;
import Storage.BusinessStorage;
import Storage.DonationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class donationsController {
    private DonationStorage donationStorage;

    public donationsController(DonationStorage donationStorage) {this.donationStorage = donationStorage;}

    @GetMapping("{id}")
    public String displayDonations(@PathVariable long id, Model model){
        model.addAttribute("donations", donationStorage.retrieveDonationById(id));
        return "";
}
    @PostMapping("/donationform")
    public String addDonation(@PathVariable long id, @RequestParam String name, @RequestParam Business business, @RequestParam int foodQuantity){
        Donation donationToAdd = new Donation(name, business, foodQuantity);
        donationStorage.saveDonation(donationToAdd);
        return"redirect:";
    }
    @DeleteMapping("{id}")
    public String deleteDonation(@PathVariable long id){
        donationStorage.deleteDonationById(id);
        return"redirect:";
    }






}
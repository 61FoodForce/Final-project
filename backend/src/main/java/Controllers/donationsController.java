package Controllers;

import Storage.DonationStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class donationsController {
    private DonationStorage donationStorage;

    public donationsController(DonationStorage donationStorage) {this.donationStorage = donationStorage;}

    @GetMapping("{id}")
    public String displayDonations(@PathVariable long id, Model model){
        model.addAttribute("donations", donationStorage.retrieveDonationById(id));
        return "";

}





}
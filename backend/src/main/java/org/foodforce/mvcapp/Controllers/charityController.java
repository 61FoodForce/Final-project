package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/charities")
public class charityController {
    private BusinessStorage businessStorage;

    public charityController(BusinessStorage businessStorage) {
        this.businessStorage = businessStorage;
    }

    @GetMapping("")
    public String displayCharities(Model model) {
        Iterable<Business> businesses = businessStorage.retrieveAllBusiness();
        ArrayList<Business> charities = new ArrayList<Business>();
        for (Business business : businesses) {
            if (business.getCharity()) {
                charities.add(business);
            }
        }
        model.addAttribute("charities", charities);
        return "charityList";
    }

    @GetMapping("{id}")
    public String displayBusiness(@PathVariable long id, Model model) {
        model.addAttribute("charity", businessStorage.retrieveBusinessById(id).get());
        return "charityDetail";
    }
}
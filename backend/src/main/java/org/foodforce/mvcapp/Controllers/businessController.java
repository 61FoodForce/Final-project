package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class businessController {
    private BusinessStorage businessStorage;

    public businessController(BusinessStorage businessStorage) {
        this.businessStorage = businessStorage;
    }

    @GetMapping("{id}")
    public String displayBusinesses(@PathVariable long id, Model model) {
        model.addAttribute("businesses", businessStorage.retrieveBusinessById(id));
        return "business.html";
    }

    @PostMapping("{id}")
    public String addBusiness(@PathVariable long id, @RequestParam String name, @RequestParam String streetAddress, @RequestParam String city,
                             @RequestParam String state, @RequestParam String phoneNumber, @RequestParam Boolean isCharity) {
        Business businessToAdd = new Business(name, streetAddress, city, state, phoneNumber, isCharity);
        businessStorage.saveBusiness(businessToAdd);
        return "redirect:business.html";
    }

    @DeleteMapping("{id}")
    public String deleteBusiness(@PathVariable long id){
        businessStorage.deleteBusinessById(id);
        return "redirect:business.html";
    }


}

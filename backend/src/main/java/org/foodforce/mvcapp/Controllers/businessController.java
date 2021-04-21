package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/businesses")
public class businessController {
    private BusinessStorage businessStorage;

    public businessController(BusinessStorage businessStorage) {
        this.businessStorage = businessStorage;
    }

    @GetMapping("")
    public String displayBusinesses(Model model) {
        Iterable<Business> businesses = businessStorage.retrieveAllBusiness();
        for (Business business: businesses) {
            int items = 0;
            for (Donation donation:business.getDonations())
            {
                items += donation.getFoodQuantity();
            }
            business.setTotalItemsDonated(items);
        }

        model.addAttribute("businesses", businesses );
        return "businessList";
    }
    @RequestMapping("/rewards")
    public String displayAllDonations(Model model) {
        model.addAttribute("businesses", businessStorage.retrieveAllBusiness());
        return "rewards-display-page";
    }
    @GetMapping("{id}")
    public String displayBusiness(@PathVariable long id, Model model) {
        model.addAttribute("business", businessStorage.retrieveBusinessById(id).get());
        return "businessDetails";
    }

    @PostMapping("/addBusiness")
    public String addBusiness(String _name, String _address, String _phone, String _type){
        Business businessToAdd;
        if(_type.equals("business")){
            businessToAdd = new Business(_name, _address, "Columbus", "Ohio", _phone, false);
        }else{
            businessToAdd = new Business(_name, _address, "Columbus", "Ohio", _phone, true);
        }
        businessStorage.saveBusiness(businessToAdd);
        if(businessToAdd.getCharity()){
            return "redirect:/charities/" + businessStorage.retrieveBusinessByName(businessToAdd.getName()).getId();
        }
        else{
            return "redirect:/businesses/" + businessStorage.retrieveBusinessByName(businessToAdd.getName()).getId();
        }
    }

    @DeleteMapping("{id}")
    public String deleteBusiness(@PathVariable long id){
        businessStorage.deleteBusinessById(id);
        return "redirect:business.html";
    }


}

package org.foodforce.mvcapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("")
public class HomeController {

    public HomeController() {
    }

    @GetMapping("")
    public String homepage() {

        return "index";
    }

    @GetMapping("facts")
    public String factsAboutFoodWaste() {

        return "factsAboutFoodWaste";
    }

    @GetMapping("charityLocation")
    public String charityLocation() {

        return "CharityLocation";
    }

    @GetMapping("rewards")
    public String rewardsPage() {

        return "rewardsPage";
    }


    @GetMapping("foodreduction")
    public String foodReduction() {

        return "foodReduction";
    }

    @GetMapping("donationform")
    public String donationform() {

        return "donationForm";
    }
//
//    @GetMapping("donation-display-page")
//    public String donationdisplayPage() {
//
//        return "donationdisplayPage";
//    }
}
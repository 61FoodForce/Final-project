package org.foodforce.mvcapp.Controllers;

import org.foodforce.mvcapp.POJO.Business;
import org.foodforce.mvcapp.POJO.Donation;
import org.foodforce.mvcapp.Storage.BusinessStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("rewards")
    public String rewardsPage() {

        return "rewardsPage";
    }
}

package Controllers;

import Storage.BusinessStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class businessController {
    private BusinessStorage businessStorage;

    public businessController(BusinessStorage businessStorage) { this.businessStorage = businessStorage;}

    @GetMapping("{id}")
    public String displayBusinesses(@PathVariable long id, Model model){
        model.addAttribute("businesses", businessStorage.r)
    }
}

package com.example.skak.Controller;

import com.example.skak.Models.medlem;
import com.example.skak.Service.restanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class restanceController {

    @Autowired
    restanceService restanceService;


    @GetMapping("/allerestancer")
    public String selection(Model model){
        model.addAttribute("allemedlemmer", restanceService.readAllRestancer());

        return "restance/alleRestancer";

    }

    @GetMapping("/tilføjRykkerGebyr")
    public String rykkerGebyr(@RequestParam int medlemsId){

        restanceService.tilføjGebyr(medlemsId);

        return "redirect:/allerestancer";

    }

    @GetMapping("/updaterestance")
    public String updateRestance(@RequestParam int medlemsId, Model model){

       medlem medlemToUpdate = restanceService.readRestance(medlemsId);
       model.addAttribute("medlem", medlemToUpdate );


       return("restance/updateRestance");

    }

    @PostMapping("/updatedrestance")
    public String updatedmedlem(@ModelAttribute medlem medlemfrompost){
        restanceService.updateRestance(medlemfrompost);
        return "redirect:/allerestancer";

    }


}

package com.example.skak.Controller;

import com.example.skak.Models.Turnering;
import com.example.skak.Models.medlem;
import com.example.skak.Service.turneringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class turneringsController {

    @Autowired
    com.example.skak.Service.turneringsService turneringsService ;




    @GetMapping("/opretturnering")
    public String opretturnering(){

        return "turneringer/createTurnering";

    }

    @PostMapping("/createdTurnering")
    public String oprettetTurnering(@ModelAttribute Turnering turneringFromPost){

        turneringsService.createTurnering(turneringFromPost);

        return "redirect:/alleturneringer";

    }

    @GetMapping("/deleteturnering")
    public String deleteturnering(@RequestParam int turneringsId){
        turneringsService.deleteTurnering(turneringsId);

        return "redirect:/alleturneringer";

    }

    @GetMapping("/updateturnering")
    public String updatemedlem(@RequestParam int turneringsId, Model model){
        Turnering turneringToUpdate  = turneringsService.readTurnering(turneringsId);
        model.addAttribute("turnering", turneringToUpdate);
        return "turneringer/updateTurnering";

    }

    @PostMapping("/updatedturnering")
    public String updatedmedlem(@ModelAttribute Turnering turneringFromPost){
        turneringsService.updateTurnering(turneringFromPost);
        return "redirect:/alleturneringer";

    }

    @GetMapping("/singleturnering")
    public String singleTurnering(@RequestParam int turneringsId, Model model){
        Turnering tempTurnering = turneringsService.readTurnering(turneringsId);
        model.addAttribute("turnering", tempTurnering);

        return "turneringer/readEnkeltTurnering";
    }

    @GetMapping("/alleturneringer")
    public String selection(Model model){
        model.addAttribute("alleturneringer", turneringsService.readAllTurneringer());

        return "turneringer/readAlleTurneringer";

    }


}



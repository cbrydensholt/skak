package com.example.skak.Controller;

import com.example.skak.Models.medarbejder;
import com.example.skak.Models.medlem;
import com.example.skak.Service.medarbejderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class medarbejderController {

    @Autowired
    com.example.skak.Service.medarbejderService medarbejderService;

    @GetMapping("/createmedarbejder")
    public String opretmedarbejder(){


        return "medarbejdere/createMedarbejder";

    }

    @PostMapping("/createdmedarbejder")
    public String oprettetmedlem(@ModelAttribute medarbejder medarbejderfrompost){

        medarbejderService.createArbejder(medarbejderfrompost);

        return "redirect:/allemedarbejdere";

    }

    @GetMapping("/deletemedarbejder")
    public String deletemedlem(@RequestParam int arbejderId){
        medarbejderService.deleteArbejder(arbejderId);

        return "redirect:/allemedarbejdere";

    }

    @GetMapping("/updatemedarbejder")
    public String updatemedlem(@RequestParam int arbejderId, Model model){
        medarbejder arbejderToUpdate  = medarbejderService.readMedarbejder(arbejderId);
        model.addAttribute("medarbejder", arbejderToUpdate);
        return "medarbejdere/updateMedarbejder";

    }

    @PostMapping("/updatedmedarbejder")
    public String updatedmedlem(@ModelAttribute medarbejder medarbejderfrompost){
        medarbejderService.updateArbejder(medarbejderfrompost);
        return "redirect:/allemedarbejdere";

    }

    @GetMapping("/singlemedarbejder")
    public String singlemedlem(@RequestParam int arbejderId, Model model){
        medarbejder tempmedarbejder = medarbejderService.readMedarbejder(arbejderId);
        model.addAttribute("medarbejder", tempmedarbejder);

        return "medarbejdere/readEnkeltMedarbejder";
    }

    @GetMapping("/allemedarbejdere")
    public String selection(Model model){
        model.addAttribute("allearbejdere", medarbejderService.readAllArbejdere());

        return "medarbejdere/readAllMedarbejder";

    }


}



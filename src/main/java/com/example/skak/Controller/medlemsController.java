package com.example.skak.Controller;

import com.example.skak.Models.medlem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class medlemsController {


    @Autowired
    com.example.skak.Service.medlemsService medlemsService ;


    @GetMapping("/")
    public String index(){
        return "medlemmer/readAlleMedlemmer";
    }

    @GetMapping("/opretmedlem")
    public String opretmedlem(){

        return "medlemmer/createMedlem";

    }

    @PostMapping("/createdmedlem")
    public String oprettetmedlem(@ModelAttribute medlem medlemfrompost){

    medlemsService.createMedlem(medlemfrompost);

        return "redirect:/allemedlemmer";

    }

    @GetMapping("/deletemedlem")
    public String deletemedlem(@RequestParam int medlemsId){
        medlemsService.deleteMedlem(medlemsId);

        return "redirect:/allemedlemmer";

    }

    @GetMapping("/updatemedlem")
    public String updatemedlem(@RequestParam int medlemsId, Model model){
        medlem medlemtoupdate  = medlemsService.readMedlem(medlemsId);
        model.addAttribute("medlem", medlemtoupdate);
        return "medlemmer/updateMedlem";

    }

    @PostMapping("/updatedmedlem")
    public String updatedmedlem(@ModelAttribute medlem medlemfrompost){
        medlemsService.updateMedlem(medlemfrompost);
        return "redirect:/allemedlemmer";

    }

    @GetMapping("/singlemedlem")
    public String singlemedlem(@RequestParam int medlemsId, Model model){
        medlem tempmedlem = medlemsService.readMedlem(medlemsId);
        model.addAttribute("medlem", tempmedlem);

        return "medlemmer/readEnkeltMedlem";
    }

    @GetMapping("/allemedlemmer")
    public String selection(Model model){
        model.addAttribute("allemedlemmer", medlemsService.readAllMedlemmer());

        return "medlemmer/readAlleMedlemmer";

    }

    @GetMapping("/resultatberegning")
    public String resultatBeregning(){
        return "medlemmer/medlemsResultat";
    }

    @PostMapping("/beregnetresultat")
    public String beregnetResultat(int medlemsId, int modstanderRating, String result){

        System.out.println(medlemsId);
        System.out.println(modstanderRating);
        System.out.println(result);

        medlemsService.styrkejustering(medlemsId, modstanderRating, result);
        return "redirect:/allemedlemmer";

    }

    @GetMapping("/searchformember")
    public String searchForMember(){

        return "medlemmer/searchmember";

    }

    @PostMapping("/searchedmember")
    public String searchedMember(int medlemsTelefon, Model model){

        medlem tempmedlem = medlemsService.searchForMember(medlemsTelefon);
        model.addAttribute("medlem", tempmedlem);
        return "medlemmer/searchedmember";



    }


}

package com.example.Web.controller;

import com.example.Web.models.Club;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.Web.dto.ClubDto;
import com.example.Web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService){
        this.clubService=clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs=clubService.findAllClub();
        model.addAttribute("clubs",clubs);
        return "layout";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club=new Club();
        model.addAttribute("club",club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,
                           BindingResult bindingResult,
                           Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId,Model model){
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club",club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "clubs-edit";
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

}

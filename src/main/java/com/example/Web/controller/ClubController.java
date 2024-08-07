package com.example.Web.controller;

import com.example.Web.models.Club;
import org.springframework.ui.Model;
import com.example.Web.dto.ClubDto;
import com.example.Web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

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
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

}

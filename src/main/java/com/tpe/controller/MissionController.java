package com.tpe.controller;

import com.tpe.domain.Mission;
import com.tpe.exception.ResourcesNotFoundException;
import com.tpe.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/missions")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping("/selam")
    public ModelAndView selamlama(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Selam; ");
        mav.addObject("messagebody","Sen cok degerlisin, bunu sakin UNUTMA!");
        mav.setViewName("selam");
        return mav;
    }

    @GetMapping("/new")
    public String sendMissionForm(@ModelAttribute("mission")Mission mission){

        return "missionForm";

    }
    @PostMapping("/saveMission")
    public String createMission(@Valid @ModelAttribute Mission mission, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "missionForm";
        }
        missionService.saveMission(mission);
        return "redirect:/missions";
    }
    @GetMapping
    public ModelAndView getMissions(){
        List<Mission>allMission=missionService.getAllMissions();
        ModelAndView mav=new ModelAndView();
        mav.addObject("missionList",allMission);
        mav.setViewName("missions");
        return mav;
    }

    @GetMapping("/update")
    public ModelAndView showMissionForm(@RequestParam("id") Long id){
        Mission foundMission=missionService.findMissionWithId(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("mission",foundMission);
        mav.setViewName("missionForm");
        return mav;
    }
    @GetMapping("/delete/{id}")
    public String deleteMission(@PathVariable("id") Long id){
        missionService.deleteMission(id);
        return "redirect:/missions";
    }
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ModelAndView handleNotFoundException(Exception e){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message",e.getMessage());
        mav.setViewName("notFound");
        return mav;
    }














}

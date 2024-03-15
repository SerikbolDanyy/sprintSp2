package com.company.sprintSp2.controllers;

import com.company.sprintSp2.entities.ApplicationRequest;
import com.company.sprintSp2.repository.RequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private RequestsRepository requestsRepository;
    @GetMapping(value = "/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/addPage")
    public String addPage(Model model){
        return "addReq";
    }
    @PostMapping(value = "/add")
    public String add (@RequestParam(name = "fullName") String fullName,
                       @RequestParam(name = "course") String course,
                       @RequestParam(name = "phoneNumber") String phoneNumber,
                       @RequestParam(name = "commentary") String commentary){
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(fullName);
        applicationRequest.setCourseName(course);
        applicationRequest.setPhone(phoneNumber);
        applicationRequest.setCommentary(commentary);
        requestsRepository.save(applicationRequest);
        return "redirect:/";
    }
}

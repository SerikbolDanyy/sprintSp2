package com.company.sprintSp2.controllers;

import com.company.sprintSp2.entities.ApplicationRequest;
import com.company.sprintSp2.repository.RequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private RequestsRepository requestsRepository;
    @GetMapping(value = "/")
    public String index(Model model){
        List<ApplicationRequest> requests = requestsRepository.findAll();
        model.addAttribute("req", requests);
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
        applicationRequest.setHandled(true);

        requestsRepository.save(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/newR")
    public String newR(Model model){
        List<ApplicationRequest> requests = requestsRepository.findAll();
        model.addAttribute("req", requests);
        return "newReq";
    }

    @GetMapping(value = "/proR")
    public String proR(Model model){
        List<ApplicationRequest> requests = requestsRepository.findAll();
        model.addAttribute("req", requests);
        return "proReq";
    }

    @GetMapping(value = "/details/{requestId}")
    public String details(Model model, @PathVariable(name = "requestId") Long id){
        ApplicationRequest applicationRequest = requestsRepository.findById(id).orElse(null);
        model.addAttribute("req", applicationRequest);
        return "details";
    }

    @PostMapping(value = "/reHandle")
    public String reHandle(@RequestParam(name = "id") Long id){
        ApplicationRequest applicationRequest = requestsRepository.findById(id).orElse(null);
        applicationRequest.setHandled(false);
        System.out.println(applicationRequest.isHandled() + " " + applicationRequest.getId());
        return "redirect:/";
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestParam(name = "id") Long id){
        ApplicationRequest applicationRequest = requestsRepository.findById(id).orElse(null);
        requestsRepository.delete(applicationRequest);
        return "redirect:/";
    }
}

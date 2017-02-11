package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mehmet on 12.10.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("hello","Hello World!");
        return "index";
    }

    



}

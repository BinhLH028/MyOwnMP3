package com.example.MyOwnMP3.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/Main")
public class MainController {
    @GetMapping(value = "/test")
    public String printsth(){
        return "BinhLh";
    }
}

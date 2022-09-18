package com.example.JP2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    // Отображение главных страниц
    @GetMapping("/register")
    public String Home(Model model){
        return "registerPage";
    }
}

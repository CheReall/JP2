package com.example.JP2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Отображение главных страниц
    @GetMapping("/login")
    public String Home(Model model){
        return "loginPage";
    }

}

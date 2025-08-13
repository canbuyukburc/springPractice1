package de.buyukburc.springPractice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
    
    // Additional mapping for demonstration
    @GetMapping("/can")
    public String canPage(Model model) {
        model.addAttribute("appName", appName);
        return "can";
    }
}

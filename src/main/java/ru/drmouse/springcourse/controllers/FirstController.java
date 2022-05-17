package ru.drmouse.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        if (action == null) {
            model.addAttribute("answer", "Incorrect param");
        } else {
            switch (action) {
                case "multiplication":
                    model.addAttribute("answer",a * b);
                    break;
                case "addition":
                    model.addAttribute("answer",a + b);
                    break;
                case "subtraction":
                    model.addAttribute("answer",a - b);
                    break;
                case "division":
                    model.addAttribute("answer",a / b);
                    break;
                default:
                    model.addAttribute("answer","Incorrect action");
                    break;
            }
        }

        return "first/calculator";
    }
}

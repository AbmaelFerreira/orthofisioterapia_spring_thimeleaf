package br.com.orthofisioterapia.site.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Created by Abmael on 05/02/2019.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "redirect:/usuario/todos";
    }
}

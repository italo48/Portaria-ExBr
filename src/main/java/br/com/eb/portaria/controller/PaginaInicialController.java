package br.com.eb.portaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaInicialController {
    @RequestMapping("/")
    public final ModelAndView paginaInicial() {
        return new ModelAndView("index");
    }

    @RequestMapping("/logar")
    public final ModelAndView paginaLogin() { 
    	return new ModelAndView("login"); 
    }
}

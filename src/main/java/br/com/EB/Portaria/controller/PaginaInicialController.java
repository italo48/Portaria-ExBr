package br.com.EB.Portaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaInicialController {

    @RequestMapping("/")
    public ModelAndView paginaInicial(){
        return new ModelAndView("index");
    }

    @RequestMapping("/logar")
    public ModelAndView paginaLogin(){return new ModelAndView("login"); }

}



package br.com.EB.Portaria.controller;

import br.com.EB.Portaria.model.Soldado;
import br.com.EB.Portaria.service.RegistroService;
import br.com.EB.Portaria.service.SoldadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/soldados")
public class SoldadoController {

    @Autowired
    private SoldadoService sdService;

    @Autowired
    private RegistroService regService;

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrarSoldado(){
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("soldado", new Soldado());
        return  mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvarSoldado(Soldado sd){
        this.sdService.adicionarSoldado(sd);
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("mensagem", "Soldado cadastrado com sucesso");
        return  mv;
    }

    @GetMapping("/listar")
    public ModelAndView listarSoldados(){
        List<Soldado> listaDeSoldados = this.sdService.todosOsSoldados();
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("todosOsSoldados", listaDeSoldados);
        return mv;
    }
    @RequestMapping("/{id}")
    public ModelAndView excluirSoldado(@PathVariable Long id){
        this.regService.deletarRegistroPorIdSoldado(id);
        this.sdService.excluirSoldado(id);
        ModelAndView mv = new ModelAndView("redirect:/soldados/listar");
        return mv;
    }
    @RequestMapping("/logar")
    public ModelAndView logar(){
        return new ModelAndView("login");
    }
}

package br.com.eb.portaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.eb.portaria.model.Soldado;
import br.com.eb.portaria.service.RegistroService;
import br.com.eb.portaria.service.SoldadoService;

@Controller
@RequestMapping("/soldados")
public class SoldadoController {
    @Autowired
    private SoldadoService sdService;
    @Autowired
    private RegistroService regService;
    
    @RequestMapping("/cadastrar")
    public final ModelAndView cadastrarSoldado() {
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("soldado", new Soldado());
        return mv;
    }

    @RequestMapping("/salvar")
    public final ModelAndView salvarSoldado(final Soldado sd) {
        this.sdService.adicionarSoldado(sd);
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("mensagem", "Soldado cadastrado com sucesso");
        return mv;
    }
    
    @RequestMapping("/listar")
    public final ModelAndView listarSoldados() {
        List<Soldado> listaDeSoldados = this.sdService.todosOsSoldados();
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("todosOsSoldados", listaDeSoldados);
        return mv;
    }
    
    @RequestMapping("/{id}")
    public final ModelAndView excluirSoldado(@PathVariable final Long id) {
        this.regService.deletarRegistroPorIdSoldado(id);
        this.sdService.excluirSoldado(id);
        return new ModelAndView("redirect:/soldados/listar");
    }
    
    @RequestMapping("/logar")
    public final ModelAndView logar() {
        return new ModelAndView("login");
    }
}

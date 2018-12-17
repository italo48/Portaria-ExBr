package br.com.eb.portaria.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.eb.portaria.model.Registro;
import br.com.eb.portaria.model.Soldado;
import br.com.eb.portaria.service.RegistroService;
import br.com.eb.portaria.service.SoldadoService;

@Controller
@RequestMapping("/registros")
public class RegistroController {
    @Autowired
    private RegistroService regServ;
    @Autowired
    private SoldadoService sdServ;

    @RequestMapping("novo_registro")
    public final ModelAndView registrar(@RequestParam("numSd") final int num, 
    		@RequestParam("tipo") final String tipo) {
        ModelAndView mv = new ModelAndView("index");
        if (this.sdServ.existePorNumero(num)) {
            mv.addObject("mensagem", "Novo Registro adicionado!!");
            Soldado sd = this.sdServ.buscarPorNumero(num);
            Registro reg = new Registro(new Date(), sd, tipo);
            this.regServ.adicionarRegistro(reg);
        }
        return mv;
    }

    @RequestMapping("/listar")
    public final ModelAndView paginaListarRegistros() {
        ModelAndView mv = new ModelAndView("registros");
        List<Registro> registros = this.regServ.listarRegistros();
        mv.addObject("todosOsRegistros", registros);
        return mv;
    }

    @RequestMapping("/{id}")
    public final ModelAndView deletarRegistro(@PathVariable final Long id) {
        ModelAndView mv = new ModelAndView("redirect:/registros/listar");
        this.regServ.deletarRegistro(id);
        return mv;
    }
}

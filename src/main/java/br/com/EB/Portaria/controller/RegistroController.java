package br.com.EB.Portaria.controller;

import br.com.EB.Portaria.model.Registro;
import br.com.EB.Portaria.model.Soldado;
import br.com.EB.Portaria.service.RegistroService;
import br.com.EB.Portaria.service.SoldadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroService regServ;

    @Autowired
    private SoldadoService sdServ;

    @PostMapping("novo_registro")
    public ModelAndView Registrar(@RequestParam("numSd") int num, @RequestParam("tipo")String tipo){
        ModelAndView mv = new ModelAndView("index");

        if(this.sdServ.existePorNumero(num)){
            mv.addObject("mensagem", "Novo Registro adicionado!!");
            Soldado sd = this.sdServ.buscarPorNumero(num);
            Registro reg = new Registro(new Date(), sd, tipo);
            this.regServ.adicionarRegistro(reg);
        }
        return mv;
    }

    @GetMapping("/listar")
    public ModelAndView paginaListarRegistros(){
        ModelAndView mv = new ModelAndView("registros");
        List<Registro> registros = this.regServ.listarRegistros();
        mv.addObject("todosOsRegistros", registros);
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView deletarRegistro(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/registros/listar");
//        mv.addObject("msg", "Registro excluído");
        this.regServ.deletarRegistro(id);
        return mv;
    }
}
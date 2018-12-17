package br.com.EB.Portaria.service;

import br.com.EB.Portaria.model.Registro;
import br.com.EB.Portaria.model.Soldado;
import br.com.EB.Portaria.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository regRepo;

    public void adicionarRegistro(Registro reg){
        this.regRepo.save(reg);
    }

    public void deletarRegistro(Long id){
        this.regRepo.deleteById(id);
    }

    public List<Registro > listarRegistros(){
        return this.regRepo.findAll();
    }

    public void deletarRegistroPorIdSoldado(Long id){
        List<Registro> regList = this.regRepo.findBySd_Id(id);
        for(Registro reg : regList){
            this.regRepo.delete(reg);
        }
    }
}

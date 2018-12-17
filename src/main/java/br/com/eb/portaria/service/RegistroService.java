package br.com.eb.portaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.eb.portaria.model.Registro;
import br.com.eb.portaria.repository.RegistroRepository;
import java.util.List;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository regRepo;

    public final void adicionarRegistro(final Registro reg) {
        this.regRepo.save(reg);
    }

    public final void deletarRegistro(final Long id) {
        this.regRepo.deleteById(id);
    }

    public final List<Registro> listarRegistros() {
        return this.regRepo.findAll();
    }

    public final void deletarRegistroPorIdSoldado(final Long id) {
        List<Registro> regList = this.regRepo.findBySdId(id);
        for (Registro reg : regList) {
            this.regRepo.delete(reg);
        }
    }
}

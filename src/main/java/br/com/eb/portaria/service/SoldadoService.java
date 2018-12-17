package br.com.eb.portaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.eb.portaria.model.Soldado;
import br.com.eb.portaria.repository.SoldadoRepository;

@Service
public class SoldadoService {

    @Autowired
    private SoldadoRepository sdRepo;

    public final void adicionarSoldado(final Soldado sd) {
        sd.setSenha(new BCryptPasswordEncoder().encode(sd.getSenha()));
        this.sdRepo.save(sd);
    }

    public final List<Soldado> todosOsSoldados() {
        return this.sdRepo.findAll();
    }

    public final void excluirSoldado(final Long id) {
        this.sdRepo.deleteById(id);
    }

    public final boolean existePorId(final Long id) {
    	return this.sdRepo.existsById(id);
    }

    public final Soldado buscarPorId(final Long id) {
        return this.sdRepo.getOne(id);
    }

    public final Soldado buscarPorNumero(final int num) {
    	return this.sdRepo.findByNumero(num); 
    }

    public final boolean existePorNumero(final int num) {
    	return this.sdRepo.existsByNumero(num); 
    }
}

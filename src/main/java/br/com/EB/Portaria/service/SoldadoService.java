package br.com.EB.Portaria.service;

import br.com.EB.Portaria.model.Soldado;
import br.com.EB.Portaria.repository.SoldadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldadoService {

    @Autowired
    private SoldadoRepository sdRepo;

    public void adicionarSoldado(Soldado sd) {
        sd.setSenha(new BCryptPasswordEncoder().encode(sd.getSenha()));
        this.sdRepo.save(sd);
    }

    public List<Soldado> todosOsSoldados() {
        return this.sdRepo.findAll();
    }

    public void excluirSoldado(Long id) {
        this.sdRepo.deleteById(id);
    }

    public  boolean existePorId(Long id){
        return this.sdRepo.existsById(id);
    }

    public Soldado buscarPorId(Long id){
        return this.sdRepo.getOne(id);
    }

    public Soldado buscarPorNumero(int num){ return this.sdRepo.findByNumero(num); }

    public boolean existePorNumero(int num){ return this.sdRepo.existsByNumero(num); }
}

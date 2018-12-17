package br.com.EB.Portaria.repository;

import br.com.EB.Portaria.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro> findBySd_Id(Long id);
}

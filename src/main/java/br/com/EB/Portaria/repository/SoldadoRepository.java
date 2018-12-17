package br.com.EB.Portaria.repository;

import br.com.EB.Portaria.model.Soldado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldadoRepository extends JpaRepository<Soldado, Long> {
    Soldado findByLogin(String login);
    Soldado findByNumero(int numero);
    boolean existsByNumero(int numero);
}

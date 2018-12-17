package br.com.eb.portaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eb.portaria.model.Soldado;

@Repository
public interface SoldadoRepository extends JpaRepository<Soldado, Long> {
    Soldado findByLogin(String login);
    Soldado findByNumero(int numero);
    boolean existsByNumero(int numero);
}

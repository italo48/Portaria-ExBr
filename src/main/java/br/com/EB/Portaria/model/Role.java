package br.com.EB.Portaria.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String papel;
    @ManyToMany(mappedBy = "roles")
    private List<Soldado> soldados;

    @Override
    public String getAuthority() {
        return this.papel;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<Soldado> soldados) {
        this.soldados = soldados;
    }
}

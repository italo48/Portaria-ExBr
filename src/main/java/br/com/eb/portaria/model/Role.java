package br.com.eb.portaria.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
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
    public void setPapel(String papelUsuario) {
        this.papel = papelUsuario;
    }
    public List<Soldado> getSoldados() {
        return soldados;
    }
    public void setSoldados(List<Soldado> listaSoldados) {
        this.soldados = listaSoldados;
    }
}

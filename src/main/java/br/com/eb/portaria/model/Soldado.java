package br.com.eb.portaria.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Soldado implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;
    private String nomeDeGuerra;

    private int numero;
    private String batalhao;

    @NotNull
    private String login;
    @NotNull
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "soldados_role", joinColumns = @JoinColumn(
    				name = "soldado_id", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(
    						name = "role_id", referencedColumnName = "papel"))
    private List<Role> roles;

    public Soldado() {
    }

    public Soldado(
            @NotNull long idSoldado,
            int numeroSoldado,
            @NotNull String nomeSoldado,
            String nomeDeGuerraSoldado,
    		String batalhaoSoldado,
    		@NotNull String loginSoldado, 
    		@NotNull String senhaSoldado) {
    	this.id = idSoldado;
		this.nome = nomeSoldado;
		this.nomeDeGuerra = nomeDeGuerraSoldado;
		this.numero = numeroSoldado;
		this.batalhao = batalhaoSoldado;
		this.login = loginSoldado;
		this.senha = senhaSoldado;
	}

	public String getLogin() {
        return login;
    }

    public void setLogin(String loginSoldado) {
        this.login = loginSoldado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senhaSoldado) {
        this.senha = senhaSoldado;
    }

    public Long getId() {
        return id;
    }

    public void setId(long idSoldado) {
        this.id = idSoldado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeSoldado) {
        this.nome = nomeSoldado;
    }

    public String getNomeDeGuerra() {
        return nomeDeGuerra;
    }

    public void setNomeDeGuerra(String nomeDeGuerraSoldado) {
        this.nomeDeGuerra = nomeDeGuerraSoldado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numeroSoldado) {
        this.numero = numeroSoldado;
    }

    public String getBatalhao() {
        return this.batalhao;
    }

    public void setBatalhao(String batalhaoSoldado) {
        this.batalhao = batalhaoSoldado;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> rolesSoldado) {
        this.roles = rolesSoldado;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
//        (Collection<? extends GrantedAuthority>)
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

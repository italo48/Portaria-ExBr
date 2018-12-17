package br.com.EB.Portaria.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
public class Soldado implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @JoinTable(name = "soldados_role", joinColumns = @JoinColumn(name = "soldado_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "papel"))
    private List<Role> roles;

    public Soldado() {
    }

    public Soldado(@NotNull String nome, String nomeDeGuerra, @NotNull int numero, String batalhao) {
        this.nome = nome;
        this.nomeDeGuerra = nomeDeGuerra;
        this.numero = numero;
        this.batalhao = batalhao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDeGuerra() {
        return nomeDeGuerra;
    }

    public void setNomeDeGuerra(String nomeDeGuerra) {
        this.nomeDeGuerra = nomeDeGuerra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBatalhao() {
        return this.batalhao;
    }

    public void setBatalhao(String batalhao) {
        this.batalhao = batalhao;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) this.roles;
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

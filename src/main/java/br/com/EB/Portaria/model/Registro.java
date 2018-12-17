package br.com.EB.Portaria.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Date data;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "num_sd", referencedColumnName = "numero")
    private Soldado sd;

    private String tipo;

    public Registro() {
    }

    public Registro(@NotNull Date data, Soldado sd, String tipo) {
        this.data = data;
        this.sd = sd;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Soldado getSd() {
        return sd;
    }

    public void setSd(Soldado sd) {
        this.sd = sd;
    }
}

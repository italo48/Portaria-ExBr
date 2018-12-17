package br.com.eb.portaria.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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

    public Registro(@NotNull Date dataRegistro, Soldado sdRegistro, 
    		final String tipoRegistro) {
        this.data = dataRegistro;
        this.sd = sdRegistro;
        this.tipo = tipoRegistro;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long idRegistro) {
        this.id = idRegistro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date dataRegistro) {
        this.data = dataRegistro;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipoRegistro) {
        this.tipo = tipoRegistro;
    }

    public Soldado getSd() {
        return sd;
    }

    public void setSd(Soldado sdRegistro) {
        this.sd = sdRegistro;
    }
}

package com.snowmatch.dominio.dto;

import com.snowmatch.dominio.Match;
import com.snowmatch.dominio.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UsuarioDTO {

    private UUID id;
    private String nome;
    private String numero;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Boolean statusLogado;
    private List<Match> idMatchCurtidos;
    private List<Match> idMatchCurtiram;
    private Date dataCriacao;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getUsername();
        this.numero = concatenar(usuario.getDdd(), usuario.getNumeroTelefone());
        this.latitude = usuario.getLatitude();
        this.longitude = usuario.getLongitude();
        this.statusLogado = usuario.getStatusLogado();
        this.idMatchCurtidos = usuario.getIdMatchCurtidos();
        this.idMatchCurtiram = usuario.getIdMatchCurtiram();
        this.dataCriacao = usuario.getEntidadeBase().getDataCriacao();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Boolean getStatusLogado() {
        return statusLogado;
    }

    public void setStatusLogado(Boolean statusLogado) {
        this.statusLogado = statusLogado;
    }

    public List<Match> getIdMatchCurtidos() {
        return idMatchCurtidos;
    }

    public void setIdMatchCurtidos(List<Match> idMatchCurtidos) {
        this.idMatchCurtidos = idMatchCurtidos;
    }

    public List<Match> getIdMatchCurtiram() {
        return idMatchCurtiram;
    }

    public void setIdMatchCurtiram(List<Match> idMatchCurtiram) {
        this.idMatchCurtiram = idMatchCurtiram;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    private String concatenar(Integer valor1, Long valor2) {
        return String.valueOf(valor1).concat(String.valueOf(valor2));
    }
}

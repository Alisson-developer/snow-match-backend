package com.snowmatch.dominio.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import java.util.Date;
import org.hibernate.type.NumericBooleanConverter;

@Embeddable
public class EntidadeBase {

    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;

    @Column(name = "DT_EDICAO")
    protected Date dataEdicao;

    @Column(name = "DT_EXCLUSAO")
    protected Date dataExclusao;

    @Convert(converter = NumericBooleanConverter.class)
    @Column(name = "BO_ATIVO", columnDefinition = "NUMERIC")
    protected Boolean ativo;

    @Convert(converter = NumericBooleanConverter.class)
    @Column(name = "BO_EDITADO", columnDefinition = "NUMERIC")
    protected Boolean editado;

    @Convert(converter = NumericBooleanConverter.class)
    @Column(name = "BO_EXCLUIDO", columnDefinition = "NUMERIC")
    protected Boolean excluido;

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public boolean getAtivo() {
        return ativo != null && ativo.equals(Boolean.TRUE);
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getEditado() {
        return editado != null && editado.equals(Boolean.TRUE);
    }

    public void setEditado(Boolean editado) {
        this.editado = editado;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(Boolean excluido) {
        this.excluido = excluido;
    }

}

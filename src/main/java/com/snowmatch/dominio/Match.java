package com.snowmatch.dominio;

import com.snowmatch.dominio.vo.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.UUID;
import org.hibernate.type.NumericBooleanConverter;

@Entity
@Table(name = "MATCH")
public class Match {

    @Id
    @Column(name = "ID_MATCH")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO_REMENTENTE")
    private Usuario usuarioRementente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO_DESTINATAR")
    private Usuario usuarioDestinatario;

    @Column(name = "BO_MATCH")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isMatch;

    @Embedded
    private EntidadeBase entidadeBase;

    @Version
    @Column(name = "NU_VERSAO", columnDefinition = "NUMERIC")
    private Long versao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Usuario getUsuarioRementente() {
        return usuarioRementente;
    }

    public void setUsuarioRementente(Usuario usuarioRementente) {
        this.usuarioRementente = usuarioRementente;
    }

    public Usuario getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

    public Boolean getMatch() {
        return isMatch;
    }

    public void setMatch(Boolean match) {
        this.isMatch = match;
    }

    public EntidadeBase getEntidadeBase() {
        return entidadeBase;
    }

    public void setEntidadeBase(EntidadeBase entidadeBase) {
        this.entidadeBase = entidadeBase;
    }

    public Long getVersao() {
        return versao;
    }

    public void setVersao(Long versao) {
        this.versao = versao;
    }
}

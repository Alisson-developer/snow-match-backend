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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.hibernate.type.NumericBooleanConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(name = "NU_DDD", nullable = false)
    private Integer ddd;

    @Column(name = "NU_NUMERO_TELEFONE", nullable = false)
    private Long numeroTelefone;

    @Column(name = "NU_LATITUDE", nullable = false)
    private BigDecimal latitude;

    @Column(name = "NU_LONGITUDE", nullable = false)
    private BigDecimal longitude;

    @Column(name = "BO_LOGADO")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean statusLogado;

    @OneToMany(mappedBy = "usuarioRementente", fetch = FetchType.LAZY)
    private List<Match> idMatchCurtidos;

    @OneToMany(mappedBy = "usuarioDestinatario", fetch = FetchType.LAZY)
    private List<Match> idMatchCurtiram;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Long getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(Long numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

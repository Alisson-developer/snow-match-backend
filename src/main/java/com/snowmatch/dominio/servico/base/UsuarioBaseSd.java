package com.snowmatch.dominio.servico.base;

import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.UsuarioDTO;
import com.snowmatch.dominio.repositorio.IUsuarioDados;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public abstract class UsuarioBaseSd implements UserDetailsService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected IUsuarioDados usuarioDados;

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) {
        return usuarioDados.findByNome(nomeUsuario);
    }

    public abstract void incluir(Usuario usuario);

    protected List<UsuarioDTO> obterTodos() {
        return obterAtivos();
    }

    public abstract UsuarioDTO obterPorId(UUID idUsuario);

    private List<UsuarioDTO> obterAtivos() {
        final boolean STATUS_ATIVO = true;
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = criteria.createQuery(Usuario.class);
        Root<Usuario> usuarioRoot = query.from(Usuario.class);
        Predicate statusAtivo = criteria.equal(usuarioRoot.get("entidadeBase").get("ativo"), STATUS_ATIVO);
        query.where(statusAtivo);
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList().stream().map(UsuarioDTO::new).toList();
    }
}

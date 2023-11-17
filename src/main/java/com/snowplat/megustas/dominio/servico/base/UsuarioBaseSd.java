package com.snowplat.megustas.dominio.servico.base;

import com.snowplat.megustas.dominio.Usuario;
import com.snowplat.megustas.dominio.dto.UsuarioDTO;
import com.snowplat.megustas.dominio.repositorio.IUsuarioDados;
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
import org.springframework.stereotype.Service;

@Service
public abstract class UsuarioBaseSd {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected IUsuarioDados usuarioDados;

    public abstract void incluir(Usuario usuario);

    protected List<UsuarioDTO> obterTodos() {
        return obterAtivos();
    }

    public abstract UsuarioDTO obterPorId(UUID idUsuario);

    private List<UsuarioDTO> obterAtivos() {
        final int STATUS_ATIVO = 1;
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = criteria.createQuery(Usuario.class);
        Root<Usuario> usuarioRoot = query.from(Usuario.class);
        Predicate statusAtivo = criteria.equal(usuarioRoot.get("ativo"), STATUS_ATIVO);
        query.where(statusAtivo);
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList().stream().map(UsuarioDTO::new).toList();
    }
}

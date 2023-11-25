package com.snowmatch.dominio.repositorio;

import com.snowmatch.dominio.Usuario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDados extends JpaRepository<Usuario, UUID> {

    Usuario findByNome(String nome);

}

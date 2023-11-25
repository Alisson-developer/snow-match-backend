package com.snowmatch.dominio.repositorio;

import com.snowmatch.anotacoes.SnowRepository;
import com.snowmatch.dominio.Usuario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@SnowRepository
public interface IUsuarioDados extends JpaRepository<Usuario, UUID> {

    Usuario findByNome(String nome);

}

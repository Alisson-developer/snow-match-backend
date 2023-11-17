package com.snowplat.megustas.dominio.repositorio;

import com.snowplat.megustas.dominio.Usuario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDados extends JpaRepository<Usuario, UUID> {
}

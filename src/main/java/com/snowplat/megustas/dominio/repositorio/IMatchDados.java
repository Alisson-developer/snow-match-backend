package com.snowplat.megustas.dominio.repositorio;

import com.snowplat.megustas.dominio.Match;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchDados extends JpaRepository<Match, UUID> {
}

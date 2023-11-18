package com.snowmatch.dominio.repositorio;

import com.snowmatch.dominio.Match;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchDados extends JpaRepository<Match, UUID> {
}

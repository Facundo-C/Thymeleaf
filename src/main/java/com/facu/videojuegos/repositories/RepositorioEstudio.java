package com.facu.videojuegos.repositories;

import com.facu.videojuegos.entities.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudio extends JpaRepository<Estudio, Long> {
}

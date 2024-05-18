package edu.javeriana.ingenieria.social.actividad_economica.repositorio;

import edu.javeriana.ingenieria.social.actividad_economica.dominio.ActividadEconomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioActividadEconomica extends JpaRepository<ActividadEconomica, Integer> {
    ActividadEconomica findOneByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}

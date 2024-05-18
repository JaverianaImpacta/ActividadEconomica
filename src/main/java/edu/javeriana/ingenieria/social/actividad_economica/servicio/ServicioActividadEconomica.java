package edu.javeriana.ingenieria.social.actividad_economica.servicio;

import edu.javeriana.ingenieria.social.actividad_economica.dominio.ActividadEconomica;
import edu.javeriana.ingenieria.social.actividad_economica.repositorio.RepositorioActividadEconomica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioActividadEconomica {
    @Autowired
    private RepositorioActividadEconomica repositorio;

    public List<ActividadEconomica> obtenerActividadesEconomicas() {
        return repositorio.findAll();
    }

    public ActividadEconomica obtenerActividadEconomica(String codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public boolean actividadEconomicaExiste(String codigo){
        return repositorio.existsByCodigo(codigo);
    }
}

package edu.javeriana.ingenieria.social.actividad_economica.controlador;

import edu.javeriana.ingenieria.social.actividad_economica.dominio.ActividadEconomica;
import edu.javeriana.ingenieria.social.actividad_economica.servicio.ServicioActividadEconomica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/actividadesEconomicas")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorActividadEconomica{
    @Autowired
    private ServicioActividadEconomica servicio;

    @GetMapping("listar")
    public List<ActividadEconomica> obtenerActividadesEconomicas(){
        return servicio.obtenerActividadesEconomicas();
    }

    @GetMapping("obtener")
    public ResponseEntity<ActividadEconomica> obtenerActividadEconomica(@RequestParam String codigo){
        if(codigo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.actividadEconomicaExiste(codigo)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerActividadEconomica(codigo), HttpStatus.OK);
    }
}

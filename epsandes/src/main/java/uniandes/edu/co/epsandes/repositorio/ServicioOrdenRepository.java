package uniandes.edu.co.epsandes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.epsandes.modelo.ServicioOrden;
import uniandes.edu.co.epsandes.modelo.ServicioOrdenPK;

public interface ServicioOrdenRepository extends JpaRepository<ServicioOrden, ServicioOrdenPK> {

    @Query("SELECT s FROM ServicioOrden s")
    List<ServicioOrden> darServiciosOrden();

    @Query("SELECT s FROM ServicioOrden s WHERE s.pk.orden.id = :ordenId")
    List<ServicioOrden> darServicioOrdenPorOrdenId(Integer ordenId);

    @Query("SELECT s FROM ServicioOrden s WHERE s.pk.servicioDeSalud.id = :servicioId")
    List<ServicioOrden> darServicioOrdenPorServicioId(Integer servicioId);

    @Query("DELETE FROM ServicioOrden s WHERE s.pk.orden.id = :ordenId AND s.pk.servicioDeSalud.id = :servicioId")
    void eliminarServicioOrden(Integer ordenId, Integer servicioId);

    @Query("INSERT INTO ServicioOrden (orden_id, servicioDeSalud_id) VALUES (:ordenId, :servicioId)")
    void insertarServicioOrden(Integer ordenId, Integer servicioId);

    @Query("UPDATE ServicioOrden s SET s.pk.servicioDeSalud.id = :servicioId WHERE s.pk.orden.id = :ordenId AND s.pk.servicioDeSalud.id = :servicioId")
    void actualizarServicioOrden(Integer ordenId, Integer servicioId);




}

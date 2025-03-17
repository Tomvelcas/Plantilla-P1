package uniandes.edu.co.epsandes.repositorio;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("UPDATE ServicioOrden s SET s.pk.orden.id = :ordenIdActualizado, s.pk.servicioDeSalud.id = :servicioIdActualizado WHERE s.pk.orden.id = :ordenId AND s.pk.servicioDeSalud.id = :servicioId")
    void actualizarServicioOrden(Integer ordenId, Integer servicioId, Integer servicioIdActualizado, Integer ordenIdActualizado);

    @Query(value = "SELECT s.ServicioDeSalud_ID AS servicioId, COUNT(*) AS totalSolicitudes " +
               "FROM ServicioOrden s " +
               "JOIN OrdenDeServicio o ON s.OrdenDeServicio_ID_Orden = o.ID_Orden " +
               "WHERE o.Fecha BETWEEN :fechaInicio AND :fechaFin " +
               "GROUP BY s.ServicioDeSalud_ID " +
               "ORDER BY totalSolicitudes DESC " +
               "LIMIT 20", 
       nativeQuery = true)
    List<Object[]> obtenerVeinteServiciosMasSolicitados(@Param("fechaInicio") Timestamp fechaInicio, @Param("fechaFin") Timestamp fechaFin);

}

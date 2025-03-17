package uniandes.edu.co.epsandes.repositorio;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.OrdenDeServicio;

public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Integer> {

    @Query(value = "SELECT * FROM OrdenDeServicio", nativeQuery = true)
    Collection<OrdenDeServicio> darOrdenDeServicios();

    @Query(value = "SELECT * FROM OrdenDeServicio WHERE id = :id", nativeQuery = true)
    OrdenDeServicio darOrdenDeServicioPorId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenDeServicio WHERE id = :id", nativeQuery = true)
    void eliminarOrdenDeServicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenDeServicio SET fecha = :fecha, hora = :hora, estado_orden = :estado_orden, tipo_servicio = :tipo_servicio, medico_numerodocumento = :medicoId, afiliado_numerodocumento = :afiliadoId WHERE id = :id", nativeQuery = true)
    void actualizarOrdenDeServicio(@Param("id") Integer id, 
                         @Param("fecha") Date fecha, 
                         @Param("hora") Time hora, 
                         @Param("estado_orden") String estadoOrden, 
                         @Param("tipo_servicio") String tipoServicio, 
                         @Param("medicoId") Integer medicoId, 
                         @Param("afiliadoId") Integer afiliadoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenDeServicio (fecha, hora, estado_orden, tipo_servicio, medico_numerodocumento, afiliado_numerodocumento) VALUES (:fecha, :hora, :estado_orden, :tipo_servicio, :medicoId, :afiliadoId)", nativeQuery = true)
    void insertarOrdeDeServicio(@Param("fecha") Date fecha, 
                       @Param("hora") Time hora, 
                       @Param("estado_orden") String estadoOrden, 
                       @Param("tipo_servicio") String tipoServicio, 
                       @Param("medicoId") Integer medicoId, 
                       @Param("afiliadoId") Integer afiliadoId);
}

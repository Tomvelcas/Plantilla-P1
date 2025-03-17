package uniandes.edu.co.epsandes.repositorio;

import java.sql.Timestamp;
import java.util.Collection;

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
    @Query(value = "UPDATE OrdenDeServicio SET fecha = :fecha_hora, estado_orden = :estado_orden, medico_numerodocumento, afiliado_numerodocumento WHERE id = :id", nativeQuery = true)
    void actualizarOrdenDeServicio(@Param("id") Integer id, 
                         @Param("fecha_hora") Timestamp fecha_hora, 
                         @Param("estado_orden") String estadoOrden, 
                         @Param("medico_numerodocumento") Integer medico_numerodocumento, 
                         @Param("afiliado_numerodocumento") Integer afiliado_numerodocumento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenDeServicio (fecha_hora, estado_orden, tipo_servicio, medico_numerodocumento, afiliado_numerodocumento) VALUES (:fecha, :hora, :estado_orden, :tipo_servicio, :medicoId, :afiliadoId)", nativeQuery = true)
    void insertarOrdeDeServicio(@Param("fecha_hora") Timestamp fecha_hora, 
                       @Param("estado_orden") String estadoOrden, 
                       @Param("medico_numerodocumento") Integer medico_numerodocumento, 
                       @Param("afiliado_numerodocumento") Integer afiliado_numerodocumento);
}

package uniandes.edu.co.epsandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.AgendarCita;

public interface AgendarCitaRepository extends JpaRepository<AgendarCita, Integer> {

    @Query(value = "SELECT * FROM AgendarCita", nativeQuery = true)
    Collection<AgendarCita> darAgendarCitas();

    @Query(value = "SELECT * FROM AgendarCita WHERE id = :id", nativeQuery = true)
    AgendarCita darAgendarCitaPorId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM AgendarCita WHERE id = :id", nativeQuery = true)
    void eliminarAgendarCita(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE AgendarCita SET fecha = :fecha_hora WHERE id = :id", nativeQuery = true)
    void actualizarAgendarCita(@Param("id") long id, @Param("fecha_hora") java.sql.Timestamp fecha_hora);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AgendarCita (id, fecha_hora, afiliado_numerodocumento, medico_numerodocumento, id_ordendeservicio, id_serviciodesalud) " +
                   "VALUES (:id, :fecha, :afiliado, :medico, :orden, :servicio)", nativeQuery = true)
    void agregarAgendarCita(@Param("id") long id, @Param("fecha_hora") java.sql.Timestamp fecha_hora, @Param("afiliado") long afiliado, @Param("medico") long medico, @Param("orden") long orden, @Param("servicio") long servicio);

    @Query(value = "SELECT * FROM AgendarCita " +
                   "WHERE ServicioSalud_ID = :idServicio " +
                   "AND Fecha_hora BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 4 WEEK)", 
           nativeQuery = true)
    Collection<AgendarCita> darAgendarCitasPorServicioCuatroSemanas(@Param("idServicio") long idServicio);


}
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
    @Query(value = "UPDATE AgendarCita SET fecha = :fecha, hora = :hora WHERE id = :id", nativeQuery = true)
    void actualizarAgendarCita(@Param("id") long id, @Param("fecha") java.sql.Date fecha, @Param("hora") java.sql.Time hora);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AgendarCita (id, fecha, hora) VALUES (epsandes_sequence.nextval, :fecha, :hora)", nativeQuery = true)
    void insertarAgendarCita(@Param("fecha") java.sql.Date fecha, @Param("hora") java.sql.Time hora);
}
package uniandes.edu.co.epsandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.PrestacionServicio;
import uniandes.edu.co.epsandes.modelo.PrestacionServicioPK;

public interface PrestacionServicioRepository extends JpaRepository<PrestacionServicio, PrestacionServicioPK> {

    @Query(value = "SELECT * FROM PrestacionServicio", nativeQuery = true)
    Collection<PrestacionServicio> darPrestacionServicios();

    @Query(value = "SELECT * FROM PrestacionServicio WHERE ips_nit = :ipsNit AND id_cita = :idCita", nativeQuery = true)
    PrestacionServicio darPrestacionServicioPorId(@Param("ipsNit") Integer ipsNit, @Param("idCita") Integer idCita);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrestacionServicio WHERE ips_nit = :ipsNit AND id_cita = :idCita", nativeQuery = true)
    void eliminarPrestacionServicio(@Param("ipsNit") Integer ipsNit, @Param("idCita") Integer idCita);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PrestacionServicio SET citaRealizada = :citaRealizada WHERE ips_nit = :ipsNit AND id_cita = :idCita", nativeQuery = true)
    void actualizarPrestacionServicio(@Param("ipsNit") Integer ipsNit, 
                              @Param("idCita") Integer idCita, 
                              @Param("citaRealizada") Integer citaRealizada);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PrestacionServicio (ips_nit, id_cita, citaRealizada) VALUES (:ipsNit, :idCita, :citaRealizada)", nativeQuery = true)
    void insertarPrestacionServicio(@Param("ipsNit") Integer ipsNit, 
                            @Param("idCita") Integer idCita, 
                            @Param("citaRealizada") Integer citaRealizada);
}

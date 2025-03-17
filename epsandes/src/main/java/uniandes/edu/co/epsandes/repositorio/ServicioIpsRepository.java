package uniandes.edu.co.epsandes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.ServicioIps;
import uniandes.edu.co.epsandes.modelo.ServicioIpsPK;

public interface ServicioIpsRepository extends JpaRepository<ServicioIps, ServicioIpsPK> {

    @Query("SELECT s FROM ServicioIps s")
    List<ServicioIps> darServiciosIps();

    @Query("SELECT s FROM ServicioIps s WHERE s.pk.nit.nit = :nit")
    List<ServicioIps> darServicioIpsPorNit(@Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query("DELETE FROM ServicioIps s WHERE s.pk.nit.nit = :nit AND s.pk.id_serviciodesalud.id = :servicioId")
    void eliminarServicioIps(@Param("nit") Integer nit, @Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query("INSERT INTO ServicioIps (nit, id_serviciodesalud) VALUES (:nit, :servicioId)")
    void insertarServicioIps(@Param("nit") Integer nit, @Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query("UPDATE ServicioIps s SET s.pk.id_serviciodesalud.id = :servicioIdActualizado WHERE s.pk.nit.nit = :nit AND s.pk.id_serviciodesalud.id = :servicioId")
    void actualizarServicioIps(@Param("nit") Integer nit, @Param("servicioId") Integer servicioId, @Param("servicioIdActualizado") Integer servicioIdActualizado);

}

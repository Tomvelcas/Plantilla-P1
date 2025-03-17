package uniandes.edu.co.epsandes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.epsandes.modelo.ServiciosMedico;
import uniandes.edu.co.epsandes.modelo.ServiciosMedicoPK;

@Repository
public interface ServiciosMedicoRepository extends JpaRepository<ServiciosMedico, ServiciosMedicoPK> {

    @Query(value = "SELECT * FROM ServiciosMedico", nativeQuery = true)
    List<ServiciosMedico> darServiciosMedico();

    @Query(value = "SELECT * FROM ServiciosMedico WHERE medico_numerodocumento = :medicoId AND id_serviciodesalud = :servicioId", nativeQuery = true)
    ServiciosMedico darServiciosMedicoPorNumeroDocumento(@Param("medicoId") Integer medicoId, @Param("servicioId") Integer servicioId);

    @Query(value = "INSERT INTO ServiciosMedico (medico_numerodocumento, id_serviciodesalud) VALUES (:medicoId, :servicioId)", nativeQuery = true)
    void insertarServiciosMedico(@Param("medicoId") Integer medicoId, @Param("servicioId") Integer servicioId);

    @Query(value = "DELETE FROM ServiciosMedico WHERE medico_numerodocumento = :medicoId AND id_serviciodesalud = :servicioId", nativeQuery = true)
    void eliminarServiciosMedico(@Param("medicoId") Integer medicoId, @Param("servicioId") Integer servicioId);

    @Query(value = "UPDATE ServiciosMedico SET medico_numerodocumento = :medicoIdActualizado, id_serviciodesalud = :servicioIdActualizado WHERE medico_numerodocumento = :medicoId AND id_serviciodesalud = :servicioId", nativeQuery = true)
    void actualizarServiciosMedico(@Param("medicoId") Integer medicoId, @Param("servicioId") Integer servicioId, @Param("medicoIdActualizado") Integer medicoIdActualizado, @Param("servicioIdActualizado") Integer servicioIdActualizado);
}

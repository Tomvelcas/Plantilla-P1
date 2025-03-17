package uniandes.edu.co.epsandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    @Query(value = "SELECT * FROM Medico", nativeQuery = true)
    Collection<Medico> darMedicos();

    @Query(value = "SELECT * FROM Medico WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
    Medico darMedicoPorNumeroDocumento(@Param("numeroDocumento") Integer numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Medico WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
    void eliminarMedico(@Param("numeroDocumento") Integer numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Medico SET nombre = :nombre, tipoDocumento = :tipoDocumento, numeroRegistroMedico = :numeroRegistroMedico, especialidad = :especialidad, ips_nit = :ipsNit WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
    void actualizarMedico(@Param("numeroDocumento") Integer numeroDocumento, 
                          @Param("nombre") String nombre, 
                          @Param("tipoDocumento") String tipoDocumento, 
                          @Param("numeroRegistroMedico") Integer numeroRegistroMedico, 
                          @Param("especialidad") String especialidad, 
                          @Param("ipsNit") Integer ipsNit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Medico (numeroDocumento, nombre, tipoDocumento, numeroRegistroMedico, especialidad, ips_nit) VALUES (:numeroDocumento, :nombre, :tipoDocumento, :numeroRegistroMedico, :especialidad, :ipsNit)", nativeQuery = true)
    void insertarMedico(@Param("numeroDocumento") Integer numeroDocumento, 
                        @Param("nombre") String nombre, 
                        @Param("tipoDocumento") String tipoDocumento, 
                        @Param("numeroRegistroMedico") Integer numeroRegistroMedico, 
                        @Param("especialidad") String especialidad, 
                        @Param("ipsNit") Integer ipsNit);
}

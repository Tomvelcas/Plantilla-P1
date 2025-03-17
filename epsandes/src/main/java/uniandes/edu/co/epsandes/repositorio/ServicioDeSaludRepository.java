package uniandes.edu.co.epsandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.ServicioDeSalud;

public interface ServicioDeSaludRepository extends JpaRepository<ServicioDeSalud, Integer> {

    @Query(value = "SELECT * FROM ServicioDeSalud", nativeQuery = true)
    Collection<ServicioDeSalud> darServiciosDeSalud();

    @Query(value = "SELECT * FROM ServicioDeSalud WHERE id = :id", nativeQuery = true)
    ServicioDeSalud darServicioDeSaludPorId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ServicioDeSalud WHERE id = :id", nativeQuery = true)
    void eliminarServicioDeSalud(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ServicioDeSalud SET nombre = :nombre, descripcion = :descripcion, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarServicioDeSalud(@Param("id") Integer id, 
                            @Param("nombre") String nombre, 
                            @Param("descripcion") String descripcion, 
                            @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ServicioDeSalud (nombre, descripcion, tipo) VALUES (:nombre, :descripcion, :tipo)", nativeQuery = true)
    void insertarServicioDeSalud(@Param("nombre") String nombre, 
                          @Param("descripcion") String descripcion, 
                          @Param("tipo") String tipo);
}

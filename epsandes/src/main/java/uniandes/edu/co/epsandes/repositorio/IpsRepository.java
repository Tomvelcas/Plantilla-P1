package uniandes.edu.co.epsandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.Ips;

public interface IpsRepository extends JpaRepository<Ips, Integer> {

    @Query(value = "SELECT * FROM Ips", nativeQuery = true)
    Collection<Ips> darIps();

    @Query(value = "SELECT * FROM Ips WHERE nit = :nit", nativeQuery = true)
    Ips darIpsPorNit(@Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Ips WHERE nit = :nit", nativeQuery = true)
    void eliminarIps(@Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ips SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE nit = :nit", nativeQuery = true)
    void actualizarIps(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") Integer telefono);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ips (nit, nombre, direccion, telefono) VALUES (:nit, :nombre, :direccion, :telefono)", nativeQuery = true)
    void insertarIps(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("telefono") Integer telefono);
}

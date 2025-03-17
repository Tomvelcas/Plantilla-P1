package uniandes.edu.co.epsandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.epsandes.modelo.Afiliado;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {

    @Query(value = "SELECT * FROM Afiliado", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM Afiliado WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
    Afiliado darAfiliadoPorNumeroDocumento(@Param("numeroDocumento") Integer numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Afiliado WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
    void eliminarAfiliado(@Param("numeroDocumento") Integer numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Afiliado SET tipo_documento = :tipo_documento, nombre = :nombre, fecha_nacimiento = :fecha_nacimiento, direccion = :direccion, telefono = :telefono, tipo_afiliado = :tipo_afiliado, documento_contribuyente = :documento_contribuyente, parentesco = :parentesco WHERE numeroDocumento = :numeroDocumento", nativeQuery = true)
    void actualizarAfiliado(
        @Param("numeroDocumento") Integer numeroDocumento,
        @Param("tipo_documento") String tipo_documento,
        @Param("nombre") String nombre,
        @Param("fecha_nacimiento") java.sql.Date fecha_nacimiento,
        @Param("direccion") String direccion,
        @Param("telefono") Integer telefono,
        @Param("tipo_afiliado") String tipo_afiliado,
        @Param("documento_contribuyente") Integer documento_contribuyente,
        @Param("parentesco") String parentesco
    );

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Afiliado (numeroDocumento, tipo_documento, nombre, fecha_nacimiento, direcion, telefono, tipo_afiliado, documento_contribuyente, parentesco) " +
                   "VALUES (:numeroDocumento, :tipo_documento, :nombre, :fecha_nacimiento, :direccion, :telefono, :tipo_afiliado, :documento_contribuyente, :parentesco)", nativeQuery = true)
    void agregarAfiliado(
        @Param("numeroDocumento") Integer numeroDocumento,
        @Param("tipo_documento") String tipo_documento,
        @Param("nombre") String nombre,
        @Param("fecha_nacimiento") java.sql.Date fecha_nacimiento,
        @Param("direccion") String direccion,
        @Param("telefono") Integer telefono,
        @Param("tipo_afiliado") String tipo_afiliado,
        @Param("documento_contribuyente") Integer documento_contribuyente,
        @Param("parentesco") String parentesco
    );
}

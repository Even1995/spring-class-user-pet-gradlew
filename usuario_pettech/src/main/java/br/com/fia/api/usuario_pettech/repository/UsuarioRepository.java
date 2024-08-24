package br.com.fia.api.usuario_pettech.repository;

import br.com.fia.api.usuario_pettech.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

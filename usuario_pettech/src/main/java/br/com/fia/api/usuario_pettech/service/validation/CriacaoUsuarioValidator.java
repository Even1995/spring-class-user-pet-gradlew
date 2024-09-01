package br.com.fia.api.usuario_pettech.service.validation;

import br.com.fia.api.usuario_pettech.dto.UsuarioDTO;
import br.com.fia.api.usuario_pettech.entities.Usuario;
import br.com.fia.api.usuario_pettech.repository.UsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CriacaoUsuarioValidator implements ConstraintValidator<CriacaoUsuarioValid, UsuarioDTO> {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public void initialize(CriacaoUsuarioValid anotation){}
    @Override
    public boolean isValid(UsuarioDTO dto, ConstraintValidatorContext context) {
        Optional<Usuario> usuario = repository.findByEmail(dto.email());
        return usuario.isEmpty();
    }
}
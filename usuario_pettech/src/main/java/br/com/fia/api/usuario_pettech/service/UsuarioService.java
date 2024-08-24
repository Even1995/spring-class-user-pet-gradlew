package br.com.fia.api.usuario_pettech.service;

import br.com.fia.api.usuario_pettech.controller.exception.ControllerNotFoundException;
import br.com.fia.api.usuario_pettech.dto.UsuarioDTO;
import br.com.fia.api.usuario_pettech.entities.Usuario;
import br.com.fia.api.usuario_pettech.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private  final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository= usuarioRepository;
    }
    public Page<UsuarioDTO> findAll(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return usuarios.map(this::toDTO);
    }
    public UsuarioDTO findById(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new ControllerNotFoundException("usuário não encontrado"));
        return toDTO(usuario);
    }
    public UsuarioDTO save(UsuarioDTO usuarioDTO){
        Usuario usuario = toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return toDTO(usuario);
    }
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO){
        try{
            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuario.setNome(usuarioDTO.nome());
            usuario.setEmail(usuarioDTO.email());
            usuario.setCpf(usuarioDTO.cpf());
            usuario.setDataNascimento(usuarioDTO.dataNascimento());
            usuario = usuarioRepository.save(usuario);
            return toDTO(usuario);

        }catch(EntityNotFoundException e){
            throw new ControllerNotFoundException("Usuario nao encontrado");

        }
    }
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getDataNascimento()
        );
    }

    private Usuario toEntity(UsuarioDTO usuarioDTO){
        return new Usuario(
                usuarioDTO.id(),
                usuarioDTO.nome(),
                usuarioDTO.cpf(),
                usuarioDTO.email(),
                usuarioDTO.dataNascimento()
                );

    }
}

package br.com.fia.api.usuario_pettech.controller;

import br.com.fia.api.usuario_pettech.dto.UsuarioDTO;
import br.com.fia.api.usuario_pettech.repository.UsuarioRepository;
import br.com.fia.api.usuario_pettech.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

 private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    public ResponseEntity<Page<UsuarioDTO>> findAll(
            @PageableDefault(size= 10, page= 0, sort= "nome")Pageable pageable
            ){
            Page<UsuarioDTO> usuarioDTO = usuarioService.findAll(pageable);
            return ResponseEntity.ok(usuarioDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO savedUsuario = usuarioService.save(usuarioDTO);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO ){
        UsuarioDTO updatedUsuario = usuarioService.update(id, usuarioDTO);
        return ResponseEntity.ok(updatedUsuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
       usuarioService.delete(id);
       return ResponseEntity.noContent().build();
    }
}
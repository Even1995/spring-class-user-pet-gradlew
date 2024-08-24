package br.com.fia.api.usuario_pettech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UsuarioDTO (
        Long id,
        @NotBlank(message= "O Campo não pode estar em branco")
        String nome,
        @CPF(message = "CPF invalido")
        String cpf,
        @Email(message= "Email invalido")
        String email,
        LocalDate dataNascimento
){
}

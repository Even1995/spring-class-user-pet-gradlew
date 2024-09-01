package br.com.fia.api.usuario_pettech.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CriacaoUsuarioValidator.class)
public @interface CriacaoUsuarioValid{
    String message() default  "Validation error";

    Class<?>[] groups() default  {};

    Class<? extends Payload> [] payload() default {};
}
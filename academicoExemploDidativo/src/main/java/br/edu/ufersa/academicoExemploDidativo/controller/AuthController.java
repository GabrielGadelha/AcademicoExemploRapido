package br.edu.ufersa.academicoExemploDidativo.controller;

import br.edu.ufersa.academicoExemploDidativo.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    // Credenciais simuladas para demonstração didática
    private static final String EMAIL_PADRAO = "professor@ufersa.edu.br";
    private static final String SENHA_PADRAO = "123456";

    @PostMapping("/login")
    public ResponseEntity autenticar(@Valid @RequestBody LoginRequest credenciais) {
        if (EMAIL_PADRAO.equalsIgnoreCase(credenciais.email().trim())
                && SENHA_PADRAO.equals(credenciais.senha())) {
            return ResponseEntity.ok(Map.of(
                    "email", EMAIL_PADRAO,
                    "nome", "Prof. Gabriel Gadelha",
                    "mensagem", "Autenticação realizada com sucesso"
            ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("erro", "E-mail ou senha inválidos."));
    }
}

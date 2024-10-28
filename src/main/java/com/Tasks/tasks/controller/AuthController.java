package com.Tasks.tasks.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Simulando usuarios con un nombre de usuario y contraseña
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    @PostMapping("/login")
    public String login(@RequestBody Credentials credentials) {
        if (credentials.getUsername().equals(USERNAME) && credentials.getPassword().equals(PASSWORD)) {
            return "Login exitoso"; // Aquí podrías devolver un token o un mensaje
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }

    // Clase estática para recibir las credenciales
    public static class Credentials {
        private String username;
        private String password;

        // Getters y Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

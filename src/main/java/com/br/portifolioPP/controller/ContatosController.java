package com.br.portifolioPP.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.portifolioPP.service.EmailService;
import com.br.portifolioPP.DTO.EmailRequest;

@RestController
@RequestMapping("/api/contato")
@CrossOrigin(origins = "https://www.peterabenza.com.br")
public class ContatosController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody Map<String, Object> payload) {
        EmailRequest request = new EmailRequest();
        request.setNome((String) payload.get("nome"));
        request.setEmail((String) payload.get("email"));
        request.setMensagem((String) payload.get("mensagem"));

        emailService.enviarMensagem(request);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}

package com.br.portifolioPP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.br.portifolioPP.DTO.EmailRequest;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarMensagem(EmailRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("abenzpeter@gmail.com");
            message.setSubject("Mensagem do site PeterAbenza - " + request.getNome());
            message.setText(
                "Nome: " + request.getNome() + "\n" +
                "Email: " + request.getEmail() + "\n\n" +
                request.getMensagem()
            );
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
    
    public void enviarMensagemSimples(String assunto, String texto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("abenzpeter@gmail.com");
            message.setSubject(assunto);
            message.setText(texto);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage());
        }
    }

}

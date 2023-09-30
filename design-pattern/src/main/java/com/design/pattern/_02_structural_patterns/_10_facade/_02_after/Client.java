package com.design.pattern._02_structural_patterns._10_facade._02_after;

public class Client {
    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");
        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo("mho@google.me");
        emailMessage.setFrom("mho@naber.me");
        emailMessage.setSubject("Facade Pattern Java Email Send Program");
        emailMessage.setText("Is message");
        emailSender.sendEmail(emailMessage);
    }
}

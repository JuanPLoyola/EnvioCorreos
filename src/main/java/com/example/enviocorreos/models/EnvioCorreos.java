// @En el siguiente codigo me base de "L-code" y su video de youtube https://www.youtube.com/watch?v=ZggjlwLzrxg&t=161s
// de igual manera lo modifique para poder utilizarlo

package com.example.enviocorreos.models;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnvioCorreos {

    /*todo: los atributos para enviar correos sera el correo que usaremos,
            la contraseña para acceso de terceros; lo demas se explicara mas abajo.
     */
    private static final String emailFrom = "javagosconf@gmail.com";
    private static final String passwordFrom = "ohssfvfppoahkdqp";
    private static  String emailTo;
    private static  String subject;
    private static  String content;


    public static String getEmailTo() {
        return emailTo;
    }

    public static void setEmailTo(String emailTo) {
        EnvioCorreos.emailTo = emailTo;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        EnvioCorreos.subject = subject;
    }

    public static String getContent() {
        return content;
    }

    public static void setContent(String content) {
        EnvioCorreos.content = content;
    }

    private Properties properties;
    private Session session;
    private MimeMessage correo;

    public EnvioCorreos() {
        properties = new Properties();
    }


    /*TODO : Creamos el objeto que en este caso sera el correo. para ello usamos parametros de entrada
             estos son: Correo(destino), asunto y el contenido.
     */
    public void createEmail(String emailTo, String asunto, String contenido) {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.user", emailFrom);
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.setProperty("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);

        //todo: usamos los setters para aignar nuestros atributos.
        EnvioCorreos.setEmailTo(emailTo);
        EnvioCorreos.setSubject(asunto);
        EnvioCorreos.setContent(contenido);

        try {
            correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress(emailFrom));
            correo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            correo.setSubject(subject);
            correo.setText(content, "ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //todo: en el siguiente metodo enviaremos el correo que antes creamos.
    public void sendEmail() {
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect(emailFrom, passwordFrom);
            transport.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
            transport.close();

            //System.out.println("Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnvioCorreos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


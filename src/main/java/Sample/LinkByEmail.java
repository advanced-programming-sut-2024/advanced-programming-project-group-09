package Sample;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class LinkByEmail {

    private static final String USERNAME = "parhamfaizolahi@gmail.com";
    private static final String PASSWORD = "rloy ifjg jrod ltmt";

    public static void sendAuthenticationEmail(String toEmail, String token) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Authentication Link");

            String link = "http://localhost:8080/authenticate?token=" + token;
            message.setText("Click the following link to authenticate: " + link);

            Transport.send(message);
            System.out.println("Authentication email sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

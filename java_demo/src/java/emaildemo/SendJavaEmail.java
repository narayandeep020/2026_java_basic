package java.emaildemo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJavaEmail {

	public static void main(String[] args) {

		// Setup SMTP Server Properties
		Properties prop = new Properties();

		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		// Setup Credentials
		final String username = "narayandeep020@gmail.com";
		final String password = "@@@@ @@@@ @@@@";

		// Create Session
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Compose Message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("narayandeep020@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("singraul20codeblog@gmail.com"));

			message.setSubject("Testing JavaEmail API");
			message.setText("Hello! This is a test email sent from a java program.");

			// Send Email
			Transport.send(message);
			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}

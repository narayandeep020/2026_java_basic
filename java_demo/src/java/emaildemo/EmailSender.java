package java.emaildemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

	private final String username;
	private final String password;

	private static Properties prop = new Properties();
	private static final String PROPERTIES_FILE = "E:\\application_secret\\email_secrets.properties";

	static {
		loadProperties();
	}

	private static void loadProperties() {
		try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
			prop.load(fis);
			System.out.println("Properties file loaded successfully from: " + PROPERTIES_FILE);
		} catch (Exception e) {
			System.err.println("Error loading properties file: " + e.getMessage());
		}

	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public EmailSender(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void sendEmail(String to, String cc, String subject, String body) throws MessagingException {
		System.out.println("Sending text email to: " + to);

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		if (cc != null && !cc.isEmpty()) {
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
		}
		message.setSubject(subject);
		message.setText(body);

		Transport.send(message);
		System.out.println("Email sent successfully to: " + to);
	}

	public void sendEmailWithAttachment(String to, String cc, String subject, String body, String filePath)
			throws MessagingException {
		System.out.println("Sending email with attachment to: " + to);

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		if (cc != null & !cc.isEmpty()) {
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
		}
		message.setSubject(subject);

		MimeBodyPart text = new MimeBodyPart();
		text.setText(body);

		MimeBodyPart attachment = new MimeBodyPart();
		try {
			attachment.attachFile(filePath);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Multipart multi = new MimeMultipart();
		multi.addBodyPart(text);
		multi.addBodyPart(attachment);

		message.setContent(multi);
		Transport.send(message);
		System.out.println("Email with attachment sent successfully to: " + to);
	}

	public void sendHtmlEmail(String to, String cc, String subject, String htmlBody) throws MessagingException {
		System.out.println("Sending email with HTML body: " + to);

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		if (cc != null && !cc.isEmpty()) {
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
		}
		message.setSubject(subject);
		message.setContent(htmlBody, "text/html");

		Transport.send(message);
		System.out.println("HTML email sent successfully to: " + to);

	}

	public static void main(String[] args) {

		EmailSender emailSend = new EmailSender(prop.getProperty("mail.username"), prop.getProperty("mail.password"));

		// Email send by text
		try {
			emailSend.sendEmail("deepnarayanlodhi1@gmail.com, singraul20codeblog@gmail.com", "narayandeep020@gmail.com",
					"Subject: Test Email", "This is text email sent from java application.");

			// Email sent with attachment
			emailSend.sendEmailWithAttachment("deepnarayanlodhi1@gmail.com, singraul20codeblog@gmail.com",
					"narayandeep020@gmail.com", "Subject: Email with attachment",
					"This is test email sent from java application with attachment.",
					"E:\\application_secret\\back_img.jpg");

			// Email sent with HTML
			emailSend.sendHtmlEmail("singraul20codeblog@gmail.com, deepnarayanlodhi1@gmail.com",
					"narayandeep020@gmail.com", "Subject: Email sent by HTML",
					"<h2>This is test HTML email sent from java application</h2>");
		} catch (MessagingException e) {
			System.out.println("Error email send:" + e.getMessage());
			e.printStackTrace();
		}
	}

}

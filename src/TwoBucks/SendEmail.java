/**
// * <h1>SendEmail</h1>
// * The SendEmail class uses takes the user's financial report, and sends it
// * to the email address they have previously established.
// *
// * <p>
// *
// *
// * @author  Alex Gonzalez
// * @version 1.0
// * @since   03-21-2020
// */

package TwoBucks;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class SendEmail {

    /**
     * sendEmail method: takes the user as a parameter to create
     * and send financial reports to the user's email address.
     * @param user
     */
    public static void sendEmail(User currentUser){

        // credentials for authentication
        final String username = "twobuckssoftware";
        final String password = "tnaufqlvqwabjfzk";

        String fromEmail = "twobuckssoftware@yahoo.com"; // active email where users will receive emails from
        String toEmail = currentUser.getEmail();

        // set properties for the yahoo smtp
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.mail.yahoo.com");
        properties.put("mail.smtp.port","587");

        // creating a new session with authentication of mail server properties
        Session newSession = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });

        // creating a MimeMessage object specific to the session
        MimeMessage message = new MimeMessage(newSession);

        // to time stamp email
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();

        try {
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(currentUser.getFirstName()+"'s Financial Report for" + dateFormatter.format(now));

            // creating a multipart object so that a message can be sent along with an attachment
            Multipart emailContent = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();

            CreateReport report = new CreateReport();
            String[] reportInfo = report.reportContents(currentUser);

            StringBuilder sb = new StringBuilder();

            sb.append("Hello " + currentUser.getFirstName()+"! Your requested user report is displayed below. " +
                    "Thank you for being a valued user of Twobucks!").append(System.lineSeparator()).append(System.lineSeparator());

            for (String element:reportInfo){
                sb.append(element).append(System.lineSeparator());
            }
            textBodyPart.setText(sb.toString());


            //MimeBodyPart txtAttachment = new MimeBodyPart();
            //txtAttachment.attachFile("Users.txt");

            // adding both parts to the contents of the email
            emailContent.addBodyPart(textBodyPart);
            //emailContent.addBodyPart(txtAttachment);

            // bringing information set with the multipart to the email that we want to send
            message.setContent(emailContent);

            // sending the message
             Transport.send(message);
            System.out.println("User report has been successfully sent to "+currentUser.getEmail());
        }catch (MessagingException e) {
            e.printStackTrace();
        }
        /*
        catch (IOException e){
            e.printStackTrace();
        }
        */
    }
}
// To uncomment: Alt + A to select all
// Ctrl + / to remove comment block
//
///**
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
//
//package TwoBucks;
//
//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;
//import javax.mail.Session;
//import javax.mail.Transport;
//
//public class SendEmail {
//
//    /**
//     * sendEmail method: takes the user as a parameter to create
//     * and send financial reports to the user's email address.
//     * @param user
//     */
//    public void sendEmail(User user){
//        // email ID of Recipient.
//        String recipient = user.getEmail();
//
//        // email ID of  Sender.
//        String sender = "twobuckssoftware@yahoo.com";
//
//        // using host as localhost
//        String host = "127.0.0.1";
//
//        // Getting system properties
//        Properties properties = System.getProperties();
//
//        // Setting up mail server
//        properties.setProperty("mail.smtp.host", host);
//
//        // creating session object to get properties
//        Session session = Session.getDefaultInstance(properties);
//
//        try
//        {
//            // MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From Field: adding senders email to from field.
//            message.setFrom(new InternetAddress(sender));
//
//            // Set To Field: adding recipient's email to from field.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//
//            // Set Subject: subject of the email
//            message.setSubject(user.getFirstName()+" "+ user.getLastName()+
//                    "Financial Report");
//
//            // set body of the email.
//            CreateReport report = new CreateReport();
//            String[] userReport = report.reportContents(user);
//
//            for(String element: userReport){
//                message.setText(element);
//            }
//
//            // Send email.
//            Transport.send(message);
//        }
//        catch (MessagingException mex)
//        {
//            mex.printStackTrace();
//        }
//
//    }
//
//
//}

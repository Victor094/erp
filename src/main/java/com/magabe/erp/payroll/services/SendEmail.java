//package com.magabe.erp.payroll.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Document;
//
//
//
//import javax.mail.Message;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class SendEmail {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendMailWithAttachment(String to, String subject, String body, String fileToAttach)
//    {
//        MimeMessagePreparator preparator = new MimeMessagePreparator()
//        {
//            public void prepare(MimeMessage mimeMessage) throws Exception
//            {
//                Document document = new Document();
//
//                PdfWriter.getInstance(document,new FileOutputStream("test.pdf"));
//
//
//                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//                mimeMessage.setFrom(new InternetAddress("admin@gmail.com"));
//                mimeMessage.setSubject(subject);
//                mimeMessage.setText(body);
//
//                FileSystemResource file = new FileSystemResource(new File(fileToAttach));
//                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//                helper.addAttachment("logo.jpg", file);
//            }
//        };
//
//        try {
//            mailSender.send(preparator);
//        }
//        catch (MailException ex) {
//            // simply log it and go on...
//            System.err.println(ex.getMessage());
//        }
//    }
//
//}

package com.SpringBootMaven.Quang.services;

import com.SpringBootMaven.Quang.models.Response.JsonEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;



    public String getBodyHTMLEmail(JsonEmail jsonEmail){

        if(jsonEmail.getLanguage().equals("vi"))
        {
            return "<h3>Xin chào"+jsonEmail.getPatientName()+"!</h3>\n" +
                    "        <p>Bạn nhận được email này vì đã đặt lịch khám bệnh online trên DEADLINE NEVER DIE</p>\n" +
                    "        <p>Thông tin đặt lịch khám bệnh:</p>\n" +
                    "        <div><b>Thời gian: "+jsonEmail.getTime()+"</b></div>\n" +
                    "        <div><b>Bác sĩ: "+jsonEmail.getDoctorName()+"</b></div>\n" +
                    "    \n" +
                    "        <p>Nếu các thông tin trên là đúng, vui lòng click vào liên kế để xác nhận và hoàn tất thủ tục đặt lịch khám bệnh.</p>\n" +
                    "        <div>\n" +
                    "        <a href="+jsonEmail.getRedirectLink()+" target=\"_blank\" >Click here</a>\n" +
                    "        </div>\n" +
                    "    \n" +
                    "        <div> Xin chần thành cảm ơn.</div>\n" +
                    "        <h3>DEADLINE NEVER DIE</h3>\n" +
                    "        <h4>Luôn trong trạng thái dealine để chúng ta tràng đầy sức mạnh</h4>";
        }
        else if (jsonEmail.getLanguage().equals("en"))
        {
            return "<h3>Hello "+jsonEmail.getPatientName()+"!</h3>\n" +
                    "        <p>You are receiving this email because you have made an online appointment for a medical examination on DEADLINE NEVER DIE</p>\n" +
                    "        <p>Appointment information:</p>\n" +
                    "        <div><b>Time: "+jsonEmail.getTime()+"</b></div>\n" +
                    "        <div><b>Doctor: "+ jsonEmail.getDoctorName()+"</b></div>\n" +
                    "        <p>If the above information is correct, please click on the link below to confirm and complete the appointment booking process.</p>\n" +
                    "        <div>\n" +
                    "        <a href="+jsonEmail.getRedirectLink()+" target=\"_blank\" >Click here</a>\n" +
                    "        </div>\n" +
                    "\n" +
                    "        <div>Thank you very much.</div>\n" +
                    "        <h3>DEADLINE NEVER DIE</h3>\n" +
                    "        <h4>Always in a state of deadline to make us full of strength</h4>";
        }
        return "";
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
    public void sendEmail(JsonEmail jsonEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom("<nguyenbuihoangphuoc@gmail.com>");
            messageHelper.setTo(jsonEmail.getReciverEmail());
            if(jsonEmail.getLanguage().equals("vi")){
                messageHelper.setSubject("Thông tin đặt lịch khám bệnh");
            }else {
                messageHelper.setSubject("Information medical appointment");
            }
            String htmlContent = getBodyHTMLEmail(jsonEmail);
            messageHelper.setText(htmlContent, true);
        };
        javaMailSender.send(messagePreparator);
    }



}
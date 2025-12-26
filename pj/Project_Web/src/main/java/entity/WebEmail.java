package entity;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

// Thay đổi toàn bộ javax.mail thành jakarta.mail
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class WebEmail {
	private final static String FROM = "tanvuthien042003@gmail.com";
	private final static String PASSWORD = "jhaqusycurfshecl";
	private Properties props;
	private Authenticator auth;
	private Session session;
	private Message msg;

	public WebEmail() {
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSWORD);
			}
		};
		session = Session.getInstance(props, auth);
		msg = new MimeMessage(session);
	}

	public void sendEmailForgetPassword(String to, String username, String password) {
		try {
			msg.setFrom(new InternetAddress(FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject("Khôi phục mật khẩu Dola Restaurent");
			
            // LƯU Ý: Bạn nên dùng đường dẫn tương đối thay vì ổ D cố định để bạn của bạn cũng chạy được
			String content = new String(Files.readAllBytes(Paths.get("src/main/webapp/emailForgetPassword.jsp")));
            
			content = content.replace("${username}", username);
			content = content.replace("${password}", password);

			msg.setContent(content, "text/html; charset=UTF-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendEmailBill(String to, String id, String name, String address, String email, Cart GioHang,
			String notice, String phone) {
		try {
			msg.setFrom(new InternetAddress(FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject("Hóa đơn thanh toán Dola Restaurent");
			
            // Sửa đường dẫn file tại đây tương tự
			String content = new String(Files.readAllBytes(Paths.get("src/main/webapp/emailBill.jsp")));
            
			content = content.replace("${name}", name);
			content = content.replace("${id}", id);
			content = content.replace("${address}", address);
			content = content.replace("${email}", email);
			content = content.replace("${phone}", phone);
			content = content.replace("${notice}", notice);

			msg.setContent(content, "text/html; charset=UTF-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WebEmail we = new WebEmail();
		we.sendEmailBill("21130170@st.hcmuaf.edu.vn", "123", "Vu tan", "466/7, Bien Hoa, Dong Nai",
				"21130170@st.hcmuaf.edu.vn", null, "Nhieu topping", "0906139533");
	}
}
package com.everlive.framework.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;


public class MailService {

	private static final Logger logger = Logger.getLogger(MailService.class);

	// 定义发件人、收件人、SMTP服务器、用户名、密码、主题、内容等
	private String displayName;
	private String to;
	private String from;
	private String smtpServer;
	private String username;
	private String password;
	private String subject;
	private String content;
	private boolean ifAuth; // 服务器是否要身份认证
	private String filename = "";
	private List<Mail> files = new ArrayList<Mail>(); // 用于保存发送附件的文件名的集合

	/**
	 * 设置SMTP服务器地址
	 */
	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	/**
	 * 设置发件人的地址
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * 设置显示的名称
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 设置服务器是否需要身份认证
	 */
	public void setIfAuth(boolean ifAuth) {
		this.ifAuth = ifAuth;
	}

	/**
	 * 设置E-mail用户名
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * 设置E-mail密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设置接收者
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * 设置主题
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 设置主体内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 该方法用于收集附件名
	 */
	public void addAttachfile(Mail mailFile) {
		files.add(mailFile);
	}

	/**
	 * 初始化SMTP服务器地址、发送者E-mail地址、用户名、密码、接收者、主题、内容
	 */
	public MailService(String smtpServer, String from, String displayName,
			String username, String password, String to, String subject,
			String content) {
		this.smtpServer = smtpServer;
		this.from = from;
		this.displayName = displayName;
		this.ifAuth = true;
		this.username = username;
		this.password = password;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	/**
	 * 初始化SMTP服务器地址、发送者E-mail地址、接收者、主题、内容
	 */
	public MailService(String smtpServer, String from, String displayName,
			String to, String subject, String content) {
		this.smtpServer = smtpServer;
		this.from = from;
		this.displayName = displayName;
		this.ifAuth = false;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	/**
	 * 发送邮件
	 */
	@SuppressWarnings("unused")
	public HashMap<String, String> send() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("state", "success");
		String message = "邮件发送成功！";
		Session session = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);

//		if (ifAuth) { // 服务器需要身份认证
//			props.put("mail.smtp.auth", "true");
//			SmtpAuth smtpAuth = new SmtpAuth(username, password);
//			session = Session.getDefaultInstance(props, smtpAuth);
//		} else {
			props.put("mail.smtp.auth", "false");
			session = Session.getDefaultInstance(props, null);
//		}
		session.setDebug(false);
		Transport trans = null;
		Message msg = null;
		try {
			msg = new MimeMessage(session);
			Address from_address = null;
			try {
				displayName = MimeUtility
						.encodeText(displayName, "gb2312", "B");
				from_address = new InternetAddress(from, displayName);
				msg.setFrom(from_address);
			} catch (java.io.UnsupportedEncodingException e) {
				logger.error(LogUtil.parserBean(from_address), e);
			}
			// 多个收件人
			String[] toArray = to.split(";");
			InternetAddress[] toAdd = new InternetAddress[toArray.length];
			for (int i = 0; i < toArray.length; i++) {
				toAdd[i] = new InternetAddress(toArray[i]);
			}
			InternetAddress[] address = toAdd;
			msg.setRecipients(Message.RecipientType.TO, address);
//			msg.setHeader("Disposition-Notification-To", from);
			try {
				subject = MimeUtility.encodeText(subject, "gb2312", "B");
			} catch (Exception e) {
				logger.error(LogUtil.parserBean(from_address), e);
				// TODO: handle exception
			}

			msg.setSubject(subject);
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(content.toString(), "text/html;charset=GBK");
			mp.addBodyPart(mbp);
			if (!files.isEmpty()) {// 有附件
				for (Mail file : files) {
					mbp = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(file.getFilepath()); // 得到数据源
					mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
					try {
						filename = MimeUtility.encodeText(file.getFilename(),
								"gb2312", "B");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					mbp.setFileName(filename); // 得到文件名同样至入BodyPart
					mp.addBodyPart(mbp);
				}
			}
			msg.setContent(mp); // Multipart加入到信件
			msg.setSentDate(new Date()); // 设置信件头的发送日期
			// 发送信件
			msg.saveChanges();
			trans = session.getTransport("smtp");
			trans.connect(smtpServer, username, password);
			trans.sendMessage(msg, msg.getAllRecipients());
			trans.close();

		} catch (AuthenticationFailedException e) {
			map.put("state", "failed");
			message = "邮件发送失败！错误原因：\n" + "身份验证错误!";
			// e.printStackTrace();
			logger.error(LogUtil.parserBean(msg), e);
		} catch (MessagingException e) {
			message = "邮件发送失败！错误原因：\n" + e.getMessage();
			map.put("state", "failed");
			e.printStackTrace();
			Exception ex = null;
			if ((ex = e.getNextException()) != null) {
				logger.error(LogUtil.parserBean(msg), e);
			}
		}
		map.put("message", message);
		return map;
	}
}

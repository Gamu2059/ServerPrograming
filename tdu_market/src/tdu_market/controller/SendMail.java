package tdu_market.controller;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;
 
public class SendMail {
  public  void sendPassword(String mailAddress,String passWord ) {
	    try {
	        // プロパティの設定
	        Properties props = System.getProperties();
	        // ホスト
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        // 認証（する）
	        props.put("mail.smpt.auth", "true");
	        // ポート指定（サブミッションポート）
	        props.put("mail.smtp.port", "587");
	        // STARTTLSによる暗号化（する）
	        props.put("mail.smtp.starttls.enable", "true");
	   
	        // セッションの取得
	        Session session = Session.getInstance(props);
	   
	        // MimeMessageの取得と設定
	        Message msg = new MimeMessage(session);
	        // 送信者設定
	        msg.setFrom(new InternetAddress("market@gmail.com"));
	        // 宛先設定
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAddress, false));
	        // タイトル設定
	        msg.setSubject("電大マーケット");
	        // 本文設定
	        msg.setText("仮パスワードはこちら："+passWord);
	        // 送信日時設定
	        msg.setSentDate(new Date());
	   
	        // 送信
	        SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
	        try {
	        	//グーグル側のセキュリティ設定が必要だったので注意。
	          t.connect("smtp.gmail.com", "market", "------");
	          t.sendMessage(msg, msg.getAllRecipients());
	        } finally {
	          t.close();
	        }
	   
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	  }
package guis;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import User.GetInfo;
import User.UserLogIn;
import mission.missionSelect;
import mission.missionSelectImpl;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

public class LogFrame {
	GetInfo mf = new GetInfo();
	String mainnickname = mf.fmainnickname;
	int user_pk = mf.fuserpk;
	JFrame frame;
	private JTextArea userLog;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogFrame window = new LogFrame();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public LogFrame() {
		initialize();
		customcursor();
	}
	
	void addLog(String log){
		
		userLog.append(log + "\n");  // 로그 내용을 JTextArea 위에 붙여주고
		
		userLog.setCaretPosition(userLog.getDocument().getLength());  // 맨아래로 스크롤한다.
		
	}
	
	public void customcursor() { // 마우스포인터 ====================================

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorimage = tk.getImage("src/image/대형견_커서.png");
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "haha");
		frame.setCursor(cursor);
	} // =======================================================
	
	private void initialize() {
		missionSelect mis = new missionSelectImpl();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("로그");
	
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel logTextLabel = new JLabel(mainnickname + "의 로그");
		logTextLabel.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 15));
		logTextLabel.setVerticalAlignment(SwingConstants.TOP);
		logTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logTextLabel.setBounds(145, 20, 140, 20);
		frame.getContentPane().add(logTextLabel);
		
		List<String> log = mis.userLogResult(user_pk);
		userLog = new JTextArea();
		userLog.setFont(new Font("경기천년제목 Light", Font.PLAIN, 15));
		String a = "";
		for(int i = 0; i < log.size(); i++) {
			a += log.get(i);
		}
		
		userLog.setText(a);
		userLog.setLineWrap(true); 
		(userLog).setEditable(false);

		
		JScrollPane scroll = new JScrollPane(userLog);
		userLog.setBorder(new LineBorder(new Color(0, 0, 0)));
		scroll.setBounds(18, 50, 400, 350);
		userLog.setBounds(18, 50, 400, 350);
		
		frame.getContentPane().add(scroll);
		
		JButton 닫기버튼 = new JButton("닫기");
		닫기버튼.setBackground(new Color(200, 230, 250));
		닫기버튼.setFont(new Font("경기천년제목 Bold", Font.PLAIN, 15));
		닫기버튼.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();  // hj 메인 나오게================
				mainFrame.frame.setVisible(true);
				mainFrame.frame.setLocationRelativeTo(null); 
				mainFrame.frame.setResizable(false);  // =====================
				frame.dispose();
			}
		});
		닫기버튼.setBounds(291, 430, 124, 45);
		frame.getContentPane().add(닫기버튼);
	}


	private void add(JScrollPane scroll) {
		// TODO Auto-generated method stub
		
	}
}

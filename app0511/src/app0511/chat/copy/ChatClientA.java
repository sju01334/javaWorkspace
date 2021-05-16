package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientA extends JFrame implements ActionListener, KeyListener{
	JButton bt_open; //대화상대방을 띄우기 위한 버튼
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	ChatClientB cb;//내가 제어하고싶은 상대방 창에 대한 레퍼런스 변수
	
	public ChatClientA() {
		//생성
		bt_open=new JButton("열기");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField(19);
		bt=new JButton("전송");
		
		//레이아웃, 스타일
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280, 280));
		area.setBackground(new Color(250,255,0));
		
		//조립
		add(bt_open);
		add(scroll);
		add(t_input);
		add(bt);
		
		//이벤트리스너와 연결
		bt.addActionListener(this);//액션 리스너 객체==나
		bt_open.addActionListener(this);
		
		//텍스트필드와 리스너 연결
		t_input.addKeyListener(this);//키 리스너 객체==나

		
		//보여주기
		setBounds(300, 100, 300, 400);//x,y,width,height
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER) {
			showText();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//열기버튼 누르면
		if(e.getSource()==bt_open) {
//			System.out.println("열기 눌렀네");
			
			cb=new ChatClientB(this);
//			cb.setArea2(area);
		}else if(e.getSource()==bt) {//전송버튼 누르면
//			System.out.println("전송 눌렀네");
			showText();
		}
		
	}
	
	//전송처리
	public void showText() {
		
		String msg=this.t_input.getText();//1. JTextField 값 가져오기
		this.area.append(msg+"\n");//2. JTextArea에 누적
		this.t_input.setText("");//3.기존 입력값 초기화
		
		//친구인 상대방 채팅창의 area.append();
		cb.area.append(msg+"\n");
		
	}
	
	public static void main(String[] args) {
		new ChatClientA();
	}
}

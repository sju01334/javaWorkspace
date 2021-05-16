package app0511.chat.copy.solution;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	private ChatClientA chatClientA;
	private ChatClientC chatClientC;
	
//	private JTextArea area2; //ChatA가 보유한 JTextArea 의 주소값
	
	
	//ChatA를 통채로 받을 수 있다
	public ChatClientB() {
		
		//생성
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField(19);
		
		//레이아웃, 스타일
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280, 280));
		area.setBackground(Color.CYAN);
		
		//조립
		add(scroll);
		add(t_input);
		
		//이벤트리스너와 연결
		t_input.addKeyListener(this);

		
		//보여주기
		setBounds(600, 100, 300, 400);//x,y,width,height
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	



	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			showText();
		}
	}
	

	//setter
	public void setChatClientA(ChatClientA chatClientA) {
		this.chatClientA = chatClientA;
	}


	public void setChatClientC(ChatClientC chatClientC) {
		this.chatClientC = chatClientC;
	}





	public void showText() {
		//1. 나의 TextField 값 구하기
		String msg=t_input.getText();
		//2. 나의 TextArea 누적
		area.append(msg+"\n");
		//3. ChatA의 TextArea에도 누적
		chatClientA.area.append(msg+"\n");
		chatClientC.area.append(msg+"\n");
		//4. 입력값 다시 초기화
		t_input.setText("");
	}
}

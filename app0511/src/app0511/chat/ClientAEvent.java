package app0511.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//ChatClientA 에 대한 이벤트 처리 클래스 정의
//implements를 선언하는 순간부터 ActionEvent 를 청취할 수 있다

public class ClientAEvent implements ActionListener, KeyListener{

	private JTextField t_input;//null
	private JTextArea area;
	private JButton bt_open, bt; //대화상대방을 띄우기 위한 버튼

	@Override
	public void actionPerformed(ActionEvent e) {
		//이 메스드의 인수로 전달되는 e 변수에는 사용자가 일으킨 Action 관련한 모든정보가 들어있다
		//ex) who?, where?, when?, ,,,,
		JButton btn=(JButton)e.getSource();
//		System.out.println("사용자에 의해 생성된 이벤트 정보는"+btn);
		
		if(btn==bt) {
			System.out.println("전송을 원하시네요");
			showText();
		}else if(btn==bt_open){
			System.out.println("열기를 원하시네요");
		}
//		String msg=t_input.getText();
//		System.out.println(msg);
	}
	
	
	
	//setter 정의
	public void setT_input(JTextField t_input) {
		this.t_input=t_input;
	}
	public void setArea(JTextArea area) {
		this.area=area;
	}
	public void setBt(JButton bt) {
		this.bt=bt;
	}
	public void setBt_open(JButton bt_open) {
		this.bt_open=bt_open;
	}
	
	
	
	public void showText() {
		//1. JTextField의 값 얻기
		String msg=t_input.getText();
		
		//2. JTextArea에 값 누적
		area.append(msg+"\n");
		
		//3.모든 입력갑 초기화
		t_input.setText("");
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		System.out.println(key);
		if(key==KeyEvent.VK_ENTER) {
			showText();			
		}
		
	}
	
	
	
}

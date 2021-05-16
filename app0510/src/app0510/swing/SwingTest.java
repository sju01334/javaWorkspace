/*
*AWT 자바의 GUI API 를 대부분 지원하긴 하지만, 플랫폼(OS) 마다 디자인이 일관적이지 않다는 문제점
*이부분을 해결하기 위해서 swing API 로 확장해서 GUI 를 구현할 수 있다
*기존 우리가 알고있던 컴포넌트 접두어에 J 가 붙는다
*Swing은 기존 AWT 와 다르게 스윙만의 룩앤필(Look&Feel) 이 있다.
*/
package app0510.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	JButton bt; //has a 관계
	
	//has a 관계로 다른 객체를 보유a할경우, 개발자는 생성자 적극활용
	//왜? has a 란 부품을 보유한 관계이므로, 해당 본체가 태어날떄 같이 태어나야한다
	
	public SwingTest() {
		//생성
		bt=new JButton("나버튼");
		
		//스타일
		this.setSize(new Dimension(300,400));
		
		//조립
		this.setLayout(new FlowLayout());
		this.add(bt);
		
		//보여주기
		this.setVisible(true);
		
		//스윙은 윈도우 창닫기 버튼은 그냥 setVisible false로 두는 것 뿐이다
		//해결책? 1) 이벤트 구현하는법  2)알맞는 메서드 호출
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new SwingTest();
	
	}
}

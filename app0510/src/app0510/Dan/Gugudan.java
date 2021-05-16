package app0510.Dan;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import app0510.event.ActionControl;

public class Gugudan extends JFrame{
	JTextField t_input;
	JButton bt;
	
	public Gugudan() {
		//생성
		t_input=new JTextField(20);
		bt=new JButton("출력");
		
		//조립
		this.setLayout(new FlowLayout());//FlowLayout 으로 전환
		add(t_input);
		add(bt);
		
		//리스너
		GugudanEvent ge=null;
		bt.addActionListener(ge=new GugudanEvent(t_input));
		
//		ge.callMe(2);//call by value
//		ge.callMe("hello");//call by reference
//		ge.callMe(bt);//call by reference
//		ge.callMe(t_input);//call by reference
		
		//보여주기
		setSize(250, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Gugudan();
	}
	
}

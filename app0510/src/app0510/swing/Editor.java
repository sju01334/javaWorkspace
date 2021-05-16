package app0510.swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*Swing 을 이용한 편집기 디자인 해보기*/
public class Editor extends JFrame {
	JMenuBar bar; //메뉴들이 얹혀질 바
	
	//자바에서는 배열 선언시 반드시 크기를 명시해야 한다
	//반면 자바스크립트는 배열의 크기를 동적으로 지정할 수 있다 //var arr=new Array();
	JMenu[] menu=new JMenu[5];
	String[] menu_title= {"파일", "편집", "서식", "보기", "도움말"};
	JMenuItem[] item=new JMenuItem[8];
	String[] item_title={"새로만들기", "새창", "열기", "저장", "다른이름으로 저장", "페이지 설정", "인쇄", "끝내기"};
	
	JTextArea area; //편집영역
	JScrollPane scroll; ///스크롤바 역할 수행
	
	
	public Editor() {
		//생성
		bar=new JMenuBar();//바생성
		
		for (int i = 0; i < menu_title.length; i++) {			
			menu[i]=new JMenu(menu_title[i]);//메뉴생성
			menu[i].setForeground(Color.white);
		}
		for (int i = 0; i < item_title.length; i++) {
			item[i]=new JMenuItem(item_title[i]);
		}
		area=new JTextArea();
		scroll=new JScrollPane(area); //JTextArea는 Component 의 자손이므로 인수로 올수있다
		
		
		//스타일
		bar.setBackground(Color.black);
		
		//조립
		//Menu 관련 컴포넌트들은 레이아웃 지정할 수 없다.
		//즉 언제나 상단에 온다(레이아웃 적용 없이 사용)
		//바에 5개 메뉴 엊히기
		for (int i = 0; i < menu.length; i++) {
			bar.add(menu[i]);
		}
		for (int i = 0; i < item.length; i++) {
			menu[0].add(item[i]);
			if(i==4 || i==6) {
				menu[0].addSeparator();//구분선 
			}
		}
		this.setJMenuBar(bar); //add를 사용하지 않고, Bar 부착을 위한 전용메소드 사용
		add(scroll);
		
		//보여주기
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Editor();
	}
}

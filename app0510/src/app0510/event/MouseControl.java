package app0510.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//마우스 이벤트를 청취하는 MouseListener 를 재정의
public class MouseControl implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스클릭");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

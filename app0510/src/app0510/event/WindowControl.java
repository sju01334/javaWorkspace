package app0510.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//윈도우 이벤트를 감지하는 WindowListener 를 재정의 해보자
public class WindowControl implements WindowListener{

	   @Override
	   public void windowOpened(WindowEvent e) {
	      System.out.println("windowOpened");
	      
	   }

	   @Override
	   public void windowClosing(WindowEvent e) {
	      System.out.println("windowClosing");
	      
	   }

	   @Override
	   public void windowClosed(WindowEvent e) {
	      System.out.println("windowClosed");
	      
	   }

	   @Override
	   public void windowIconified(WindowEvent e) {
	      System.out.println("windowIconified");
	      
	   }

	   @Override
	   public void windowDeiconified(WindowEvent e) {
	      System.out.println("windowDeiconified");      
	   }

	   @Override
	   public void windowActivated(WindowEvent e) {
	      System.out.println("windowActivated");
	      
	   }

	   @Override
	   public void windowDeactivated(WindowEvent e) {
	      System.out.println("windowDeactivated");
	      
	   }


}

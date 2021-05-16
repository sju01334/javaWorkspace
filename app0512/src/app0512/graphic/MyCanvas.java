package app0512.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	MoveTest moveTest;//null
	
	public MyCanvas(MoveTest moveTest) {
		this.moveTest=moveTest;
	}
	
	/*켄버스에 그려질 그림을 개발자가 주도하여, 원하는 
	그림을 그려보자!!
	paint 메서드에 대하여
	특징 : 개발자가 paint 메서드를 호출해서는 안된다
			why? 자바의 모든 컴퐅넌트는 스스로를 그린다. 즉 paint 메서드는 시스템이 그래픽의
			렌더링시 필요에 의해 호출하게 됨
			언제 호출? 처음의 그림과 비교해서 바뀐부분이 있다면, 시스템이 알아서 다시 호출
			동작원리 : 사실 다시 그리는 과정은 내부적으로 아래의 절차를 거친다
						1. 기존의 그림을 지운다.(update 메서드)
						2. 그림을 그린다(paint 메서드)
			문제점 : 사용자가 윈도우 창의크기를 변화시킨다거나, 하는 그래픽상의 변화를 통해
						paint() 메서드를 호출하는게 아니라, 개발자가 원하는 시점에 프로그래밍적으로
						paint()를 호출하는 방법은없을까     ex)버튼 누를떄 그림 다시 그리게
						sun에서는 그래픽이 화면에 반영되는 처리는 시스템이 하기 때문에 paint()메서드
						호출을 원칙적으로 막아놓았다. 따라서 개발자는 시스템에게 paint()가 호출될수 
						있도록 간접적으로 요청하는 방식으로 그래픽처리를 할 수 있다
						이때 호출하는 메서드 repaint()
						repaint() 그래픽의 갱신을 요청하게되고, 이때 이 요청이 들어오면 update()가 호출되고
						화면을 지우며, 화면을 지우고 나서 깨끗해지면  paint()
						repaint() --> update() --> paint()
	*/
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);//이 시점부터는, 노란색으로 그려진다...
		g.fillOval(moveTest.x, 100, 100, 100);
	}
}

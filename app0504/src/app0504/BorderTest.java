package app0504;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/*배치관리자 중 BorderLayout은 북, 동, 서, 남 센터라는 방위를 갖는 배치법.
 즉, 5가지 방위에 따른 위치가 이미 정해져있다.*/
public class BorderTest {
   public static void main(String[] args) {
      Frame frame = new Frame("BorderLayout");
      
      BorderLayout layout = new BorderLayout();
      //레이아웃 메니저 생성
      
      frame.setLayout(layout);//frame에 BorderLayout적용
      
      Button bt_north = new Button("North");
      Button bt_east = new Button("East");
      Button bt_south = new Button("South");
      Button bt_west = new Button("West");
      Button bt_center = new Button("Center");
      
      //방향값은 BorderLayout이 상수로 보유.
      //public static final 대문자
      frame.add(bt_north, BorderLayout.NORTH);
      frame.add(bt_east, BorderLayout.EAST);
      frame.add(bt_south, BorderLayout.SOUTH);
      frame.add(bt_west, BorderLayout.WEST);
      frame.add(bt_center, BorderLayout.CENTER);
      
      //setSize, setVisible
      frame.setSize(400,250);
      frame.setVisible(true);
   }
}
package app0510.Dan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class GugudanEvent implements ActionListener{
	JTextField t_input;
	
	//생성자
	public GugudanEvent(JTextField t_input) {
		System.out.println("이벤트 클래스 생성시 넘겨받은 t_input"+ t_input);
		this.t_input=t_input;
	}

//	public void callMe(int x) {
//		System.out.println("넘겨받은 x는"+ x);
//	}
//	public void callMe(String y) {
//		System.out.println("넘겨받은 y는"+y);
//	}
//	public void callMe(JButton bt) {
//		System.out.println("넘겨받은 bt는"+bt);
//	}
//	public void callMe(JTextField t_input) {
//		this.t_input=t_input;
//	}
//	
	@Override
	public void actionPerformed(ActionEvent e) {
		//나 아닌 다른 클래스에 존재하는 TextField 값에 무엇이 들어있는지 알아 맞추기
		printDan();
	}

	public void printDan() {
		//자바에서 TextField 값 얻기(JTextField의 api 문서 참고)
		String dan=t_input.getText();
		System.out.println("당신이 입력한 단은 "+dan);
		/*
		 *자바스크립트에서는 문자열을 정수로 변환을 위해 parseInt() 함수를 지원
		 *자바에서도 동일한 기능 지원(api 가 약간 다르다)
		 *즉 자바에서는 문자열인 String 형 즉 객체자료형을 기본자료형으로 변경한다는것 자체가 불가능
		 *Dog(객체자료형) --> 7(기본자료형) 불가
		 *7(기본자료형) --> Dog(객체자료형) 불가
		 *
		 *아래와 같이 String 형에 대해서는 (특별) 기본자료형과의 형변환을 허용해준다
		 *이때 사용되는 객체가 Wrapper 클래스이다
		 *String s="5" --> 5
		 *Wrapper Class
		 * - 자바의 모든 기본 자료형에 대해서는 1:1 대응하는 Wrapper 클래스가 지원된다
		 * - 사용목적 : (1) 기본 자료형과 객체자료형간의 변환시 사용됨   "5" --> 5
		 * 					(2) 기본 자료형과 관련된 다양한 작업을 지원하기 위해 기본 자료형을 객체차원에서 
		 * 						지원하기 위해 (why? 기본자료형을 객체형으로 변환시 메서드, 속성을 이용할 수 있기 때문)
		 * 문자 : char
		 * 논리값 : boolean
		 * 숫자 : 정수 - byte		short		int			long
		 * 					Byte		Short		Integer	Long		(Wrapper 클래스 라고 한다(정수를 객체로 감싸서))
		 * 			실수 - float		double
		 * 					Float		Double
		 */
		
//		String x="8";
//		Integer.parseInt(x); //"8" 쌍따옴표를 제거하여 정수 8로 변환
		int d=Integer.parseInt(dan);
		
		for (int i = 0; i <= 9; i++) {
			System.out.println(d+"*"+i+"="+(d*i));
		}
	}
}

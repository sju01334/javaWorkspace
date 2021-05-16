/*
 * Java의 기본 자료형마다 1:1 대응되는 객체가 지원되는데, 이러한 클래스를 가리켜 Wrapper 클래스라 한다

*/
package app0511.wrapper;

public class WrapperTest {

	public static void main(String[] args) {
		Integer it=new Integer(7);
		Integer it2=9; //가능함
		//it2가 레퍼런스 변수임에도 불구하고, 이 코드가 가능
		//내부적으로 9라는 정수를 객체화 시켜준것. 이 현상을 Wrapping 이라고 한다.
		//이런 형변환을 가리켜 sun에서는 Boxing 이라고 한다(즉, 기본자료형이 객체자료형으로 형변환된 현상)
		
		int k=it2;//객체 자료형이 기본자료형으로 자동으로 형변환 되는것, unBoxing 이라고 한다
	}
}

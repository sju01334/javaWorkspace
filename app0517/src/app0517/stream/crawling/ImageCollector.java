package app0517.stream.crawling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageCollector {
	//이 객체는 안드로이드에서도 동일하게 쓰인다
	URL url; //URL(Uniformed Resource Location : 자원의 위치)
	URLConnection con;//웹 서버에 요청을 시도할 수 있는 객체
	HttpURLConnection http;//URLConnection의 자식 객체 즉 Http  프로토콜에 최적화된 자식
	String path="https://upload.wikimedia.org/wikipedia/ko/b/ba/%EC%95%88%EB%85%95_%EC%9E%90%EB%91%90%EC%95%BC_%EC%B5%9C%EC%9E%90%EB%91%90.jpg";
	FileOutputStream fos; //파일을 대상으로 한 바이트 기반의 출력스트림
	
	
	public ImageCollector() {
		InputStream is=null;
		
		try {
			url=new URL(path);
			System.out.println("자원에 접근가능");
			con=url.openConnection();
			http=(HttpURLConnection)con; //다운캐스팅!! 같은 자료형 이므로 형변환 가능
			http.setRequestMethod("GET");
			
			//웹서버에 요청을 시도해보자
			is=http.getInputStream(); //웹서버와의 요청시 생성된 입력스트림
			fos=new FileOutputStream("C:\\koreaIT\\javaworkspace\\app0517\\res\\target.jpg");//복사될 파일 즉 생성될 파일의 경로
			
			long startTime=System.currentTimeMillis(); //현재시간을 밀리second 로 반환
			//이 입력스트림으로 서버의 자원을 가져올 수 있다.
			int data=-1;
			byte[] b=new byte[1024];
			while(true) {
				data=is.read(b);//1byte 읽기
				if(data==-1)break;
				System.out.println(data);
				fos.write(b);//1byte 씩 파일에 내려쓰기!
			}
			System.out.println("인터넷상의 이미지를 수집완료 했습니다. 디렉토리를 확인해보세요");
			
			//InputStream 은 입력스트림과 관련된 객체들의 최상위 객체
			long endTime=System.currentTimeMillis(); //현재시간을 밀리second 로 반환
			
			System.out.println("다운로드 소요시간은: "+(endTime-startTime));
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();//개발자를 위한 로그 출력
			System.out.println("주소가 올바르지 않습니다.");//일반인 들을 위한 메세지
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ImageCollector();
	}
}

package db.oracle;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;//���� ���� ��, �ش� DB�� ���� ���������� ���� ��ü
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class TestOracle{
	public static void main(String[] args){
		String url="jdbc:oracle:thin:@localhost:1521:XE"; //������ ���ڿ�
		String user="javase";
		String pass="javase";

		Connection con=null;//���� ������, ���� ������ ���� ��ü
		PreparedStatement pstmt=null; //������ ���ఴü
		ResultSet rs=null;//select�� ���� �� �� ��� ǥ������ ��°�ü

		/*
         1.����Ϸ��� DB�� �´� ����̹� �ε�(Ŭ���� �ε�)
            Class.forName()
         2.DB����
         3.������ ����
         4.DB���� ��ü ����
		*/
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			System.out.println("����̹� �ε� ����");

			con=DriverManager.getConnection(url, user, pass);
			if(con!=null){

				//���� ������ �ƴ�, ������ ������ �� �ִ� ��ü ���� �� �غ� �Ѱ� 
				pstmt=con.prepareStatement("select * from member");

				rs=pstmt.executeQuery(); //select ���� ��� ��ȯ��ü�� �ֱ� ������

				while(rs.next()){
					//����Ŀ���� ����Ű�� rows�� �÷����� �ϳ� ��������
					/*
					int member_id=rs.getInt("member_id");
					String user_id=rs.getString("user_id");//�μ��δ� �÷����̿´�
					String password=rs.getString("password");
					String name=rs.getString("name");
					String regdate=rs.getString("regdate");
					*/

					//�÷��� index�ε� �����غ���!!
					int member_id=rs.getInt(1); //ù��° �÷� 
					String user_id=rs.getString(2); //�ι�° �÷� 
					String password=rs.getString(3); //����° �÷� 
					String name=rs.getString(4); //�׹�° �÷� 
					String regdate=rs.getString(5); //�ټ���° �÷� 




					System.out.println(member_id+"\t"+user_id+"\t"+password+"\t"+name+"\t"+regdate);

				}


				//ResultSet�� ��ȯ���� ���Ŀ��� ��� ���ڵ嵵 ����Ű�� �ʰ��ִ�
			}else{
				System.out.println("���Ӽ���");
			}


		}catch(ClassNotFoundException e){
			e.printStackTrace(); //�����ڰ� ������ �м��ϱ� ���� ���
			System.out.println("����̹��� ã�� �� �����ϴ�");//������ ���� ģ���� �޼���
		}catch(SQLException e){//��Դ�����?
			//DriverManager.getConnction() ���� ������ �õ��ϴٰ� ������ ���� SQLException 
			//������ ����� ������ ���� SQLException �̴�
			//�� sun������ ����ȭ��Ű�� �ʾҴ�.. �� SQLException�� �ʹ� �������� ���ܸ� ����Ѵ�
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{rs.close();}catch(SQLException e){e.printStackTrace();}
			}
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException e){e.printStackTrace();}
			}
			if(con!=null){
				try{con.close();}catch(SQLException e){e.printStackTrace();}
			}



		}


	}
}	
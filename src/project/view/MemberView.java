package project.view;

import project.dto.MemberShipDTO;

public class MemberView {
	
	public static void print(MemberShipDTO member) {
		if(member == null) {
			print("�α��� ���� >> ��ȸ�� ȸ�������� �����ϴ�");
			return;
		}
	}

	public static void print(String message) {
		System.out.println("====�˸�====");
		System.out.println(message);
		
	}

}

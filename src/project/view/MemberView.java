package project.view;

import project.dto.MemberShipDTO;

public class MemberView {
	
	public static void print(MemberShipDTO member) {
		if(member == null) {
			print("로그인 실패 >> 조회된 회원정보가 없습니다");
			return;
		}
	}

	public static void print(String message) {
		System.out.println("====알림====");
		System.out.println(message);
		
	}

}

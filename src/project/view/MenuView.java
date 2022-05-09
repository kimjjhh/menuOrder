package project.view;

import java.util.List;

import project.dto.MenuDTO;

public class MenuView {
	
	public static void print(List<MenuDTO> mList) {
		if(mList.size()==0) {	print("조회된 메뉴가 없습니다"); return;}
		System.out.println("========전체메뉴=========");
		for(MenuDTO menu:mList) {
			System.out.println(menu);
		}
	}
	
	public static void print(MenuDTO menu) {
		if(menu == null) {
			print("조회된 메뉴가 없습니다");
			return;
		}
		System.out.println("=================");
		System.out.println(menu);
	}

	private static void print(String message) {
		System.out.println("=====알림=====");
		System.out.println(message);
		
	}

}

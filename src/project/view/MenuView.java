package project.view;

import java.util.List;

import project.dto.MenuDTO;

public class MenuView {
	
	public static void print(List<MenuDTO> mList) {
		if(mList.size()==0) {	print("��ȸ�� �޴��� �����ϴ�"); return;}
		System.out.println("========��ü�޴�=========");
		for(MenuDTO menu:mList) {
			System.out.println(menu);
		}
	}
	
	public static void print(MenuDTO menu) {
		if(menu == null) {
			print("��ȸ�� �޴��� �����ϴ�");
			return;
		}
		System.out.println("=================");
		System.out.println(menu);
	}

	private static void print(String message) {
		System.out.println("=====�˸�=====");
		System.out.println(message);
		
	}

}

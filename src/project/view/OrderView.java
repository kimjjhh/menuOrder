package project.view;

import java.util.List;

import project.dto.OrderDTO;
import project.dto.OrderJoinVO;

public class OrderView {
	
	public static void print(List<OrderJoinVO> oList) {
		if(oList.size()==0) {print("��ȸ�� �ֹ������� �����ϴ�"); return;}
		System.out.println("========��ü�ֹ�=========");
		for(OrderJoinVO order:oList) {
			System.out.println(order);
		}
	}

	public static void print(String message) {
		System.out.println("=====�˸�=====");
		System.out.println(message);
		
	}

	public static void print(OrderDTO order) {
		// TODO Auto-generated method stub
		
	}

}

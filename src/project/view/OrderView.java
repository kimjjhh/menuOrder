package project.view;

import java.util.List;

import project.dto.OrderDTO;
import project.dto.OrderJoinVO;

public class OrderView {
	
	public static void print(List<OrderJoinVO> oList) {
		if(oList.size()==0) {print("조회된 주문정보가 없습니다"); return;}
		System.out.println("========전체주문=========");
		for(OrderJoinVO order:oList) {
			System.out.println(order);
		}
	}

	public static void print(String message) {
		System.out.println("=====알림=====");
		System.out.println(message);
		
	}

	public static void print(OrderDTO order) {
		// TODO Auto-generated method stub
		
	}

}
